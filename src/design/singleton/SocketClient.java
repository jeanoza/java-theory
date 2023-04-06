package design.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;

    /*
     * Block default constructor call
     */
    private SocketClient(){}

    /*
     * Generate one time, then return same instance when getInstance called
     */
    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }
}
