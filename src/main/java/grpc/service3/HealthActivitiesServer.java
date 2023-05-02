package grpc.service3;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.service2.HealthMonitoringServer;
import grpc.service3.HealthActivitiesServer;
import grpc.service3.HealthActivitiesServiceGrpc.HealthActivitiesServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class HealthActivitiesServer extends HealthActivitiesServiceImplBase {

    public static void main(String[] args) throws IOException, InterruptedException {
		
    	// Define the port number, service type, service name, and service description
        int port = 5003;
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "health-activities-service";
        String serviceDescription = "Health Activities Service";
        
        // Create the server
        HealthActivitiesServer healthActivitiesServer = new HealthActivitiesServer();
        Server server = ServerBuilder.forPort(port)
                .addService(healthActivitiesServer)
                .build();

        // Register the service using jmDNS
        try {
            JmDNS jmdns = JmDNS.create(); // Create a JmDNS instance
            // Create a ServiceInfo object with the service type, name, port, and description
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDescription);
            jmdns.registerService(serviceInfo); // Register the service with jmDNS
            System.out.println("Registered service: " + serviceInfo); // Print a message indicating that the service has been registered
        } catch (IOException e) { 
            e.printStackTrace();
        }

        // Start the server
        try {
            server.start();
            // Print a message indicating that the server has started and is listening on the specified port
            System.out.println("Server started, listening on " + port);
            server.awaitTermination(); // Wait for the server to terminate
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	 @Override
     public void exercise(ExerciseRequest request, StreamObserver<ExerciseResponse> responseObserver) {
		    // Extract the exercise type from the request
		    String exerciseType = request.getExerciseType();
		    // Generate random values for duration and heart rates
		    int durationMinutes = (int) (Math.random() * 120) + 30; // Random duration between 30 and 150 minutes
		    int avgHeartRate = (int) (Math.random() * 40) + 100; // Random average heart rate between 100 and 140 bpm
		    int maxHeartRate = (int) (avgHeartRate * 1.2); // Max heart rate is 20% higher than avg heart rate
		    // Calculate calories burned based on the duration
		    float caloriesBurned = durationMinutes * (float) (Math.random() * 10 + 5); // Burn 5-15 calories per minute
		    // Create a new ExerciseResponse object with the data
		    ExerciseResponse response = ExerciseResponse.newBuilder()
		            .setDurationMinutes(durationMinutes)
		            .setCaloriesBurned(caloriesBurned)
		            .setAvgHeartRate(avgHeartRate)
		            .setMaxHeartRate(maxHeartRate)
		            .build();

		    // Send the response back to the client
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
     }
	 
	 @Override
     public StreamObserver<NutritionRequest> nutritionInformation(StreamObserver<NutritionResponse> responseObserver) {
		 // Create a new StreamObserver for NutritionRequest
         return new StreamObserver<NutritionRequest>() {
        	 // Initialize total calories intake to 0
             int totalCaloriesIntake = 0;
             // Initialize caloric surplus to false
             boolean isCaloricSurplus = false;

             @Override
             public void onNext(NutritionRequest nutritionRequest) {
            	 // Increment the total calories intake and check for caloric surplus
                 int caloriesIntake = nutritionRequest.getCaloriesIntake();
                 totalCaloriesIntake += caloriesIntake;
                 isCaloricSurplus = totalCaloriesIntake > 0;
             }

             @Override
             public void onError(Throwable throwable) {
            	 // Handle error
                 System.err.println("Error in NutritionInformation: " + throwable.getMessage());
             }

             @Override
             public void onCompleted() {
            	// Create a new NutritionResponse with the total calories intake and caloric surplus
                 NutritionResponse response = NutritionResponse.newBuilder()
                         .setTotalCaloriesIntake(totalCaloriesIntake)
                         .setIsCaloricSurplus(isCaloricSurplus)
                         .build();
                 
                 // Send the NutritionResponse to the client
                 responseObserver.onNext(response);
                 responseObserver.onCompleted();
             }
         };
     }
	 
	 @Override
	 public void callAmbulance(EmergencyRequest request, StreamObserver<EmergencyResponse> responseObserver) {
	     String username = request.getUsername();
	     boolean callAmbulance = false;
	     String message = "";
	     //checks if the username in the request message is valid, and if it is not, it returns an error message.
	     if (username == null || !username.equals("martin") ) {
	    	 message = "Invalid username.";
	     } else {
	    	 callAmbulance = true;
	     }
	    
	     EmergencyResponse response = EmergencyResponse.newBuilder()
	             .setCallAmbulance(callAmbulance)
	             .build();
	     
	     //sends the response to the client using the responseObserver
	     responseObserver.onNext(response);
	     responseObserver.onCompleted();
	 }

     @Override
     public void remindMedication(MedicationRequest request, StreamObserver<MedicationReminder> responseObserver) {
         String username = "martin"; // Set username to "martin"
         if (!request.getUsername().equals(username)) { // Check if request username is correct
             responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Wrong username, try again.").asRuntimeException());
             return;
         }
         // Generate three medication reminders at different times with a 2-second delay between each message
         try {
             MedicationReminder reminder1 = MedicationReminder.newBuilder()
                     .setTime("12:00")
                     .setMedication("Medication 1")
                     .build();
             responseObserver.onNext(reminder1);
             Thread.sleep(2000);
             MedicationReminder reminder2 = MedicationReminder.newBuilder()
                     .setTime("18:00")
                     .setMedication("Medication 1")
                     .build();
             responseObserver.onNext(reminder2);
             Thread.sleep(2000);
             MedicationReminder reminder3 = MedicationReminder.newBuilder()
                     .setTime("24:00")
                     .setMedication("Medication 1")
                     .build();
             responseObserver.onNext(reminder3);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         // Mark the end of the stream
         responseObserver.onCompleted();
     }
 }

	 
	

