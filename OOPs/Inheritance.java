// Inheritance in Java
// Inheritance allows a subclass to inherit the fields and methods of a superclass.
// Types of inheritance demonstrated:
// 1. Single-level: A -> B
// 2. Multi-level: A -> B -> C
// 3. Hierarchical: A -> B, A -> C
// 4. Hybrid: A -> B & C, and B & C -> D (in Java, classes can only extend one class, but multiple inheritance can be achieved via interfaces).

// Base class
class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating.");
    }

    void breathe() {
        System.out.println(name + " is breathing.");
    }
}

// 1. Single-level Inheritance: Dog inherits from Animal
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking: Woof! Woof!");
    }
}

// 2. Multi-level Inheritance: Labrador inherits from Dog, which inherits from Animal
class Labrador extends Dog {
    String color;
    
    void displayColor() {
        System.out.println(name + " is a " + color + " Labrador.");
    }
}

// 3. Hierarchical Inheritance: Cat also inherits from Animal (Animal has multiple children: Dog and Cat)
class Cat extends Animal {
    void meow() {
        System.out.println(name + " is meowing: Meow! Meow!");
    }
}

// 4. Hybrid/Multiple Inheritance Simulation using Interfaces
// Java doesn't support multiple inheritance of classes (e.g. extending two classes), but can implement multiple interfaces.
interface Swimmer {
    void swim();
}

interface Runner {
    void run();
}

// Amphibian implements both Swimmer and Runner interfaces (Multiple/Hybrid inheritance simulation)
class Frog extends Animal implements Swimmer, Runner {
    Frog(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming in the pond.");
    }

    @Override
    public void run() {
        System.out.println(name + " is hopping on the ground.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("--- 1. Single-Level Inheritance ---");
        Dog myDog = new Dog();
        myDog.name = "Rocky";
        myDog.eat();     // Inherited from Animal
        myDog.breathe(); // Inherited from Animal
        myDog.bark();    // Defined in Dog

        System.out.println("\n--- 2. Multi-Level Inheritance ---");
        Labrador myLab = new Labrador();
        myLab.name = "Bruno";
        myLab.color = "Golden";
        myLab.eat();          // Inherited from Animal (via Dog)
        myLab.bark();         // Inherited from Dog
        myLab.displayColor(); // Defined in Labrador

        System.out.println("\n--- 3. Hierarchical Inheritance ---");
        Cat myCat = new Cat();
        myCat.name = "Luna";
        myCat.eat();     // Inherited from Animal
        myCat.meow();    // Defined in Cat

        System.out.println("\n--- 4. Hybrid/Multiple Inheritance (via Interfaces) ---");
        Frog myFrog = new Frog("Kermit");
        myFrog.eat();     // Inherited from Animal
        myFrog.swim();    // Implemented from Swimmer
        myFrog.run();     // Implemented from Runner
    }
}
