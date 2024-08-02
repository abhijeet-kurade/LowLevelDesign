package Interviews.Router;

public class LoggingMiddleware implements Middleware {
    @Override
    public boolean process(Packet packet) {
        System.out.println("Processing packet from " + packet.getSourceIP() + " to " + packet.getDestinationIP());
        return true; // Continue processing
    }
}

