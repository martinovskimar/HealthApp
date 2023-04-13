package grpc.examples.userLogin;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class UserLoginServer extends userLoginGrpc.userLoginImplBase {



	private static final String EMAIL = "email@nci.com";
    private static final String PASSWORD = "NCIPassword";
    
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
	        String email = request.getEmail();
	        String password = request.getPassword();

	        LoginStatus status = LoginStatus.INCORRECT_LOGIN_DETAILS;

	        if (email.equalsIgnoreCase(EMAIL) && password.equals(PASSWORD)) {
	            status = LoginStatus.LOGIN_SUCCESSFULL;
	        }

	        LoginResponse response = LoginResponse.newBuilder()
	                .setStatus(status)
	                .setUserStatus("Offline") // Define standard value of the userStatus to Offline when initiating the server
	                .build();
	        
	        responseObserver.onNext(response); // Send response back to the client
	        responseObserver.onCompleted();
	}
	
    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
        String userStatus = request.getUserStatus();

        LogoutStatus status = LogoutStatus.INVALID_USERSTATUS;

        if (userStatus.equalsIgnoreCase("Online")) { // Check userStatus value
            status = LogoutStatus.LOGOUT_SUCCESSFULL;
        }

        LogoutResponse response = LogoutResponse.newBuilder()
                .setStatus(status)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

	
	public static void main(String args []) throws IOException, InterruptedException {
		
		UserLoginServer userLoginServer = new UserLoginServer();
		
		int port = 5001;
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(userLoginServer)
					.build()
					.start();
			
			System.out.println("Server started, listening on " + port);
			
			server.awaitTermination();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ee) {
			ee.printStackTrace();
		
		}
	}
}
