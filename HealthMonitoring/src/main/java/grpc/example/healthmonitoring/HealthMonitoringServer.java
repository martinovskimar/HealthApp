package grpc.example.healthmonitoring;

import java.io.IOException;
import java.util.Random;

import grpc.example.healthmonitoring.HealthMonitoringServiceGrpc.HealthMonitoringServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HealthMonitoringServer extends HealthMonitoringServiceImplBase {
	
	public static void main(String args []) throws IOException, InterruptedException {
		
		HealthMonitoringServer healthMonitoringServer = new HealthMonitoringServer();
		
		int port = 5002;
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(healthMonitoringServer)
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
	public void trackSteps(UserStepsRequest request, StreamObserver<UserStepsResponse> responseObserver) {
		
		Random random = new Random();
		boolean goal_achived = false;
		int goal = 7000;
		int current_steps = random.nextInt(15000);
		
		for(int i = 0; i < 10; i++) {
			current_steps = current_steps + i;
			int average_steps = current_steps / 2;
			if(current_steps >= goal) {
				goal_achived = true;
			} 
			
			
			UserStepsResponse response = UserStepsResponse.newBuilder()
					.setCurrentSteps(current_steps)
					.setGoalAchieved(goal_achived)
					.setAverageSteps(average_steps)
					.build();
			
			responseObserver.onNext(response);
			
			try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
		responseObserver.onCompleted();
	}
	
	@Override
	public void hearthRate(UserHearthRateRequest request, StreamObserver<UserHearthRateResponse> responseObserver) {
		
		Random random = new Random();
		String warning_message = "";
		int current_hearth_rate = 0;
		for(int i = 0; i < 10; i++) {
			current_hearth_rate = random.nextInt(141) + 40;
			if(current_hearth_rate < 40) {
				warning_message = "Warning, Hearth rate to low!";
			} else if(current_hearth_rate > 140) {
				warning_message = "Warning, Hearth rate to high!";
			} else {
				warning_message = "Heart Rate within normal.";
			}
			
			UserHearthRateResponse response = UserHearthRateResponse.newBuilder()
					.setCurentHearthRate(current_hearth_rate)
					.setWarningMessage(warning_message)
					.build();
			
			responseObserver.onNext(response);
			
			try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		responseObserver.onCompleted();
		
		
	}
	@Override
    public void trackSleep(UserSleepRequest request, StreamObserver<UserSleepResponse> responseObserver) {
		Random random = new Random();
        int totalSleepTime = (int) (request.getWakeupTime().getSeconds() - request.getSleepTime().getSeconds()) / 60;
        double sleepScore = random.nextDouble() * 100;
        SleepDisorder sleepDisorder = SleepDisorder.NONE;

        if (request.getSnorintTimeMinutes() > 30) {
            sleepDisorder = SleepDisorder.SLEEP_APNEA;
        }

        UserSleepResponse response = UserSleepResponse.newBuilder()
                .setTotalSleepTimeMinutes(totalSleepTime)
                .setSleepScore(sleepScore)
                .setSleepDisprder(sleepDisorder)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
