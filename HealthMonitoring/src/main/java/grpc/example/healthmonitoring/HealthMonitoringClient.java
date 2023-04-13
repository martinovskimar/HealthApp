package grpc.example.healthmonitoring;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.google.protobuf.Timestamp;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class HealthMonitoringClient {
    private final ManagedChannel channel;
    private final HealthMonitoringServiceGrpc.HealthMonitoringServiceStub stub;

    public HealthMonitoringClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public HealthMonitoringClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        stub = HealthMonitoringServiceGrpc.newStub(channel);
    }

    public void trackSteps() throws InterruptedException {
        String username = "";
        while (!"martin".equals(username)) {
            username = JOptionPane.showInputDialog("Enter your username:");
            if (!"martin".equals(username)) {
                JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
            }
        }
                 UserStepsRequest request = UserStepsRequest.newBuilder().setUsername(username).build();
                 CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<UserStepsResponse> responseObserver = new StreamObserver<UserStepsResponse>() {
            @Override
            public void onNext(UserStepsResponse response) {
            	   String message = "Current Steps: " + response.getCurrentSteps() +
            	            "\nGoal Achieved: " + response.getGoalAchieved() +
            	            "\nAverage Steps: " + response.getAverageSteps();
            	            
            	    JOptionPane.showMessageDialog(null, message);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error: " + throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming completed!");
                latch.countDown();
            }
        };

        stub.trackSteps(request, responseObserver);

        latch.await();
    }
    
    public void hearthRate() throws InterruptedException {
        String username = "";
        while (!"martin".equals(username)) {
            username = JOptionPane.showInputDialog("Enter your username:");
            if (!"martin".equals(username)) {
                JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
            }
        }
                 UserHearthRateRequest request = UserHearthRateRequest.newBuilder().setUsername(username).build();
                 CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<UserHearthRateResponse> responseObserver = new StreamObserver<UserHearthRateResponse>() {
            @Override
            public void onNext(UserHearthRateResponse response) {
            	   String message = "Current Heart Rate: " + response.getCurentHearthRate() +
            	            "\nMessage: " + response.getWarningMessage();
            	            
            	    JOptionPane.showMessageDialog(null, message);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error: " + throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming completed!");
                latch.countDown();
            }
        };

        stub.hearthRate(request, responseObserver);

        latch.await();
    }
    
    public void trackSleep() {
      
            // get user input via JOptionPane
            String username = JOptionPane.showInputDialog("Enter your username:");
            String sleepTimeStr = JOptionPane.showInputDialog("Enter your sleep time in format 'yyyy-MM-dd HH:mm:ss':");
            String wakeupTimeStr = JOptionPane.showInputDialog("Enter your wakeup time in format 'yyyy-MM-dd HH:mm:ss':");
            int snoringTimeMinutes = Integer.parseInt(JOptionPane.showInputDialog("Enter your snoring time in minutes:"));

            // create sleep time timestamp
            LocalDateTime sleepTime = LocalDateTime.parse(sleepTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp sleepTimestamp = Timestamp.newBuilder()
                    .setSeconds(sleepTime.toEpochSecond(ZoneOffset.UTC))
                    .setNanos(sleepTime.getNano())
                    .build();

            // create wakeup time timestamp
            LocalDateTime wakeupTime = LocalDateTime.parse(wakeupTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Timestamp wakeupTimestamp = Timestamp.newBuilder()
                    .setSeconds(wakeupTime.toEpochSecond(ZoneOffset.UTC))
                    .setNanos(wakeupTime.getNano())
                    .build();

            // create sleep request
            UserSleepRequest request = UserSleepRequest.newBuilder()
                    .setUsername(username)
                    .setSleepTime(sleepTimestamp)
                    .setWakeupTime(wakeupTimestamp)
                    .setSnorintTimeMinutes(snoringTimeMinutes)
                    .build();

            // make the request and handle the response asynchronously
            stub.trackSleep(request, new StreamObserver<UserSleepResponse>() {
                @Override
                public void onNext(UserSleepResponse response) {
                    System.out.println("Total Sleep Time: " + response.getTotalSleepTimeMinutes() + " minutes");
                    System.out.println("Sleep Score: " + response.getSleepScore());
                    System.out.println("Sleep Disorder: " + response.getSleepDisprder());
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Error occurred: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Sleep tracking completed.");
                }
            });
           
       
    }
    
    public void trackStress() throws InterruptedException {
        CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<UserStressResponse> responseObserver = new StreamObserver<UserStressResponse>() {
            @Override
            public void onNext(UserStressResponse response) {
                JOptionPane.showMessageDialog(null,
                        "Stress level: " + response.getStresLeve() + "\n" +
                        "Advice: " + response.getAdvice(),
                        "Stress Level", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };
        StreamObserver<UserStressRequest> requestObserver = stub.trackStress(responseObserver);
        try {
            Scanner scanner = new Scanner(System.in);
            int counter = 0;
            while (counter <= 5) {
                String hearthRateStr = JOptionPane.showInputDialog("Enter heart rate:");
                String breathingRateStr = JOptionPane.showInputDialog("Enter breathing rate:");
                int hearthRate = Integer.parseInt(hearthRateStr);
                int breathingRate = Integer.parseInt(breathingRateStr);
                UserStressRequest request = UserStressRequest.newBuilder()
                        .setHearthRate(hearthRate)
                        .setBreathingRate(breathingRate)
                        .build();
                requestObserver.onNext(request);
                counter++;
            }
        } catch (Exception e) {
            requestObserver.onError(e);
        }
        requestObserver.onCompleted();
        finishLatch.await();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        HealthMonitoringClient client = new HealthMonitoringClient("localhost", 5002);
//        client.trackSteps();
//        client.hearthRate();
//        client.trackSleep();
        client.trackStress();
        
        
    }
}
