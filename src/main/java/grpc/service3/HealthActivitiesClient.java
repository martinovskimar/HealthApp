package grpc.service3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import grpc.service3.ExerciseRequest;
import grpc.service3.ExerciseResponse;
import grpc.service3.HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HealthActivitiesClient {

    private final ManagedChannel channel;
	private final HealthActivitiesServiceBlockingStub blockingStub;
	private AbstractButton snackField;
	private AbstractButton dinnerField;
	private AbstractButton lunchField;
	private AbstractButton breakfastField;
	private JFrame frame;
	   

	   public HealthActivitiesClient(String host, int port) {
	        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	   }

	   public HealthActivitiesClient(ManagedChannelBuilder<?> channelBuilder) {
	        channel = channelBuilder.build();
	        blockingStub = HealthActivitiesServiceGrpc.newBlockingStub(channel);
	        
	   }

	   public void shutdown() throws InterruptedException {
	        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
	   }
    
    public void exercise() {
    	
    	final String[] EXERCISE_TYPES = {"Running", "Swimming", "Cycling", "Yoga", "Weightlifting"}; 
    	final JLabel durationLabel = new JLabel();
        final JLabel caloriesBurnedLabel = new JLabel();
        final JLabel avgHeartRateLabel = new JLabel();
        final JLabel maxHeartRateLabel = new JLabel();
        JComboBox<String> exerciseTypeComboBox;

        JFrame frame = new JFrame("Health Activities");
        frame.setSize(500, 200);
        frame.setLayout(new GridLayout(0, 4));

        JLabel exerciseTypeLabel = new JLabel("Select an exercise:");
        frame.add(exerciseTypeLabel);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        exerciseTypeComboBox = new JComboBox<>(EXERCISE_TYPES);
        frame.add(exerciseTypeComboBox);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        JButton exerciseButton = new JButton("Exercise");
        exerciseButton.addActionListener(new ExerciseButtonListener(durationLabel, caloriesBurnedLabel, avgHeartRateLabel, maxHeartRateLabel, exerciseTypeComboBox));
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
        private final JLabel durationLabel;
        private final JLabel caloriesBurnedLabel;
        private final JLabel avgHeartRateLabel;
        private final JLabel maxHeartRateLabel;
        private final JComboBox<String> exerciseTypeComboBox;

        public ExerciseButtonListener(JLabel durationLabel, JLabel caloriesBurnedLabel, JLabel avgHeartRateLabel, JLabel maxHeartRateLabel, JComboBox<String> exerciseTypeComboBox) {
            this.durationLabel = durationLabel;
            this.caloriesBurnedLabel = caloriesBurnedLabel;
            this.avgHeartRateLabel = avgHeartRateLabel;
            this.maxHeartRateLabel = maxHeartRateLabel;
            this.exerciseTypeComboBox = exerciseTypeComboBox;
        }

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
    
    public static void main(String[] args) throws InterruptedException, IOException {
        // Discover the service using jmDNS
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "health-activities-service";
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

        
        HealthActivitiesClient client = new HealthActivitiesClient(hostAddress, servicePort);
        
//        client.exercise();
        client.nutritionInformation();
    }
    
    public void nutritionInformation() {
        JLabel mealLabel;
        JLabel caloriesLabel;
        JTextField breakfastField;
        JTextField lunchField;
        JTextField dinnerField;
        JTextField snackField;
        JButton submitButton;
        JFrame frame;

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
                sendNutritionInformation(frame, breakfastField, lunchField, dinnerField, snackField);
            }
        });

        frame.setVisible(true);
    }


    private void sendNutritionInformation(JFrame frame, JTextField breakfastField, JTextField lunchField, JTextField dinnerField, JTextField snackField) {
        HealthActivitiesServiceGrpc.HealthActivitiesServiceStub asyncStub = HealthActivitiesServiceGrpc.newStub(channel);
        StreamObserver<NutritionRequest> requestObserver = asyncStub.nutritionInformation(new StreamObserver<NutritionResponse>() {
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
        
        if (breakfastField != null) {
            String breakfastCalories = breakfastField.getText();
            if (!breakfastCalories.isEmpty()) {
                NutritionRequest breakfastRequest = NutritionRequest.newBuilder()
                        .setMeal("Breakfast")
                        .setCaloriesIntake(Integer.parseInt(breakfastCalories))
                        .build();
                requestObserver.onNext(breakfastRequest);
                totalCalories += Integer.parseInt(breakfastCalories);
            }
        }
        
        if (lunchField != null) {
            String lunchCalories = lunchField.getText();
            if (!lunchCalories.isEmpty()) {
                NutritionRequest lunchRequest = NutritionRequest.newBuilder()
                        .setMeal("Lunch")
                        .setCaloriesIntake(Integer.parseInt(lunchCalories))
                        .build();
                requestObserver.onNext(lunchRequest);
                totalCalories += Integer.parseInt(lunchCalories);
            }
        }

        if (dinnerField != null) {
            String dinnerCalories = dinnerField.getText();
            if (!dinnerCalories.isEmpty()) {
                NutritionRequest dinnerRequest = NutritionRequest.newBuilder()
                        .setMeal("Dinner")
                        .setCaloriesIntake(Integer.parseInt(dinnerCalories))
                        .build();
                requestObserver.onNext(dinnerRequest);
                totalCalories += Integer.parseInt(dinnerCalories);
            }
        }

        if (snackField != null) {
            String snackCalories = snackField.getText();
            if (!snackCalories.isEmpty()) {
                NutritionRequest snackRequest = NutritionRequest.newBuilder()
                        .setMeal("Snack")
                        .setCaloriesIntake(Integer.parseInt(snackCalories))
                        .build();
                requestObserver.onNext(snackRequest);
                totalCalories += Integer.parseInt(snackCalories);
            }
        }

        requestObserver.onCompleted();
    }
}

    
   

