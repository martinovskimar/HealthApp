package grpc.service3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import grpc.service3.ExerciseRequest;
import grpc.service3.ExerciseResponse;
import grpc.service3.HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HealthActivitiesClient extends JFrame{

    private final ManagedChannel channel;
	private final HealthActivitiesServiceBlockingStub blockingStub;
	private AbstractButton snackField;
	private AbstractButton dinnerField;
	private AbstractButton lunchField;
	private AbstractButton breakfastField;
	private JFrame frame;
	   
	   // Create a new HealthActivitiesClient with the given host and port.
	   public HealthActivitiesClient(String host, int port) {
	        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	   }
	   // Create a new HealthActivitiesClient with the given channel builder.
	   public HealthActivitiesClient(ManagedChannelBuilder<?> channelBuilder) {
	        channel = channelBuilder.build();
	        blockingStub = HealthActivitiesServiceGrpc.newBlockingStub(channel);
	        
	   }
	   // Shut down the client and wait for the channel to terminate.
	   public void shutdown() throws InterruptedException {
	        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
	   }
    
    public void exercise() {
    	
    	final String[] EXERCISE_TYPES = {"Running", "Swimming", "Cycling", "Yoga", "Weightlifting"}; // Define an array of exercise types
    	// Create labels to display the duration, calories burned, and heart rate
    	final JLabel durationLabel = new JLabel();
        final JLabel caloriesBurnedLabel = new JLabel();
        final JLabel avgHeartRateLabel = new JLabel();
        final JLabel maxHeartRateLabel = new JLabel();
        JComboBox<String> exerciseTypeComboBox; // Create a combo box to select the exercise type

        // Create a new frame for the GUI
        JFrame frame = new JFrame("Health Activities");
        frame.setSize(500, 200);
        frame.setLayout(new GridLayout(0, 4));

        // Add a label for the exercise type
        JLabel exerciseTypeLabel = new JLabel("Select an exercise:");
        frame.add(exerciseTypeLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        // Add a combo box to select the exercise type
        exerciseTypeComboBox = new JComboBox<>(EXERCISE_TYPES);
        frame.add(exerciseTypeComboBox);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        // Add a button to start the exercise session
        JButton exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(new ExerciseButtonListener(durationLabel, caloriesBurnedLabel, avgHeartRateLabel, maxHeartRateLabel, exerciseTypeComboBox));
        frame.add(exerciseButton);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        // Add labels for the exercise information
        JLabel durationTitleLabel = new JLabel("Duration (minutes):");
        frame.add(durationTitleLabel);
        frame.add(durationLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        JLabel caloriesBurnedTitleLabel = new JLabel("Calories burned:");
        frame.add(caloriesBurnedTitleLabel);
        frame.add(caloriesBurnedLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        JLabel avgHeartRateTitleLabel = new JLabel("Average heart rate:");
        frame.add(avgHeartRateTitleLabel);
        frame.add(avgHeartRateLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        JLabel maxHeartRateTitleLabel = new JLabel("Max heart rate:");
        frame.add(maxHeartRateTitleLabel);
        frame.add(maxHeartRateLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        // Set the default close operation and make the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //ActionListener that gets called when the user clicks the "Exercise" button
    private class ExerciseButtonListener implements ActionListener {
    	
    	// JLabels to display the exercise metrics
        private final JLabel durationLabel;
        private final JLabel caloriesBurnedLabel;
        private final JLabel avgHeartRateLabel;
        private final JLabel maxHeartRateLabel;
        private final JComboBox<String> exerciseTypeComboBox; // ComboBox to select the exercise type

        // Constructor that initializes the instance variables
        public ExerciseButtonListener(JLabel durationLabel, JLabel caloriesBurnedLabel, JLabel avgHeartRateLabel, JLabel maxHeartRateLabel, JComboBox<String> exerciseTypeComboBox) {
            this.durationLabel = durationLabel;
            this.caloriesBurnedLabel = caloriesBurnedLabel;
            this.avgHeartRateLabel = avgHeartRateLabel;
            this.maxHeartRateLabel = maxHeartRateLabel;
            this.exerciseTypeComboBox = exerciseTypeComboBox;
        }

        @Override
        // The event handler for the Exercise button
        public void actionPerformed(ActionEvent e) {
            String exerciseType = (String) exerciseTypeComboBox.getSelectedItem(); // Get the selected exercise type from the ComboBox
            // Build the ExerciseRequest message with the selected exercise type
            ExerciseRequest request = ExerciseRequest.newBuilder()
                    .setExerciseType(exerciseType)
                    .build();
            
            // Send the gRPC request to the server and receive the ExerciseResponse message
            ExerciseResponse response = blockingStub.exercise(request); 
            // Set the JLabels with the exercise metrics from the response message
            durationLabel.setText(String.valueOf(response.getDurationMinutes()));
            caloriesBurnedLabel.setText(String.valueOf(response.getCaloriesBurned()));
            avgHeartRateLabel.setText(String.valueOf(response.getAvgHeartRate()));
            maxHeartRateLabel.setText(String.valueOf(response.getMaxHeartRate()));
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        // Discover the service using jmDNS
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "health-activities-service";
        
        // Create a countdown latch to wait until the service is discovered
        CountDownLatch latch = new CountDownLatch(1);
        // Create an array to store the service info
        ServiceInfo[] serviceInfos = new ServiceInfo[1];

        // Create a JmDNS instance
        JmDNS jmdns = JmDNS.create();
        // Create a ServiceListener to listen for service events
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
                	// If the discovered service is the one we are looking for, store its info in the array
                    serviceInfos[0] = event.getInfo();
                    // Decrease the latch count by one to signal that the service has been discovered
                    latch.countDown();
                }
            }
        };
        
        // Add the ServiceListener to the JmDNS instance
        jmdns.addServiceListener(serviceType, listener);

        System.out.println("Waiting for service discovery...");
        // Wait for the service to be discovered by waiting for the countdown latch to reach zero
        latch.await();
        // Get the service info from the array
        ServiceInfo serviceInfo = serviceInfos[0];
        int servicePort = serviceInfo.getPort();
        String hostAddress = serviceInfo.getHostAddresses()[0];

        System.out.printf("Discovered service at %s:%d%n", hostAddress, servicePort);

        // Create a HealthActivitiesClient instance with the discovered host address and service port
        HealthActivitiesClient client = new HealthActivitiesClient(hostAddress, servicePort);
        
        //Call the methods
//        client.exercise();
        client.nutritionInformation();
//        client.callAmbulance();
//        client.remindMedication();
    }
    
    public void nutritionInformation() {
    	
    	// Declare the necessary GUI elements
        JLabel mealLabel;
        JLabel caloriesLabel;
        JTextField breakfastField;
        JTextField lunchField;
        JTextField dinnerField;
        JTextField snackField;
        JButton submitButton;
        JFrame frame;

        // Set up the JFrame
        frame = new JFrame("Nutrition Tracker");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Set up the labels, text fields, and submit button
        mealLabel = new JLabel("Meal", SwingConstants.CENTER);
        caloriesLabel = new JLabel("Calories", SwingConstants.CENTER);
        breakfastField = new JTextField();
        lunchField = new JTextField();
        dinnerField = new JTextField();
        snackField = new JTextField();
        submitButton = new JButton("Submit");

        // Set up the panels for each meal and snack
        JPanel breakfastPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        breakfastPanel.add(new JLabel("Breakfast"));
        breakfastPanel.add(breakfastField);

        JPanel lunchPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        lunchPanel.add(new JLabel("Lunch"));
        lunchPanel.add(lunchField);

        JPanel dinnerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        dinnerPanel.add(new JLabel("Dinner"));
        dinnerPanel.add(dinnerField);

        JPanel snackPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        snackPanel.add(new JLabel("Snack"));
        snackPanel.add(snackField);

        // Set up the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        // Add the components to the JFrame
        frame.add(mealLabel);
        frame.add(caloriesLabel);
        frame.add(breakfastPanel);
        frame.add(lunchPanel);
        frame.add(dinnerPanel);
        frame.add(snackPanel);
        frame.add(new JLabel());
        frame.add(buttonPanel);

        // Attach an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendNutritionInformation(frame, breakfastField, lunchField, dinnerField, snackField);
            }
        });

        // Make the JFrame visible
        frame.setVisible(true);
    }


    private void sendNutritionInformation(JFrame frame, JTextField breakfastField, JTextField lunchField, JTextField dinnerField, JTextField snackField) {
    	// Create a stub for the nutritionInformation RPC using the channel
        HealthActivitiesServiceGrpc.HealthActivitiesServiceStub asyncStub = HealthActivitiesServiceGrpc.newStub(channel);
        // Create a StreamObserver to handle the response from the server
        StreamObserver<NutritionRequest> requestObserver = asyncStub.nutritionInformation(new StreamObserver<NutritionResponse>() {
        	// Handle each response from the server
            @Override
            public void onNext(NutritionResponse nutritionResponse) {
            	// Extract the total calories intake from the response
                int totalCaloriesIntake = nutritionResponse.getTotalCaloriesIntake();
                // Determine whether the user consumed a surplus or a deficit of calories
                String calorieStatus = totalCaloriesIntake > 2400 ? "Surplus" : "Deficit";
                // Display a dialog box with the total calories intake and calorie status
                JOptionPane.showMessageDialog(frame, "Total Calories Intake: " + totalCaloriesIntake +
                        "\nCalorie Status: " + calorieStatus);
            }

            // Handle errors
            @Override
            public void onError(Throwable throwable) {
                JOptionPane.showMessageDialog(frame, "Error: " + throwable.getMessage());
            }

            // Handle completion of the stream
            @Override
            public void onCompleted() {
                System.out.println("NutritionInformation completed");
            }
        });

        // Initialize a variable to keep track of the total calories consumed
        int totalCalories = 0;
        
        // Check if the user entered a value for breakfast and send a request to the server
        if (breakfastField != null) {
            String breakfastCalories = breakfastField.getText();
            if (!breakfastCalories.isEmpty()) {
            	// Build a NutritionRequest object for breakfast
                NutritionRequest breakfastRequest = NutritionRequest.newBuilder()
                        .setMeal("Breakfast")
                        .setCaloriesIntake(Integer.parseInt(breakfastCalories))
                        .build();
                // Send the request to the server
                requestObserver.onNext(breakfastRequest);
                // Add the calories consumed to the total
                totalCalories += Integer.parseInt(breakfastCalories);
            }
        }
        
        // Check if the user entered a value for lunch and send a request to the server
        if (lunchField != null) {
            String lunchCalories = lunchField.getText();
            if (!lunchCalories.isEmpty()) {
            	// Build a NutritionRequest object for lunch
                NutritionRequest lunchRequest = NutritionRequest.newBuilder()
                        .setMeal("Lunch")
                        .setCaloriesIntake(Integer.parseInt(lunchCalories))
                        .build();
                // Send the request to the server
                requestObserver.onNext(lunchRequest);
                // Add the calories consumed to the total
                totalCalories += Integer.parseInt(lunchCalories);
            }
        }

        // Check if the user entered a value for dinner and send a request to the server
        if (dinnerField != null) {
        if (dinnerField != null) {
            String dinnerCalories = dinnerField.getText();
            if (!dinnerCalories.isEmpty()) {
            	// Build a NutritionRequest object for dinner
                NutritionRequest dinnerRequest = NutritionRequest.newBuilder()
                        .setMeal("Dinner")
                        .setCaloriesIntake(Integer.parseInt(dinnerCalories))
                        .build();
                // Send the request to the server
                requestObserver.onNext(dinnerRequest);
                // Add the calories consumed to the total
                totalCalories += Integer.parseInt(dinnerCalories);
            }
        }

     // Check if the user entered a value for cnack and send a request to the server
        if (snackField != null) {
            String snackCalories = snackField.getText();
            if (!snackCalories.isEmpty()) {
            	// Build a NutritionRequest object for snack
                NutritionRequest snackRequest = NutritionRequest.newBuilder()
                        .setMeal("Snack")
                        .setCaloriesIntake(Integer.parseInt(snackCalories))
                        .build();
                // Send the request to the server
                requestObserver.onNext(snackRequest);
                // Add the calories consumed to the total
                totalCalories += Integer.parseInt(snackCalories);
            }
        }
        // Tell the server that the request is completed
        requestObserver.onCompleted();
        }
    }
    
    public void callAmbulance() {
    	
        
        JTextField usernameField;
        JButton callAmbulanceButton;
        JButton cancelButton;
        HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub blockingStub;
        
        // Initialize the GUI
        JFrame frame = new JFrame("Emergency Response");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the constraints for the GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);

        // Create the panel for the username field
        JPanel panel1 = new JPanel(new GridBagLayout());
        JLabel usernameLabel = new JLabel("Enter username: ");
        usernameField = new JTextField(20);
        panel1.add(usernameLabel, c);
        c.gridx = 1;
        panel1.add(usernameField, c);
        frame.add(panel1);

        // Create the panel for the call ambulance and cancel buttons
        JPanel panel2 = new JPanel(new FlowLayout());
        callAmbulanceButton = new JButton("Call Ambulance");
        callAmbulanceButton.setEnabled(false); // Disable the button initially
        cancelButton = new JButton("Cancel");
        panel2.add(callAmbulanceButton);
        panel2.add(cancelButton);
        frame.add(panel2, BorderLayout.SOUTH);

        // Set up the event listener for the username field
        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable the "Call Ambulance" button
                callAmbulanceButton.setEnabled(true);
                // Set the focus on the "Call Ambulance" button
                callAmbulanceButton.requestFocus();
            }
        });

        // Set up the gRPC channel and blocking stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003).usePlaintext().build();
        blockingStub = HealthActivitiesServiceGrpc.newBlockingStub(channel);

        // Set up the event listeners for the buttons
        callAmbulanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username from the text field
                String username = usernameField.getText();

                // Make the gRPC request
                EmergencyRequest request = EmergencyRequest.newBuilder().setUsername(username).build();
                EmergencyResponse response = blockingStub.callAmbulance(request);

                // Check if the ambulance was called successfully
                if (response.getCallAmbulance()) {
                    JOptionPane.showMessageDialog(frame, "Ambulance is on the way!", "Response",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the window
                frame.dispose();
            }
        });

        // Pack the components and make the frame visible
        frame.pack();
        frame.setVisible(true);
    }
    
    public void remindMedication() {
    	// Create UI components
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JButton remindButton = new JButton("Remind");
        JTextArea reminderArea = new JTextArea(10, 40);
        JScrollPane reminderScroll = new JScrollPane(reminderArea);

        // Add UI components to the main panel
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(remindButton);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(reminderScroll, BorderLayout.CENTER);

        // Set up the gRPC channel and blocking stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003).usePlaintext().build();
        HealthActivitiesServiceGrpc.HealthActivitiesServiceStub stub = HealthActivitiesServiceGrpc.newStub(channel);

        // Set up action listener for the "Remind" button
        remindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username from the text field
                String enteredUsername = usernameField.getText();

                if (!enteredUsername.equals("martin")) {
                    JOptionPane.showMessageDialog(null, "Wrong username, try again.");
                    return;
                }

                // Clear the reminder area
                reminderArea.setText("");

                // Create a medication request with the username
                MedicationRequest request = MedicationRequest.newBuilder()
                        .setUsername(enteredUsername)
                        .build();

                // Call the server method with the request and a stream observer to handle the responses
                stub.remindMedication(request, new StreamObserver<MedicationReminder>() {
                    @Override
                    public void onNext(MedicationReminder reminder) {
                        reminderArea.append("Time: " + reminder.getTime() + ", Medication: " + reminder.getMedication() + "\n");
                    }

                    @Override
                    public void onError(Throwable t) {
                        JOptionPane.showMessageDialog(null, "Error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        reminderArea.append("All reminders received\n");
                        // Shut down the channel when the client is done
                        channel.shutdown();
                    }
                });
            }
        });

        // Add the main panel to the frame
        getContentPane().add(mainPanel);

        // Display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
    


    
   

