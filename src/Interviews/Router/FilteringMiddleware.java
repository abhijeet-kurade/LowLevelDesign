package Interviews.Router;

public class FilteringMiddleware implements Middleware {
    private String blockedIP;

    public FilteringMiddleware(String blockedIP) {
        this.blockedIP = blockedIP;
    }

    @Override
    public boolean process(Packet packet) {
        if (packet.getSourceIP().equals(blockedIP)) {
            System.out.println("Blocking packet from " + blockedIP);
            return false; // Stop processing and drop the packet
        }
        return true;
    }
}

