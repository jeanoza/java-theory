package design.adaptor;

public class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("Air conditioner 220v on");
    }
}
