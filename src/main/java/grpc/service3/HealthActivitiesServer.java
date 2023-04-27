package grpc.service3;

import java.io.IOException;
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
		
        int port = 5002;
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
            JmDNS jmdns = JmDNS.create();
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDescription);
            jmdns.registerService(serviceInfo);
            System.out.println("Registered service: " + serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start the server
        try {
            server.start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	 @Override
     public void exercise(ExerciseRequest request, StreamObserver<ExerciseResponse> responseObserver) {
		 // Extract the exercise type from the request
         String exerciseType = request.getExerciseType();
         // Set some data for the response
         int durationMinutes = 60;
         float caloriesBurned = 500;
         int avgHeartRate = 130;
         int maxHeartRate = 160;
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
	     //checks if the username in the request message is valid, and if it is not, it returns an error message.
	     if (username == null || !username.equals("martin") ) {
	    	 responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Invalid username.").asRuntimeException());
	         return;
	     }
	     //If the username is valid, the method sets the boolean callAmbulance to true and creates an EmergencyResponse message with this value.
	     boolean callAmbulance = true; 
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

	 
	

