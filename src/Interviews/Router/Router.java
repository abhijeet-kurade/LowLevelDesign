package Interviews.Router;

import java.util.ArrayList;
import java.util.List;

public class Router {
    private RoutingTable routingTable;
    private List<Middleware> middlewares;

    public Router() {
        this.routingTable = new RoutingTable();
        this.middlewares = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routingTable.addRoute(route);
    }

    public void addMiddleware(Middleware middleware) {
        middlewares.add(middleware);
    }

    public void routePacket(Packet packet) {
        for (Middleware middleware : middlewares) {
            if (!middleware.process(packet)) {
                return; // Packet processing is stopped by middleware
            }
        }

        Route route = routingTable.findRoute(packet.getDestinationIP());
        if (route != null) {
            forwardPacket(packet, route);
        } else {
            System.out.println("No route found for packet to " + packet.getDestinationIP());
        }
    }

    private void forwardPacket(Packet packet, Route route) {
        System.out.println("Forwarding packet to " + packet.getDestinationIP() +
                " via next hop " + route.getNextHop() + " on interface " + route.getInterfaceName());
    }
}
