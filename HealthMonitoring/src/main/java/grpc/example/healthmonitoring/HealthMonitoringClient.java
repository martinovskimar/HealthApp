package grpc.example.healthmonitoring;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.time.ZoneId;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.google.protobuf.Timestamp;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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
                JOptionPane.showMessageDialog(null, "Wrong username. Please try again.");
            }
        }

        UserStepsRequest request = UserStepsRequest.newBuilder().setUsername(username).build();
        CountDownLatch latch = new CountDownLatch(1);

        JFrame frame = new JFrame();
        frame.setTitle("Track Steps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel currentStepsLabel = new JLabel("Current Steps: ");
        JLabel goalAchievedLabel = new JLabel("Goal Achieved: ");
        JLabel averageStepsLabel = new JLabel("Average Steps: ");

        panel.add(currentStepsLabel);
        panel.add(goalAchievedLabel);
        panel.add(averageStepsLabel);

        frame.getContentPane().add(panel);

        frame.setVisible(true);

        StreamObserver<UserStepsResponse> responseObserver = new StreamObserver<UserStepsResponse>() {
            @Override
            public void onNext(UserStepsResponse response) {
                SwingUtilities.invokeLater(() -> {
                    currentStepsLabel.setText("Current Steps: " + response.getCurrentSteps());
                    goalAchievedLabel.setText("Goal Achieved: " + response.getGoalAchieved());
                    averageStepsLabel.setText("Average Steps: " + response.getAverageSteps());
                });
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

    private void showMessageDialog(String message) {
        JFrame frame = new JFrame("Steps Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(message);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(closeButton);

        frame.pack();
        frame.setVisible(true);
    }

    
    public void hearthRate() throws InterruptedException {
        JFrame frame = new JFrame("Heart Rate Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // center the JFrame on the screen

        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(10);
        JButton connectButton = new JButton("Connect");
        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(connectButton);
        frame.getContentPane().add(panel);

        frame.setVisible(true);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if (!"martin".equals(username)) {
                    JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
                } else {
                    UserHearthRateRequest request = UserHearthRateRequest.newBuilder().setUsername(username).build();

                    JFrame rateFrame = new JFrame("Heart Rate Tracker - " + username);
                    rateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    rateFrame.setSize(300, 150);
                    rateFrame.setLocationRelativeTo(null); // center the JFrame on the screen

                    JLabel rateLabel = new JLabel("Current Heart Rate: ");
                    JLabel rateValueLabel = new JLabel("");
                    JLabel messageLabel = new JLabel("Message: ");
                    JLabel messageValueLabel = new JLabel("");
                    JPanel ratePanel = new JPanel();
                    ratePanel.add(rateLabel);
                    ratePanel.add(rateValueLabel);
                    ratePanel.add(messageLabel);
                    ratePanel.add(messageValueLabel);
                    rateFrame.getContentPane().add(ratePanel);

                    rateFrame.setVisible(true);

                    StreamObserver<UserHearthRateResponse> responseObserver = new StreamObserver<UserHearthRateResponse>() {
                        @Override
                        public void onNext(UserHearthRateResponse response) {
                            String message = "Current Heart Rate: " + response.getCurentHearthRate() +
                                    "\nMessage: " + response.getWarningMessage();

                            rateValueLabel.setText(String.valueOf(response.getCurentHearthRate()));
                            messageValueLabel.setText(response.getWarningMessage());
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            System.err.println("Error: " + throwable.getMessage());
                        }

                        @Override
                        public void onCompleted() {
                            System.out.println("Streaming completed!");
                            rateFrame.dispose();
                        }
                    };

                    stub.hearthRate(request, responseObserver);
                }
            }
        });
    }

    
    public void trackSleep() {
        JFrame frame = new JFrame("Sleep Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Username input
        JLabel usernameLabel = new JLabel("Enter your username:");
        JTextField usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        // Sleep time input
        JLabel sleepTimeLabel = new JLabel("Enter your sleep time:");
        SpinnerDateModel sleepTimeModel = new SpinnerDateModel();
        JSpinner sleepTimeSpinner = new JSpinner(sleepTimeModel);
        sleepTimeSpinner.setEditor(new JSpinner.DateEditor(sleepTimeSpinner, "yyyy-MM-dd HH:mm:ss"));
        panel.add(sleepTimeLabel);
        panel.add(sleepTimeSpinner);

        // Wakeup time input
        JLabel wakeupTimeLabel = new JLabel("Enter your wakeup time:");
        SpinnerDateModel wakeupTimeModel = new SpinnerDateModel();
        JSpinner wakeupTimeSpinner = new JSpinner(wakeupTimeModel);
        wakeupTimeSpinner.setEditor(new JSpinner.DateEditor(wakeupTimeSpinner, "yyyy-MM-dd HH:mm:ss"));
        panel.add(wakeupTimeLabel);
        panel.add(wakeupTimeSpinner);

        // Snoring time input
        JLabel snoringTimeLabel = new JLabel("Enter your snoring time in minutes:");
        JTextField snoringTimeField = new JTextField();
        panel.add(snoringTimeLabel);
        panel.add(snoringTimeField);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String username = usernameField.getText();
                Date sleepTimeDate = (Date) sleepTimeSpinner.getValue();
                Date wakeupTimeDate = (Date) wakeupTimeSpinner.getValue();
                int snoringTimeMinutes = Integer.parseInt(snoringTimeField.getText());

                // Create sleep time timestamp
                LocalDateTime sleepTime = LocalDateTime.ofInstant(sleepTimeDate.toInstant(), ZoneId.systemDefault());
                Timestamp sleepTimestamp = Timestamp.newBuilder()
                        .setSeconds(sleepTime.toEpochSecond(ZoneOffset.UTC))
                        .setNanos(sleepTime.getNano())
                        .build();

                // Create wakeup time timestamp
                LocalDateTime wakeupTime = LocalDateTime.ofInstant(wakeupTimeDate.toInstant(), ZoneId.systemDefault());
                Timestamp wakeupTimestamp = Timestamp.newBuilder()
                        .setSeconds(wakeupTime.toEpochSecond(ZoneOffset.UTC))
                        .setNanos(wakeupTime.getNano())
                        .build();

                // Create sleep request
                UserSleepRequest request = UserSleepRequest.newBuilder()
                        .setUsername(username)
                        .setSleepTime(sleepTimestamp)
                        .setWakeupTime(wakeupTimestamp)
                        .setSnorintTimeMinutes(snoringTimeMinutes)
                        .build();

                // Make the request and handle the response asynchronously
                stub.trackSleep(request, new StreamObserver<UserSleepResponse>() {
                    @Override
                    public void onNext(UserSleepResponse response) {
                        int totalSleepTimeMinutes = response.getTotalSleepTimeMinutes();
                        int hours = totalSleepTimeMinutes / 60;
                        int minutes = totalSleepTimeMinutes % 60;
                        int seconds = (int) ((totalSleepTimeMinutes * 60) % 60);
                        String formattedTotalSleepTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                        System.out.println("Total Sleep Time: " + formattedTotalSleepTime);
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
    });

    panel.add(submitButton);
    frame.add(panel);
    frame.setVisible(true);
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
 //      client.trackSteps();
  //      client.hearthRate();
        client.trackSleep();
//       client.trackStress();
        
       
    }
}
