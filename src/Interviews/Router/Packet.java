package Interviews.Router;

import java.util.HashMap;
import java.util.Map;

public class Packet {
    private String sourceIP;
    private String destinationIP;
    private Map<String, String> headers;
    private byte[] payload;

    public Packet(String sourceIP, String destinationIP, byte[] payload) {
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.payload = payload;
        this.headers = new HashMap<>();
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }
}

