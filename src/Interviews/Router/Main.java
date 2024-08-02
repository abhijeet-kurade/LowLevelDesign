package Interviews.Router;

public class Main {
    public static void main(String[] args) {
        Router router = new Router();

        // Add routes
        router.addRoute(new Route("192.168.1.0", "192.168.1.1", "255.255.255.0", "eth0"));
        router.addRoute(new Route("10.0.0.0", "10.0.0.1", "255.0.0.0", "eth1"));

        // Add middlewares
        router.addMiddleware(new LoggingMiddleware());
        router.addMiddleware(new FilteringMiddleware("192.168.1.100"));

        // Create packets
        Packet packet1 = new Packet("192.168.1.50", "192.168.1.10", new byte[0]);
        Packet packet2 = new Packet("192.168.1.100", "192.168.1.10", new byte[0]);

        // Route packets
        router.routePacket(packet1); // Should be processed
        router.routePacket(packet2); // Should be blocked
    }
}
