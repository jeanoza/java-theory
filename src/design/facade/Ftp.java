package design.facade;

public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("Connection - FTP host: " +host+ "Port: "+port+")");
    }
    public void moveDirectory(){
        System.out.println("Move to FTP path: "+path);
    }
    public void disconnect(){
        System.out.println("FTP disconnect");
    }

}
