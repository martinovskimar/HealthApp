package grpc.service1;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserLoginClient {

    private static String userStatus = "Offline";
    private static JTextField emailField;
    private static JPasswordField passwordField;
    private static ServiceInfo serviceInfo;

    public static void main(String args[]) throws IOException, InterruptedException {
        
        // Discover server with jmDNS
        JmDNS jmdns = JmDNS.create();  // create a new JmDNS instance
        String serviceType = "_grpc._tcp.local."; // set the service type
        String serviceName = "UserLoginService"; // set the service name
        ServiceListener listener = new ServiceListener() { // create a new ServiceListener
            public void serviceAdded(ServiceEvent event) {
                System.out.println("Service added: " + event.getName());
            }
            public void serviceRemoved(ServiceEvent event) {
                System.out.println("Service removed: " + event.getName());
            }
            public void serviceResolved(ServiceEvent event) {
                System.out.println("Service resolved: " + event.getName() + ", " + event.getInfo());
                if (event.getName().equals(serviceName)) {
                    serviceInfo = event.getInfo(); // get the service info
                }
            }
        };
        jmdns.addServiceListener(serviceType, listener); // add the ServiceListener to JmDNS
        while (serviceInfo == null) { // wait until the service is discovered
            System.out.println("Waiting for service discovery...");
            Thread.sleep(1000);
        }
        int port = serviceInfo.getPort(); // get the port of the service
        System.out.printf("Discovered service at %s:%d%n", serviceInfo.getHostAddresses()[0], port);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceInfo.getHostAddresses()[0], port)
                .usePlaintext()
                .build(); // create a new channel to connect to the server
        userLoginGrpc.userLoginBlockingStub stub = userLoginGrpc.newBlockingStub(channel); // create a new blocking stub to handle the communication with the server

        JFrame frame = new JFrame("User Login");  // Create a new JFrame with a title "User Login"
        frame.setSize(300, 200); // Set the size of the JFrame
        frame.setLocationRelativeTo(null); // Center the JFrame on the screen

        JPanel mainPanel = new JPanel();  // Create a new JPanel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Set the layout of the JPanel to a vertical BoxLayout

        JLabel statusLabel = new JLabel("Status: " + userStatus); // Create a new JLabel with the text "Status: Offline"
        JButton loginButton = new JButton("Login");  // Create a new JButton with the text "Login"
        JButton logoutButton = new JButton("Logout"); // Create a new JButton with the text "Logout"
        JButton exitButton = new JButton("Exit"); // Create a new JButton with the text "Exit"

        loginButton.addActionListener(e -> { // Add an ActionListener to the login button
            if (userStatus.equals("Offline")) { // If the user is not logged in
                JFrame loginFrame = new JFrame("Login"); // Create a new JFrame with the title "Login"
                loginFrame.setSize(300, 200); // Set the size of the JFrame
                loginFrame.setLocationRelativeTo(null); // Center the JFrame on the screen

                JPanel loginPanel = new JPanel(); // Create a new JPanel
                loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS)); // Set the layout of the JPanel to a vertical BoxLayout
                emailField = new JTextField(20); // Create a new JTextField with a width of 20 characters
                passwordField = new JPasswordField(20);  // Create a new JPasswordField with a width of 20 characters

                loginPanel.add(new JLabel("Email:")); // Add a new JLabel with the text "Email:"
                loginPanel.add(emailField); // Add the emailField to the JPanel
                loginPanel.add(new JLabel("Password:")); // Add a new JLabel with the text "Password:"
                loginPanel.add(passwordField); // Add the passwordField to the JPanel

                JButton submitButton = new JButton("Submit"); // Create a new JButton with the text "Submit"
                JButton cancelButton = new JButton("Cancel"); // Create a new JButton with the text "Cancel"

                submitButton.addActionListener(event -> { // Add an ActionListener to the submit button
                    String email = emailField.getText(); // Get the text from the emailField
                    String password = new String(passwordField.getPassword()); // Get the text from the passwordField and convert it to a String

                    LoginRequest loginRequest = LoginRequest.newBuilder() // Create a new LoginRequest
                            .setEmail(email) // Set the email field
                            .setPassword(password) // Set the password field
                            .build();

                    LoginResponse loginResponse = stub.login(loginRequest); // Call the login method on the stub and get the response

                    if (loginResponse.getStatus() == LoginStatus.LOGIN_SUCCESSFULL) { // If the login was successful
                        JOptionPane.showMessageDialog(null, "Login successfull."); // Show a success message
                        userStatus = "Online"; // Set the user status to "Online"
                        statusLabel.setText("Status: " + userStatus); // Update the status label
                        loginFrame.setVisible(false); // Hide the login JFrame
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong email or password. Login failed.");  // Show an error message
                    }
                });

                cancelButton.addActionListener(event -> {  // Add an ActionListener to the cancel button
                    loginFrame.setVisible(false); // Hide the login JFrame
                });

                loginPanel.add(submitButton); // Add the submit button to the login panel
                loginPanel.add(cancelButton); // Add the cancel button to the login panel

                loginFrame.getContentPane().add(loginPanel); // Add the login panel to the login JFrame
                loginFrame.setVisible(true); // Make the login JFrame visible
            } else {
                JOptionPane.showMessageDialog(null, "You are already logged in.");
            }
        });

        logoutButton.addActionListener(e -> { // Define an action listener for the login button
            if (userStatus.equals("Offline")) { // Check if the user is not already logged in
                JOptionPane.showMessageDialog(null, "You are not logged in."); 
            } else {
                LogoutRequest logoutRequest = LogoutRequest.newBuilder() // Create a logout request object with the current user status
                        .setUserStatus(userStatus)
                        .build();

                LogoutResponse logoutResponse = stub.logout(logoutRequest); // Call the logout service on the server using the stub and the logout request

                if (logoutResponse.getStatus() == LogoutStatus.LOGOUT_SUCCESSFULL) {
                    JOptionPane.showMessageDialog(null, "Logout successful.");
                    userStatus = "Offline";
                    statusLabel.setText("Status: " + userStatus);
                } else {
                    JOptionPane.showMessageDialog(null, "Logout failed.");
                }
            }
        });

        exitButton.addActionListener(e -> { // Define an action listener for the exit button
            channel.shutdown(); // Shutdown the gRPC channel
            System.exit(0); // Terminate the application
        });

        mainPanel.add(statusLabel); // Add the status label to the main panel
        mainPanel.add(loginButton); // Add the login button to the main panel
        mainPanel.add(logoutButton); // Add the logout button to the main panel
        mainPanel.add(exitButton);  // Add the exit button to the main panel
        
        frame.getContentPane().add(mainPanel); // Add the main panel to the frame
        frame.setVisible(true); // Make the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation of the frame to exit the application
    }
}
