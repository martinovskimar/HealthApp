package grpc.examples.userLogin;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

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

    public static void main(String args[]) throws IOException, InterruptedException {
    	 // Register service with jmDNS
        try {
            JmDNS jmdns = JmDNS.create();
            int port = 5001;
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "UserLoginService", port, "User Login Service");
            jmdns.registerService(serviceInfo);
            System.out.printf("Service %s:%d registered%n", serviceInfo.getName(), port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        // Start gRPC server
        UserLoginServer userLoginServer = new UserLoginServer();
        int port = 5001;
        Server server = ServerBuilder.forPort(port)
                .addService(userLoginServer)
                .build()
                .start();
        
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}

