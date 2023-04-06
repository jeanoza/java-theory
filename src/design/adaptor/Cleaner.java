package design.adaptor;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("Clear 220v on  ");
    }
}
