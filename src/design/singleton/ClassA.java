package design.singleton;

public class ClassA {

    private SocketClient socketClient;
    public ClassA() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
