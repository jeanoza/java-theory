package design.adaptor;

public class HairDryer implements Electronic110V {
    @Override
    public void powerOn() {
        System.out.println("Hair Dryer 110v on");
    }
}
