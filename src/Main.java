import design.adaptor.*;
import design.decorator.*;
import design.observer.Button;
import design.observer.IButtonListener;
import design.proxy.Browser;
import design.proxy.IBrowser;
import design.proxy.ProxyBrowser;

public class Main {
    public static void main(String[] args) {
        Button button = new Button("button");

        /* class anonyme */
        button.addEventListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("Event Message: click 1");
        button.click("Event Message: click 2");
        button.click("Event Message: click 3");
        button.click("Event Message: click 4");
    }
}