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