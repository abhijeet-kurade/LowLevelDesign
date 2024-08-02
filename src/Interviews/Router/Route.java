package Interviews.Router;

public class Route {
    private String destination;
    private String nextHop;
    private String netmask;
    private String interfaceName;

    public Route(String destination, String nextHop, String netmask, String interfaceName) {
        this.destination = destination;
        this.nextHop = nextHop;
        this.netmask = netmask;
        this.interfaceName = interfaceName;
    }

    public String getDestination() {
        return destination;
    }

    public String getNextHop() {
        return nextHop;
    }

    public String getNetmask() {
        return netmask;
    }

    public String getInterfaceName() {
        return interfaceName;
    }
}
