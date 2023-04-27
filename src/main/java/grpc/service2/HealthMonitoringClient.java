package grpc.service2;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.time.ZoneId;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

	    public void shutdown() throws InterruptedException {
	        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
	    }

    public void trackSteps() throws InterruptedException {
        String username = "";
        while (!"martin".equals(username)) {
            username = JOptionPane.showInputDialog("Enter your username:");
            if (!"martin".equals(username)) {
                JOptionPane.showMessageDialog(null, "Wrong username. Please try again.");
            }
        }

        // Create a UserStepsRequest object with the entered username
        UserStepsRequest request = UserStepsRequest.newBuilder().setUsername(username).build();
        CountDownLatch latch = new CountDownLatch(1);

        // Create a JFrame for displaying the user's steps information
        JFrame frame = new JFrame();
        frame.setTitle("Track Steps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Create a JPanel for holding the JLabels displaying user's steps information
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel currentStepsLabel = new JLabel("Current Steps: ");
        JLabel goalAchievedLabel = new JLabel("Goal Achieved: ");
        JLabel averageStepsLabel = new JLabel("Average Steps: ");

        // Add the JLabels to the JPanel
        panel.add(currentStepsLabel);
        panel.add(goalAchievedLabel);
        panel.add(averageStepsLabel);

        // Add the JPanel to the JFrame
        frame.getContentPane().add(panel);

        // Make the JFrame visible
        frame.setVisible(true);

        // Create a StreamObserver for receiving the user's steps information from the server
        StreamObserver<UserStepsResponse> responseObserver = new StreamObserver<UserStepsResponse>() {
            @Override
            public void onNext(UserStepsResponse response) {
            	// Update the JLabels with the received information using invokeLater to ensure it is done on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> {
                    currentStepsLabel.setText("Current Steps: " + response.getCurrentSteps());
                    goalAchievedLabel.setText("Goal Achieved: " + response.getGoalAchieved());
                    averageStepsLabel.setText("Average Steps: " + response.getAverageSteps());
                });
            }

            @Override
            public void onError(Throwable throwable) {
            	// Handle any errors that occur during the stream
                System.err.println("Error: " + throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
            	// Notify that the stream has completed and count down the latch            	
                System.out.println("Streaming completed!");
                latch.countDown();
            }
        };

        // Call the trackSteps method of the server stub and pass in the UserStepsRequest and StreamObserver
        stub.trackSteps(request, responseObserver);

        // Wait for the latch to count down, indicating that the stream has completed
        latch.await();
    }

    private void showMessageDialog(String message) {
    	// Create a JFrame for displaying a message
        JFrame frame = new JFrame("Steps Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display the message
        JLabel label = new JLabel(message);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Create a JPanel for holding a Close button
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Create a Close button and add an ActionListener to exit the program when clicked
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(closeButton);

        // Pack and display the JFrame
        frame.pack();
        frame.setVisible(true);
    }

    
    /**
     * Displays a JFrame for the user to enter their username and connect to the heart rate tracker.
     * Once connected, displays a new JFrame with the user's heart rate and any warning messages.
     * Uses a gRPC stream to receive real-time heart rate updates.
     * The user can close the JFrame to stop the heart rate tracking.
     * @throws InterruptedException
     */
    public void hearthRate() throws InterruptedException {
    	// create a JFrame for the user to enter their username and connect
        JFrame frame = new JFrame("Heart Rate Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // center the JFrame on the screen

        // create the UI components
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(10);
        JButton connectButton = new JButton("Connect");
        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(connectButton);
        frame.getContentPane().add(panel);

        // display the JFrame
        frame.setVisible(true);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                // check if username is valid
                if (!"martin".equals(username)) {
                    JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
                // create the request with the user's username
                } else {
                    UserHearthRateRequest request = UserHearthRateRequest.newBuilder().setUsername(username).build();

                    // create a new JFrame to display the heart rate and warning message
                    JFrame rateFrame = new JFrame("Heart Rate Tracker - " + username);
                    rateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    rateFrame.setSize(300, 150);
                    rateFrame.setLocationRelativeTo(null); // center the JFrame on the screen

                    // create the UI components for heart rate and warning message
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

                    // display the JFrame
                    rateFrame.setVisible(true);

                    // create a stream observer to handle the heart rate updates
                    StreamObserver<UserHearthRateResponse> responseObserver = new StreamObserver<UserHearthRateResponse>() {
                        @Override
                        public void onNext(UserHearthRateResponse response) {
                        	// update the UI components with the new heart rate and warning message
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

                    // make the gRPC call to start heart rate tracking
                    stub.hearthRate(request, responseObserver);
                }
            }
        });
    }

    
    public void trackSleep() {
    	// Create a JFrame to display the sleep tracking UI
        JFrame frame = new JFrame("Sleep Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a JPanel with a grid layout for the UI components
        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Add a JLabel and a JTextField for the username input
        JLabel usernameLabel = new JLabel("Enter your username:");
        JTextField usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        // Add a JLabel and a JSpinner for the sleep time input
        JLabel sleepTimeLabel = new JLabel("Enter your sleep time:");
        SpinnerDateModel sleepTimeModel = new SpinnerDateModel();
        JSpinner sleepTimeSpinner = new JSpinner(sleepTimeModel);
        sleepTimeSpinner.setEditor(new JSpinner.DateEditor(sleepTimeSpinner, "yyyy-MM-dd HH:mm:ss"));
        panel.add(sleepTimeLabel);
        panel.add(sleepTimeSpinner);

        // Add a JLabel and a JSpinner for the wakeup time input
        JLabel wakeupTimeLabel = new JLabel("Enter your wakeup time:");
        SpinnerDateModel wakeupTimeModel = new SpinnerDateModel();
        JSpinner wakeupTimeSpinner = new JSpinner(wakeupTimeModel);
        wakeupTimeSpinner.setEditor(new JSpinner.DateEditor(wakeupTimeSpinner, "yyyy-MM-dd HH:mm:ss"));
        panel.add(wakeupTimeLabel);
        panel.add(wakeupTimeSpinner);

        // Add a JLabel and a JTextField for the snoring time input
        JLabel snoringTimeLabel = new JLabel("Enter your snoring time in minutes:");
        JTextField snoringTimeField = new JTextField();
        panel.add(snoringTimeLabel);
        panel.add(snoringTimeField);

        // Add a JButton for submitting the sleep tracking data
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Get the user input values
                String username = usernameField.getText();
                Date sleepTimeDate = (Date) sleepTimeSpinner.getValue();
                Date wakeupTimeDate = (Date) wakeupTimeSpinner.getValue();
                int snoringTimeMinutes = Integer.parseInt(snoringTimeField.getText());

                // Convert the sleep time and wakeup time to Timestamp objects
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

                // Create a UserSleepRequest object with the user input values
                UserSleepRequest request = UserSleepRequest.newBuilder()
                        .setUsername(username)
                        .setSleepTime(sleepTimestamp)
                        .setWakeupTime(wakeupTimestamp)
                        .setSnorintTimeMinutes(snoringTimeMinutes)
                        .build();

                // Make the gRPC request and handle the response asynchronously
                stub.trackSleep(request, new StreamObserver<UserSleepResponse>() {
                    @Override
                    public void onNext(UserSleepResponse response) {
                    	// Update the UI with the response data
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
                    // Handle errors 
                    public void onError(Throwable t) {
                        System.out.println("Error occurred: " + t.getMessage());
                    }


                @Override
                // Print a completion message
                public void onCompleted() {
                    System.out.println("Sleep tracking completed.");
                }
            });
        }
    });

    panel.add(submitButton); // Add the submit button to the panel
    frame.add(panel); // Add the panel to the frame
    frame.setVisible(true); // Make the frame visible
}
    
    public void trackStress() throws InterruptedException {
    	
    	// Create a CountDownLatch to synchronize the completion of the request
        CountDownLatch finishLatch = new CountDownLatch(1);
        
        // Create a response observer to handle the server's responses
        StreamObserver<UserStressResponse> responseObserver = new StreamObserver<UserStressResponse>() {
            @Override
            public void onNext(UserStressResponse response) {
            	// Update the UI with the response data
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null,
                            "Stress level: " + response.getStresLeve() + "\n" +
                            "Advice: " + response.getAdvice(),
                            "Stress Level", JOptionPane.INFORMATION_MESSAGE);
                });
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
            	// Mark the request as completed
                finishLatch.countDown();
            }
        };
        
        // Create a request observer to send the client's requests to the server
        StreamObserver<UserStressRequest> requestObserver = stub.trackStress(responseObserver);

        // Create and show the UI for the stress tracker
        JFrame frame = new JFrame("Stress Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        frame.add(panel);

        JLabel heartRateLabel = new JLabel("Heart rate:");
        panel.add(heartRateLabel);

        JTextField heartRateField = new JTextField();
        panel.add(heartRateField);

        JLabel breathingRateLabel = new JLabel("Breathing rate:");
        panel.add(breathingRateLabel);

        JTextField breathingRateField = new JTextField();
        panel.add(breathingRateField);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        frame.setVisible(true);

        // Add an action listener to the submit button to send the client's requests
        submitButton.addActionListener(new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter < 5) {
                    try {
                    	// Parse the input values and create a request
                        int heartRate = Integer.parseInt(heartRateField.getText());
                        int breathingRate = Integer.parseInt(breathingRateField.getText());

                        UserStressRequest request = UserStressRequest.newBuilder()
                                .setHearthRate(heartRate)
                                .setBreathingRate(breathingRate)
                                .build();
                        // Send the request to the server
                        requestObserver.onNext(request);

                        counter++;
                    } catch (Exception ex) {
                    	// Handle error
                        requestObserver.onError(ex);
                    }
                } else {
                	// Mark the request as completed and close the UI
                    requestObserver.onCompleted();
                    frame.dispose();
                }
            }
        });

        // Wait for the request to complete before closing the channel
        finishLatch.await();
    }

    public void shutdown1() throws InterruptedException {
    	// Gracefully shutdown the channel
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // Discover the service using jmDNS
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "health-monitoring-service";
        CountDownLatch latch = new CountDownLatch(1);
        ServiceInfo[] serviceInfos = new ServiceInfo[1];

        JmDNS jmdns = JmDNS.create();
        ServiceListener listener = new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                System.out.println("Service added: " + event.getName());
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
                System.out.println("Service removed: " + event.getName());
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                System.out.println("Service resolved: " + event.getName() + ", " + event.getInfo());
                if (event.getName().equals(serviceName)) {
                    serviceInfos[0] = event.getInfo();
                    latch.countDown();
                }
            }
        };
        jmdns.addServiceListener(serviceType, listener);

        System.out.println("Waiting for service discovery...");
        latch.await();
        ServiceInfo serviceInfo = serviceInfos[0];
        int servicePort = serviceInfo.getPort();
        String hostAddress = serviceInfo.getHostAddresses()[0];

        System.out.printf("Discovered service at %s:%d%n", hostAddress, servicePort);

        // Create a gRPC channel and stub
        HealthMonitoringClient client = new HealthMonitoringClient(hostAddress, servicePort);

        client.trackSteps();
//        client.hearthRate();
//        client.trackSleep();
//        client.trackStress();
    }
}
