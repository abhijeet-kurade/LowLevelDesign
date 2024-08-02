package Interviews.Router;

public interface Middleware {
    boolean process(Packet packet);
}
