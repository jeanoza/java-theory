package design.adaptor;

public class SocketAdapter implements Electronic110V {
    private final Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;

    }
    @Override
    public void powerOn() {
        this.electronic220V.connect();
    }
}
