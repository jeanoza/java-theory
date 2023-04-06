import design.adaptor.*;

public class Main {
    public static void main(String[] args) {
        /* singleton
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        System.out.println("Singleton test: ClassA.socketClient.equals(ClassB.socketClient)");
        System.out.println(classA.getSocketClient().equals(classB.getSocketClient()));
         */
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adaptor =  new SocketAdapter(cleaner);
        connect(adaptor);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adaptor2 = new SocketAdapter(airConditioner);
        connect(adaptor2);
    }

    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}