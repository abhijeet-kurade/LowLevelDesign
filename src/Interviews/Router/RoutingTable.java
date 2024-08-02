package Interviews.Router;

import java.util.ArrayList;
import java.util.List;

public class RoutingTable {
    private List<Route> routes;

    public RoutingTable() {
        this.routes = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public Route findRoute(String destinationIP) {
        for (Route route : routes) {
            if (matches(destinationIP, route.getDestination(), route.getNetmask())) {
                return route;
            }
        }
        return null; // No matching route found
    }

    private boolean matches(String ip, String destination, String netmask) {
        String[] ipParts = ip.split("\\.");
        String[] destParts = destination.split("\\.");
        String[] maskParts = netmask.split("\\.");

        for (int i = 0; i < 4; i++) {
            int ipPart = Integer.parseInt(ipParts[i]);
            int destPart = Integer.parseInt(destParts[i]);
            int maskPart = Integer.parseInt(maskParts[i]);

            if ((ipPart & maskPart) != (destPart & maskPart)) {
                return false;
            }
        }
        return true;
    }
}

