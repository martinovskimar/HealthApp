package grpc.service3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HealthActivitiesClient {

    private ManagedChannel channel;
    private HealthActivitiesServiceGrpc.HealthActivitiesServiceBlockingStub blockingStub;

    public void start() throws IOException, InterruptedException {
        // Use JmDNS to discover the server
        JmDNS jmdns = JmDNS.create();
        String serviceType = "_grpc._tcp.local.";
        String serviceName = "HealthActivitiesService";

        ServiceListener serviceListener = new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                // Do nothing
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
                // Do nothing
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                String host = event.getInfo().getHostAddress();
                int port = event.getInfo().getPort();

                System.out.println("Discovered server at " + host + ":" + port);

                // Create a ManagedChannel to the server and a blocking stub for making gRPC calls
                channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
                blockingStub = HealthActivitiesServiceGrpc.newBlockingStub(channel);
            }
        };

        jmdns.addServiceListener(serviceType, serviceListener);
        System.out.println("Searching for server...");

        // Wait for the server to be discovered
        Thread.sleep(5000);

        jmdns.removeServiceListener(serviceType, serviceListener);
        jmdns.close();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
    public void exercise() {}
    
   
}
