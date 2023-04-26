package grpc.service1;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.service1.UserLoginServer;
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

        // Check if the email and password received from the client match the hardcoded values
        if (email.equalsIgnoreCase(EMAIL) && password.equals(PASSWORD)) {
            status = LoginStatus.LOGIN_SUCCESSFULL;
        }

        // Define standard value of the userStatus to Offline when initiating the server
        LoginResponse response = LoginResponse.newBuilder()
                .setStatus(status)
                .setUserStatus("Offline") // Define standard value of the userStatus to Offline when initiating the server
                .build();

        // Send response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
        String userStatus = request.getUserStatus();

        LogoutStatus status = LogoutStatus.INVALID_USERSTATUS;

        // Check if the user status received from the client is "Online"
        if (userStatus.equalsIgnoreCase("Online")) { // Check userStatus value
            status = LogoutStatus.LOGOUT_SUCCESSFULL;
        }

        LogoutResponse response = LogoutResponse.newBuilder()
                .setStatus(status)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public static void main(String args[]) throws IOException, InterruptedException {
   	 // Register service with jmDNS
        try {
            JmDNS jmdns = JmDNS.create();
            int port = 5001;
            // Create service info for JmDNS registration
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "UserLoginService", port, "User Login Service");
            jmdns.registerService(serviceInfo);
            System.out.printf("Service %s:%d registered%n", serviceInfo.getName(), port);
        } catch (IOException e) {
        	// Print an error message and exit if there was an error registering the service with JmDNS
            System.out.println(e.getMessage());
            return;
        }
        
        // Start gRPC server
        UserLoginServer userLoginServer = new UserLoginServer();
        int port = 5001;
        // Build and start the gRPC server on the specified port
        Server server = ServerBuilder.forPort(port)
                .addService(userLoginServer)
                .build()
                .start();
        
        System.out.println("Server started, listening on " + port);
        // Wait for the server to terminate
        server.awaitTermination();
    }
}
