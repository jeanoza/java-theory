package design.observer;

public class Button {
    private String name;
    private IButtonListener buttonListener;

    public Button(String name) {
        this.name = name;
    }
    public void addEventListener(IButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    public void click(String message) {
        buttonListener.clickEvent(message);
    }
}
