# SOLID

## SRP : Single Responsibility Principal

- Seule raison pour laquelle on modifie telle class.

- Afin d'éviter :
```java
class Unit {
    private String name;
    private int speed;
    private boolean conflict;
    
    public void attack() {}
    public void move() {
        if (name.equals("Zergling")) {
            speed += 3;
        } else if (name.equals("Siege tank")) {
            if (SIEGE_MODE) {
                speed = 0;
            } else {
                speed = 10;
            }
        } else if (name.equals("Dropship")) {
            speed = 15;
            conflict = false;
        }
        /* ... */
    }
}
```

- Solution:
```java
class Zergling extends Unit {
    @Override
    public void move() {
        speed += 3;
    }
}
class Tank extends Unit {
    @Override
    public void move() {
        if (SIEGE_MODE){
            speed = 0;
        } else {
            speed = 10; 
        }
    }
}
class DropShip extends Unit {
    public DropShip() {
        this.conflict = false;
    }
    @Override
    public void move() {
        speed = 15;
    }
}
```

## OCP : Open Closed Principle

- Open pour extention
- Close pour modification
- L'objectif est d'éviter la répétition et de ne pas besoin de modifier le code déjà fait.
- `interface` et `abstract class` nous permet de faire cette pratique.

## LCP: Liskov Substitution Principle

- `child(sub-type)` peut se remplacer par `parent(super-type)`
- Mauvaise héritation:
```text
    dog
     |
  |------|
  |      |
 cat    tiger
```
- Bonne hériatation
```text
  Anmial
    |
 |------|
 |      |
 dog    cat
```

## ISP: Interface Segregation Principle

- Séparer bien interface afin de diminuer la dépendence et d'augmenter la maintenabilité et qualité de code.

- Mauvais exemple:
```java
interface Map {
    guideWork();
    guideCar();
    guideBike();
    GuideAirplane();
    /* ... */
}
class People implements Map {
    guideWalk();
    /* ... */
    
}
class Car implements Map {
    guideCar();
    /* ... */
}
/* ... */
```

- Bon exemple :
```java
interface CarMap {
    guideCar();
}
interface PeopleMap {
    guideWalk();
}
class People implements PeopleMap {
    guideWalk();
}
class Car implements CarMap {
    guideCar();
}
/* ... */
```

## DIP: Dependency Inversion Principle
- `super-type` ne doit pas dependre de `sub-type`
- A peu près pareil que l'idée de OCP
- Mauvais exemple:
```java
class People {}
class SummerClothing extends People {}
class WinterClothing extends People {}
class AutumnClothing extends People {}
```
- Bon exemple:
```java
interface People {}
abstract class Clothing implements People {}
class SummerClothing extends Clothing {}
class WinterClothing extends Clothing {}
class AutumnClothing extends Clothing {}
```
