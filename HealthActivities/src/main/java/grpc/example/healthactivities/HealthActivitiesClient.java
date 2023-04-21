package grpc.example.healthactivities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
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


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class HealthActivitiesClient {

	 private static final String[] EXERCISE_TYPES = {"Running", "Swimming", "Cycling", "Weightlifting", "Yoga", "Pilates"};

	    private final ManagedChannel channel;
	    private final HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub blockingStub;
	    private final HealthActivitiesServiceGrpc.HealthActivitiesServiceStub asyncStub;

	    private final JLabel durationLabel = new JLabel();
	    private final JLabel caloriesBurnedLabel;
	    private final JLabel avgHeartRateLabel;
	    private final JLabel maxHeartRateLabel;
	    private final JComboBox<String> exerciseTypeComboBox;

	    public HealthActivitiesClient(String host, int port) {
	        channel = ManagedChannelBuilder.forAddress(host, port)
	                .usePlaintext()
	                .build();
	        blockingStub = HealthActivitiesServiceGrpc.newBlockingStub(channel);
	        asyncStub = HealthActivitiesServiceGrpc.newStub(channel);

	        JFrame frame = new JFrame("Health Activities");
	        frame.setSize(500, 200);
	        frame.setLayout(new GridLayout(0, 4));

	        JLabel exerciseTypeLabel = new JLabel("Select an exercise:");
	        frame.add(exerciseTypeLabel);
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));

	        exerciseTypeComboBox = new JComboBox<>(EXERCISE_TYPES);
			this.caloriesBurnedLabel = new JLabel();
			this.avgHeartRateLabel = new JLabel();
			this.maxHeartRateLabel = new JLabel();
	        frame.add(exerciseTypeComboBox);
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));

	        JButton exerciseButton = new JButton("Exercise");
	        exerciseButton.addActionListener(new ExerciseButtonListener());
	        frame.add(exerciseButton);
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));
	        frame.add(new JLabel(""));

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

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }

	    private class ExerciseButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String exerciseType = (String) exerciseTypeComboBox.getSelectedItem();
	            ExerciseRequest request = ExerciseRequest.newBuilder()
	                    .setExerciseType(exerciseType)
	                    .build();

	            ExerciseResponse response = blockingStub.exercise(request);
	            durationLabel.setText(String.valueOf(response.getDurationMinutes()));
	            caloriesBurnedLabel.setText(String.valueOf(response.getCaloriesBurned()));
	            avgHeartRateLabel.setText(String.valueOf(response.getAvgHeartRate()));
	            maxHeartRateLabel.setText(String.valueOf(response.getMaxHeartRate()));
	        }
	    }

	    public void shutdown() throws InterruptedException {
	        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	    
	    

	    public static void main(String[] args) throws Exception {
//	        HealthActivitiesClient client = new HealthActivitiesClient("localhost", 5003);
//	        client.blockingStub.exercise(ExerciseRequest.newBuilder()
//	                .setExerciseType("Running")
//	                .build());
	    	
//	        NutritionClient nutritionClient = new NutritionClient("localhost", 5003);
//	        nutritionClient.sendNutritionInformation();
	    	
	    	//EmergencyClient client = new EmergencyClient();
	    	
	    	MedicationClient client = new MedicationClient("localhost", 5003);
	        client.setVisible(true);
	       
	    }
	    
	    public static class NutritionClient {
	    	private HealthActivitiesServiceGrpc.HealthActivitiesServiceStub stub;
	        private ManagedChannel channel;

	        private JFrame frame;
	        private JLabel mealLabel;
	        private JLabel caloriesLabel;
	        private JTextField breakfastField;
	        private JTextField lunchField;
	        private JTextField dinnerField;
	        private JTextField snackField;
	        private JButton submitButton;

	        public NutritionClient(String host, int port) {
	            channel = ManagedChannelBuilder.forAddress(host, port)
	                    .usePlaintext()
	                    .build();
	            stub = HealthActivitiesServiceGrpc.newStub(channel);

	            frame = new JFrame("Nutrition Tracker");
	            frame.setSize(300, 250);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setLayout(new GridLayout(5, 2, 10, 10));

	            mealLabel = new JLabel("Meal", SwingConstants.CENTER);
	            caloriesLabel = new JLabel("Calories", SwingConstants.CENTER);
	            breakfastField = new JTextField();
	            lunchField = new JTextField();
	            dinnerField = new JTextField();
	            snackField = new JTextField();
	            submitButton = new JButton("Submit");

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

	            JPanel buttonPanel = new JPanel();
	            buttonPanel.add(submitButton);

	            frame.add(mealLabel);
	            frame.add(caloriesLabel);
	            frame.add(breakfastPanel);
	            frame.add(lunchPanel);
	            frame.add(dinnerPanel);
	            frame.add(snackPanel);
	            frame.add(new JLabel());
	            frame.add(buttonPanel);

	            submitButton.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    sendNutritionInformation();
	                }
	            });

	            frame.setVisible(true);
	        }


	        private void sendNutritionInformation() {
	            StreamObserver<NutritionRequest> requestObserver = stub.nutritionInformation(new StreamObserver<NutritionResponse>() {
	                @Override
	                public void onNext(NutritionResponse nutritionResponse) {
	                    int totalCaloriesIntake = nutritionResponse.getTotalCaloriesIntake();
	                    String calorieStatus = totalCaloriesIntake > 2400 ? "Surplus" : "Deficit";
	                    JOptionPane.showMessageDialog(frame, "Total Calories Intake: " + totalCaloriesIntake +
	                            "\nCalorie Status: " + calorieStatus);
	                }

	                @Override
	                public void onError(Throwable throwable) {
	                    JOptionPane.showMessageDialog(frame, "Error: " + throwable.getMessage());
	                }

	                @Override
	                public void onCompleted() {
	                    System.out.println("NutritionInformation completed");
	                }
	            });

	            int totalCalories = 0;

	            String breakfastCalories = breakfastField.getText();
	            if (!breakfastCalories.isEmpty()) {
	                NutritionRequest breakfastRequest = NutritionRequest.newBuilder()
	                        .setMeal("Breakfast")
	                        .setCaloriesIntake(Integer.parseInt(breakfastCalories))
	                        .build();
	                requestObserver.onNext(breakfastRequest);
	                totalCalories += Integer.parseInt(breakfastCalories);
	            }

	            String lunchCalories = lunchField.getText();
	            if (!lunchCalories.isEmpty()) {
	                NutritionRequest lunchRequest = NutritionRequest.newBuilder()
	                       .setMeal("Lunch")
	    		   .setCaloriesIntake(Integer.parseInt(lunchCalories))
	    		   .build();
	    	   requestObserver.onNext(lunchRequest);
	               totalCalories += Integer.parseInt(lunchCalories);
	    }
	        String dinnerCalories = dinnerField.getText();
	        if (!dinnerCalories.isEmpty()) {
	            NutritionRequest dinnerRequest = NutritionRequest.newBuilder()
	                    .setMeal("Dinner")
	                    .setCaloriesIntake(Integer.parseInt(dinnerCalories))
	                    .build();
	            requestObserver.onNext(dinnerRequest);
	            totalCalories += Integer.parseInt(dinnerCalories);
	        }

	        String snackCalories = snackField.getText();
	        if (!snackCalories.isEmpty()) {
	            NutritionRequest snackRequest = NutritionRequest.newBuilder()
	                    .setMeal("Snack")
	                    .setCaloriesIntake(Integer.parseInt(snackCalories))
	                    .build();
	            requestObserver.onNext(snackRequest);
	            totalCalories += Integer.parseInt(snackCalories);
	        }

	        requestObserver.onCompleted();
	    }

	    public void shutdown() throws InterruptedException {
	        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	      
	}  
	    
	    public static class EmergencyClient {
	        private JTextField usernameField;
	        private JButton callAmbulanceButton;
	        private JButton cancelButton;
	        private HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub blockingStub;

	        public EmergencyClient() {
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

	                    // Display the response
	                    JOptionPane.showMessageDialog(frame, "Ambulance is on the way!", "Response",
	                            JOptionPane.INFORMATION_MESSAGE);
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
	    }
	    
	    public static class MedicationClient extends JFrame {
	        private final JTextField usernameField;
	        private final JTextArea reminderArea;
	        private final JButton remindButton;
	        private final ManagedChannel channel;
	        private final HealthActivitiesServiceGrpc.HealthActivitiesServiceStub stub;

	        public MedicationClient(String host, int port) {
	            super("Medication Reminder Client");
	            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	            // Create UI components
	            JPanel mainPanel = new JPanel(new BorderLayout());
	            JPanel inputPanel = new JPanel();
	            JLabel usernameLabel = new JLabel("Username:");
	            usernameField = new JTextField(20);
	            remindButton = new JButton("Remind");
	            reminderArea = new JTextArea(10, 40);
	            JScrollPane reminderScroll = new JScrollPane(reminderArea);

	            // Add UI components to the main panel
	            inputPanel.add(usernameLabel);
	            inputPanel.add(usernameField);
	            inputPanel.add(remindButton);
	            mainPanel.add(inputPanel, BorderLayout.NORTH);
	            mainPanel.add(reminderScroll, BorderLayout.CENTER);

	            // Set up gRPC client
	            this.channel = ManagedChannelBuilder.forAddress(host, port)
	                    .usePlaintext()
	                    .build();
	            this.stub = HealthActivitiesServiceGrpc.newStub(channel);

	            // Set up action listener for the "Remind" button
	            remindButton.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Get the username from the text field
	                    String username = usernameField.getText();

	                    if (!username.equals("martin")) {
	                        JOptionPane.showMessageDialog(null, "Wrong username, try again.");
	                        return;
	                    }

	                    // Clear the reminder area
	                    reminderArea.setText("");

	                    // Call the gRPC server to remind the user
	                    remindMedication(username);
	                }
	            });

	            // Add the main panel to the frame
	            getContentPane().add(mainPanel);

	            // Display the frame
	            pack();
	            setLocationRelativeTo(null);
	            setVisible(true);
	        }

	        public void remindMedication(String username) {
	            MedicationRequest request = MedicationRequest.newBuilder()
	                    .setUsername(username)
	                    .build();
	            stub.remindMedication(request, new StreamObserver<MedicationReminder>() {
	                @Override
	                public void onNext(MedicationReminder reminder) {
	                    // Add the reminder to the reminder area
	                    reminderArea.append("Time: " + reminder.getTime() + ", Medication: " + reminder.getMedication() + "\n");
	                }

	                @Override
	                public void onError(Throwable t) {
	                    // Handle any errors that occur during the call
	                    t.printStackTrace();
	                }

	                @Override
	                public void onCompleted() {
	                    // Called when the server finishes sending reminders
	                    reminderArea.append("All reminders received\n");
	                }
	            });
	        }

	        public void shutdown() throws InterruptedException {
	            // Shut down the channel when the client is done
	            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	        }
	    }
}
