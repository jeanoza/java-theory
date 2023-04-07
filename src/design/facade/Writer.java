package design.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String format = String.format("Connect to Writer %s", fileName);
        System.out.println(format);
    }
    public void write() {
        String format = String.format("Writer %s", fileName);
        System.out.println(format);
    }
    public void fileDisconnect() {
        String format = String.format("Disconnect to Writer %s", fileName);
        System.out.println(format);
    }
}
