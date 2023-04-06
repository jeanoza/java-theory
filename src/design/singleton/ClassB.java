package design.singleton;

public class ClassB {

    private SocketClient socketClient;
    public ClassB() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
