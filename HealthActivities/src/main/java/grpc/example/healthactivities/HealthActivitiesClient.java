package grpc.example.healthactivities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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
	        HealthActivitiesClient client = new HealthActivitiesClient("localhost", 5003);
	        client.blockingStub.exercise(ExerciseRequest.newBuilder()
	                .setExerciseType("Running")
	                .build());
	    }
}
