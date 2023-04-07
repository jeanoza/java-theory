import design.adaptor.*;
import design.decorator.*;
import design.facade.SftpClient;
import design.observer.Button;
import design.observer.IButtonListener;
import design.proxy.Browser;
import design.proxy.IBrowser;
import design.proxy.ProxyBrowser;
import design.strategy.*;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        //abcd append
        EncodingStrategy append = new AppendStrategy();

        String message = "Hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        encoder.setEncodingStrategy(append);
        String appendResult = encoder.getMessage(message);

        System.out.println(base64Result);
        System.out.println(normalResult);
        System.out.println(appendResult);
    }
}