package grpc.service2;

import java.io.IOException;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class HealthMonitoringServer extends HealthMonitoringServiceGrpc.HealthMonitoringServiceImplBase {
	
	public static void main(String args []) throws IOException, InterruptedException {
		
		// Set the server port, service type, service name, and service description
        int port = 5002;
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "health-monitoring-service";
        String serviceDescription = "Health Monitoring Service";
        
        // Create the server
        HealthMonitoringServer healthMonitoringServer = new HealthMonitoringServer();
        Server server = ServerBuilder.forPort(port)
                .addService(healthMonitoringServer)
                .build();

        // Register the service using jmDNS
        try { 
            JmDNS jmdns = JmDNS.create(); // Create a new JmDNS instance
            // Create a new service info with the service type, service name, port, and service description
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDescription);
            jmdns.registerService(serviceInfo); // Register the service with jmDNS
            System.out.println("Registered service: " + serviceInfo); // Print a message indicating that the service has been registered successfully
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start the server
        try {
            server.start();
            System.out.println("Server started, listening on " + port);  // Print a message indicating that the server has started
            server.awaitTermination(); // Wait for the server to terminate
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void trackSteps(UserStepsRequest request, StreamObserver<UserStepsResponse> responseObserver) {
            
        Random random = new Random();  // Generate a random number to simulate the user's current steps
        // Set a step goal and initialize variables
        boolean goalAchieved = false; 
        int goal = 7000;
        int currentSteps = random.nextInt(15000);
        
        // Loop through 10 iterations to simulate 10 updates to the user's steps
        for(int i = 0; i < 10; i++) {
        	// Increment the user's steps
            currentSteps = currentSteps + 1;
            // Calculate the user's average steps
            int averageSteps = currentSteps / 2;
            // Check if the user has achieved their step goal
            if(currentSteps >= goal) {
                goalAchieved = true;
            } 
            
            // Build the response with the current step count, goal status, and average step count
            UserStepsResponse response = UserStepsResponse.newBuilder()
                    .setCurrentSteps(currentSteps)
                    .setGoalAchieved(goalAchieved)
                    .setAverageSteps(averageSteps)
                    .build();
            
            // Send the response to the client
            responseObserver.onNext(response);
            
            try { 
            	// Wait for 1 second before sending the next update
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Signal to the client that the stream is complete
        responseObserver.onCompleted();
    }

	
	@Override
	public void hearthRate(UserHearthRateRequest request, StreamObserver<UserHearthRateResponse> responseObserver) {
		
		// Create a new random number generator.
		Random random = new Random();
		// Initialize variables for current heart rate and warning message.
		String warning_message = "";
		int current_hearth_rate = 0;
		
		// Generate 10 heart rate values.
		for(int i = 0; i < 10; i++) {
			// Generate a random heart rate value.
			current_hearth_rate = random.nextInt(141) + 40;
			// Set the warning message based on the current heart rate value.
			if(current_hearth_rate < 40) {
				warning_message = "Warning, Hearth rate to low!";
			} else if(current_hearth_rate > 140) {
				warning_message = "Warning, Hearth rate to high!";
			} else {
				warning_message = "Heart Rate within normal.";
			}
			
			// Build a response with the current heart rate value and warning message.
			UserHearthRateResponse response = UserHearthRateResponse.newBuilder()
					.setCurentHearthRate(current_hearth_rate)
					.setWarningMessage(warning_message)
					.build();
			
			// Send the response to the client.
			responseObserver.onNext(response);
			
			try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		// Signal that the server has completed sending responses.
		responseObserver.onCompleted();
		
		
	}
	@Override
	public void trackSleep(UserSleepRequest request, StreamObserver<UserSleepResponse> responseObserver) {
		// Calculate the total sleep time in minutes
	    int totalSleepTime = (int) (request.getWakeupTime().getSeconds() - request.getSleepTime().getSeconds()) / 60;
	    // Set the length of a sleep cycle
	    int sleepCycleMinutes = 90;
	    // Calculate the number of sleep cycles
	    double numberOfCycles = (double) totalSleepTime / sleepCycleMinutes;
	    double idealCycles = Math.round(numberOfCycles);
	    double deviation = Math.abs(numberOfCycles - idealCycles);

	    // Calculate the sleep score, scale it within the range of 0-100.
	    double sleepScore = 100 - (deviation / idealCycles) * 300;

	    // Determine if the user has a sleep disorder
	    SleepDisorder sleepDisorder = SleepDisorder.NONE;
	    if (request.getSnorintTimeMinutes() > 30) {
	        sleepDisorder = SleepDisorder.SLEEP_APNEA;
	    }

	    // Create a UserSleepResponse object with the calculated values
	    UserSleepResponse response = UserSleepResponse.newBuilder()
	            .setTotalSleepTimeMinutes(totalSleepTime)
	            .setSleepScore(sleepScore)
	            .setSleepDisprder(sleepDisorder)
	            .build();

	    // Send the UserSleepResponse object to the client
	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}



	
    @Override
    public StreamObserver<UserStressRequest> trackStress(StreamObserver<UserStressResponse> responseObserver) {
    	
    	// Define a new StreamObserver for UserStressRequest
        return new StreamObserver<UserStressRequest>() {
        	// Initialize total heart rate to 0
            private int totalHearthRate = 0;
            // Initialize total breathing rate to 0
            private int totalBreathingRate = 0;
            // Initialize the number of requests to 0
            private int numRequests = 0;

            @Override
            public void onNext(UserStressRequest request) {
            	// Increment the total heart rate and total breathing rate
                totalHearthRate += request.getHearthRate();
                totalBreathingRate += request.getBreathingRate();
                numRequests++;
                // Calculate the stress level, get the advice and create a UserStressResponse
                float stressLevel = calculateStressLevel(totalHearthRate, totalBreathingRate, numRequests);
                String advice = getAdvice(stressLevel);
                UserStressResponse response = UserStressResponse.newBuilder()
                        .setStresLeve(stressLevel)
                        .setAdvice(advice)
                        .build();
                
                // Send the UserStressResponse to the client
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted(); // Complete the response
            }

            // Helper function to calculate stress level based on heart rate and breathing rate
            private float calculateStressLevel(int totalHearthRate, int totalBreathingRate, int numRequests) {
            	Random random = new Random();
            	
                if(totalHearthRate > 120 && totalBreathingRate > 25) {
                	//randomly generate number between 65 and 99
                	float stressLevel = 65 + random.nextFloat() * 34;
                	return stressLevel;
                } else if(totalHearthRate < 60 && totalBreathingRate < 12) {
                	//randomly generate number between 10 and 40
                	float stressLevel = 10 + random.nextFloat() * 30;
                	return stressLevel;
                } else {
                	//randomly generate number between 40 and 65
                	float stressLevel = 40 + random.nextFloat() * 25;
                	return stressLevel;
                }
            }

            // Helper function to get advice based on stress level
            private String getAdvice(float stressLevel) {
                if(stressLevel >= 65) {
                	return "Waning, Stress level to high. Take several deep breaths";
                } else if(stressLevel <= 40 && stressLevel > 10) {
                	return "Warning, breathing and hearth rate to low.";
                } else if(stressLevel > 40 && stressLevel < 65) {
                	return "Stress levels normal.";
                } else {
                	return "Wrong data";
                }
            }
        };
    }

}
