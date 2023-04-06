import design.singleton.ClassA;
import design.singleton.ClassB;

public class Main {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        System.out.println("Singleton test: ClassA.socketClient.equals(ClassB.socketClient)");
        System.out.println(classA.getSocketClient().equals(classB.getSocketClient()));
    }
}