package grpc.example.healthactivities;

import java.io.IOException;

import grpc.example.healthactivities.ExerciseRequest.TypeOfExercise;
import grpc.example.healthactivities.HealthActivitiesServiceGrpc.HealthActivitiesServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
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


}
