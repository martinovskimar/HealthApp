package grpc.example.healthactivities;

import java.util.concurrent.TimeUnit;

import grpc.example.healthactivities.HealthActivitiesServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HealthActivitiesClient {
	
    private final ManagedChannel channel;
    private final HealthActivitiesServiceGrpc.HealthActivitiesServiceStub stub;

    public HealthActivitiesClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public HealthActivitiesClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        stub = HealthActivitiesServiceGrpc.newStub(channel);
    }
    
    public ExerciseResponse calculateExerciseMetrics(ExerciseRequest request) {
        return stub.exercise(request);
    }
    
    public static void main(String[] args) {
        HealthActivitiesClient client = new HealthActivitiesClient("localhost", 50051);

        ExerciseRequest request = ExerciseRequest.newBuilder()
                .setTypeOfExercise(ExerciseRequest.TypeOfExercise.RUNNING)
                .build();

        ExerciseResponse response = client.calculateExerciseMetrics(request);


}
