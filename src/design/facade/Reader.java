package design.facade;

public class Reader {
    private String fileName;

    public Reader(String fileName){
        this.fileName = fileName;
    }
    public void fileConnect() {
        String format = String.format("Connect to Reader %s", fileName);
        System.out.println(format);
    }
    public void read() {
        String format = String.format("Read Reader %s", fileName);
        System.out.println(format);
    }
    public void fileDisconnect(){
        String format = String.format("Disconnect to Reader %s", fileName);
        System.out.println(format);
    }
}
