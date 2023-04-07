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

## Proxy
- Le pattern Proxy est un modèle de conception qui permet de
créer un objet qui agit comme un substitut pour un autre objet.
Le but de ce modèle est de contrôler l'accès à un objet
en fournissant une interface de substitution pour cet objet.
- On peut l'appliquer comme cache.
- OCP(open closed principle) et DIP(Dependency Inversion Principle)
- exemple:
```java
public class ProxyBrowser implements IBrowser{
    private String url;
    private Html html;

    public ProxyBrowser(String url) {
        this.url = url;
    }
    @Override
    public Html show() {
        if (html == null) {
            this.html = new Html(url);
            System.out.println("Browser proxy loading html from " + url);
        }
        System.out.println("Browser proxy use cached html");
        return this.html;
    }
}
```

## Decorator
- Utile lors d'ajouter les fonctionalités tout en laissant `Class` Origin.
- `Decorator class` wrappe(sauvegarde) un `Object` en tant que son `attribut` 
- Puis, `method call` se fait via `Decorator class`
- Avantage :
  - ne pas toucher la class origin
  - `Decorator class` écrit de manière indépendente.
  - Donc, la réutilisabilité s'augmente.
- inconvénient: Complexité s'augmente en cas d'abus.
- exemple:
```java
package design.decorator;

public class Audi implements ICar{
    private int price;

    public Audi(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi's price is "+price+" euros.");
    }
}


public class AudiDecorator implements ICar{

    protected ICar audi;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(ICar audi, String modelName, int modelPrice) {
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }
    @Override
    public int getPrice() {
        return audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName +"'s price is "+getPrice()+" euros.");
    }
}

```

## Observer

- Lors d'un changement d'un `Object A`,
il annonce à tous les `Objects`
qui ont la dépendence pour cet `Object A`
- Exemple: eventListener in JS-DOM, Swing... etc
- Ce pattern permets d'un couplage léger, donc, augmente la maintenabilité.
- Cependant, en cas d'abus, la performance se diminue.
- Exemple:
```java
package design.observer;

public interface IButtonListener {
  void clickEvent(String event);
}

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

```



