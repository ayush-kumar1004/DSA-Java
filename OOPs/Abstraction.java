// Abstraction in Java
// Abstraction is the process of hiding implementation details and showing only essential features.
// It can be achieved in two ways:
// 1. Abstract Classes: Classes that cannot be instantiated. Can contain abstract and non-abstract methods.
// 2. Interfaces: Blueprint of a class. It contains static constants and abstract methods (representing 100% abstraction).
//    Also allows Java to support multiple inheritance simulation.

// 1. Abstract Class Example
abstract class Vehicle {
    String type;

    // Abstract classes can have constructors
    Vehicle(String type) {
        this.type = type;
    }

    // Abstract method: does not have a body, must be implemented by subclasses
    abstract void start();

    // Concrete method: has a body
    void stop() {
        System.out.println("The " + type + " has stopped.");
    }
}

class Car extends Vehicle {
    Car() {
        super("Car");
    }

    // Implementing the abstract method
    @Override
    void start() {
        System.out.println("Car starts with a key ignition or button press.");
    }
}

// 2. Interface Example
interface GPS {
    // Interface variables are implicitly public, static, and final
    String SYSTEM_NAME = "Global Positioning System";

    // Interface methods are implicitly public and abstract
    void trackLocation();
}

interface Camera {
    void captureImage();
}

// SmartCar inherits Car and implements GPS and Camera (Multiple Inheritance simulation)
class SmartCar extends Car implements GPS, Camera {
    @Override
    public void trackLocation() {
        System.out.println("Tracking vehicle location using " + SYSTEM_NAME);
    }

    @Override
    public void captureImage() {
        System.out.println("Capturing surrounding video feed via dashcam.");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        System.out.println("--- 1. Abstract Class Demonstration ---");
        // Vehicle v = new Vehicle(); // ERROR! Abstract class cannot be instantiated directly.

        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();

        System.out.println("\n--- 2. Interface / Multiple Inheritance Demonstration ---");
        SmartCar myTesla = new SmartCar();
        myTesla.start();          // Inherited method
        myTesla.trackLocation();   // Implemented from GPS
        myTesla.captureImage();    // Implemented from Camera
        myTesla.stop();           // Inherited method
    }
}
