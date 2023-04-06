# Design Pattern

## Singleton

Ce pattern est utile lorsqu'on a besoin une seule unique instance.
Concrètement, quand on partage les ressources :
- Connect instance de TCP Socket
- Imprimante

Prototype:
```java
package design.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;

    /*
     * Block default constructor call
     */
    private SocketClient(){}

    /*
     * Generate one time, then return same instance when getInstance called
     */
    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }
}
```

## Adaptor

- Comme l'adaptateur de la prise(ex:110v -> 220v) au quotidien

- Exemple:
```java
package design.adaptor;

public interface Electronic110V {
    void powerOn();
}
public interface Electronic220V {
    void connect();
}

class HairDryer implements Electronic110V {
    @Override
    public void powerOn() {
        System.out.println("Hair Dryer 110v on");
    }
}
class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("Air conditioner 220v on");
    }
}
class SocketAdapter implements Electronic110V {
    private final Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }
    @Override
    public void powerOn() {
        this.electronic220V.connect();
    }
}

class Main() {
    
    
    public static void main(String[] args){

        HairDryer hairDryer=new HairDryer();
        connect(hairDryer);

        AirConditioner airConditioner=new AirConditioner();
        Electronic110V adaptor=new SocketAdapter(airConditioner);
        connect(adaptor);
    } 
}

```
