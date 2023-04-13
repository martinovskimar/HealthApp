package grpc.examples.userLogin;

import javax.swing.JOptionPane;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserLoginClient {

	public static void main(String args[]) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5001)
                .usePlaintext()
                .build();

        userLoginGrpc.userLoginBlockingStub stub = userLoginGrpc.newBlockingStub(channel);

        String userStatus = "Offline";

        boolean exit = false;
        while(!exit) {
        	
        	  String[] userInputs = {"1. Login", "2. Logout", "3. Exit Application"};
              int choice = JOptionPane.showOptionDialog(null, "Please enter your choice: ", "Multiple Choice Dialog Box",
              		JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, userInputs, userInputs[0]);
              
        	switch(choice) {
        	case 0:
        		if(userStatus.equals("Offline")) {
        			String email = JOptionPane.showInputDialog(null, "Enter email: ");
        			String password = JOptionPane.showInputDialog(null, "Enter password: ");
        			
        			LoginRequest loginRequest = LoginRequest.newBuilder()
        					.setEmail(email)
        					.setPassword(password)
        					.build();
        			
        			LoginResponse loginResponse = stub.login(loginRequest);
        			
        			if(loginResponse.getStatus() == LoginStatus.LOGIN_SUCCESSFULL) {
        				JOptionPane.showMessageDialog(null, "Login successfull.");
        				userStatus = "Online";
        			} else {
        				JOptionPane.showMessageDialog(null, "Wrong email or password. Login failed.");
        			}
        			break;
        		} else {
        			JOptionPane.showMessageDialog(null, "You are allready logged in.");
        			break;
        		}
        	case 1: 
        		if(userStatus.equals("Offline")) {
        			JOptionPane.showMessageDialog(null, "You are not logged in.");
        			break;
        		}
        		
        		LogoutRequest logoutRequest = LogoutRequest.newBuilder()
        				.setUserStatus(userStatus)
        				.build();
        		
        		LogoutResponse logoutResponse = stub.logout(logoutRequest);
        		
        		if(logoutResponse.getStatus() == LogoutStatus.LOGOUT_SUCCESSFULL) {
        			JOptionPane.showMessageDialog(null, "Loggout successfull.");
        			
        		userStatus = "Offline";
        		} else {
        			JOptionPane.showMessageDialog(null, "Logout failed.");
        			break;
        		}
        		break;
        	case 2:
        		exit = true;
        		break;
        		
        	}
        }
    	channel.shutdown();
        	
	}
}
