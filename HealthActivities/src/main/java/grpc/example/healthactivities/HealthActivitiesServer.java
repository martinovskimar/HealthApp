package grpc.example.healthactivities;

import java.io.IOException;


import grpc.example.healthactivities.HealthActivitiesServer;
import grpc.example.healthactivities.HealthActivitiesServiceGrpc.HealthActivitiesServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class HealthActivitiesServer extends HealthActivitiesServiceImplBase {


	public static void main(String args []) throws IOException, InterruptedException {
		
		HealthActivitiesServer healthActivitiesServer = new HealthActivitiesServer();
		
		int port = 5003;
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(healthActivitiesServer)
					.build()
					.start();
			
			System.out.println("Server started, listening on " + port);
			
			server.awaitTermination();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ee) {
			ee.printStackTrace();
		
		}
	}
	
	 @Override
     public void exercise(ExerciseRequest request, StreamObserver<ExerciseResponse> responseObserver) {
         String exerciseType = request.getExerciseType();
         int durationMinutes = 60;
         float caloriesBurned = 500;
         int avgHeartRate = 130;
         int maxHeartRate = 160;
         ExerciseResponse response = ExerciseResponse.newBuilder()
                 .setDurationMinutes(durationMinutes)
                 .setCaloriesBurned(caloriesBurned)
                 .setAvgHeartRate(avgHeartRate)
                 .setMaxHeartRate(maxHeartRate)
                 .build();
         responseObserver.onNext(response);
         responseObserver.onCompleted();
     }
	 
	 @Override
     public StreamObserver<NutritionRequest> nutritionInformation(StreamObserver<NutritionResponse> responseObserver) {
         return new StreamObserver<NutritionRequest>() {
             int totalCaloriesIntake = 0;
             boolean isCaloricSurplus = false;

             @Override
             public void onNext(NutritionRequest nutritionRequest) {
                 int caloriesIntake = nutritionRequest.getCaloriesIntake();
                 totalCaloriesIntake += caloriesIntake;
                 isCaloricSurplus = totalCaloriesIntake > 0;
             }

             @Override
             public void onError(Throwable throwable) {
                 System.err.println("Error in NutritionInformation: " + throwable.getMessage());
             }

             @Override
             public void onCompleted() {
                 NutritionResponse response = NutritionResponse.newBuilder()
                         .setTotalCaloriesIntake(totalCaloriesIntake)
                         .setIsCaloricSurplus(isCaloricSurplus)
                         .build();
                 responseObserver.onNext(response);
                 responseObserver.onCompleted();
             }
         };
     }
	 @Override
	 public void callAmbulance(EmergencyRequest request, StreamObserver<EmergencyResponse> responseObserver) {
	     String username = request.getUsername();
	     if (username == null || !username.equals("martin") ) {
	    	 responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Invalid username.").asRuntimeException());
	         return;
	     }
	     boolean callAmbulance = true; 
	     EmergencyResponse response = EmergencyResponse.newBuilder()
	             .setCallAmbulance(callAmbulance)
	             .build();
	     responseObserver.onNext(response);
	     responseObserver.onCompleted();
	 }

	 }
	 
	

