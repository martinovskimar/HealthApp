package grpc.examples.userLogin;

import javax.swing.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserLoginClient {

    private static String userStatus = "Offline";
    private static JTextField emailField;
    private static JPasswordField passwordField;

    public static void main(String args[]) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5001)
                .usePlaintext()
                .build();

        userLoginGrpc.userLoginBlockingStub stub = userLoginGrpc.newBlockingStub(channel);

        JFrame frame = new JFrame("User Login");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel statusLabel = new JLabel("Status: " + userStatus);
        JButton loginButton = new JButton("Login");
        JButton logoutButton = new JButton("Logout");
        JButton exitButton = new JButton("Exit");

        loginButton.addActionListener(e -> {
            if (userStatus.equals("Offline")) {
                JFrame loginFrame = new JFrame("Login");
                loginFrame.setSize(300, 200);
                loginFrame.setLocationRelativeTo(null);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
                emailField = new JTextField(20);
                passwordField = new JPasswordField(20);

                loginPanel.add(new JLabel("Email:"));
                loginPanel.add(emailField);
                loginPanel.add(new JLabel("Password:"));
                loginPanel.add(passwordField);

                JButton submitButton = new JButton("Submit");
                JButton cancelButton = new JButton("Cancel");

                submitButton.addActionListener(event -> {
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());

                    LoginRequest loginRequest = LoginRequest.newBuilder()
                            .setEmail(email)
                            .setPassword(password)
                            .build();

                    LoginResponse loginResponse = stub.login(loginRequest);

                    if (loginResponse.getStatus() == LoginStatus.LOGIN_SUCCESSFULL) {
                        JOptionPane.showMessageDialog(null, "Login successfull.");
                        userStatus = "Online";
                        statusLabel.setText("Status: " + userStatus);
                        loginFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong email or password. Login failed.");
                    }
                });

                cancelButton.addActionListener(event -> {
                    loginFrame.setVisible(false);
                });

                loginPanel.add(submitButton);
                loginPanel.add(cancelButton);

                loginFrame.getContentPane().add(loginPanel);
                loginFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "You are already logged in.");
            }
        });

        logoutButton.addActionListener(e -> {
            if (userStatus.equals("Offline")) {
                JOptionPane.showMessageDialog(null, "You are not logged in.");
            } else {
                LogoutRequest logoutRequest = LogoutRequest.newBuilder()
                        .setUserStatus(userStatus)
                        .build();

                LogoutResponse logoutResponse = stub.logout(logoutRequest);

                if (logoutResponse.getStatus() == LogoutStatus.LOGOUT_SUCCESSFULL) {
                    JOptionPane.showMessageDialog(null, "Logout successful.");
                    userStatus = "Offline";
                    statusLabel.setText("Status: " + userStatus);
                } else {
                    JOptionPane.showMessageDialog(null, "Logout failed.");
                }
            }
        });

        exitButton.addActionListener(e -> {
            channel.shutdown();
            System.exit(0);
        });

        mainPanel.add(statusLabel);
        mainPanel.add(loginButton);
        mainPanel.add(logoutButton);
        mainPanel.add(exitButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
