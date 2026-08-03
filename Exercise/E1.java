// E1.java  — OOP exercise (corrected)
// Run:  javac E1.java   then   java E1

public class E1 {
    public static void main(String[] args) {
        // Notice the reference type is Vehicle, but the object is Car / Bike.
        // That is polymorphism: the OBJECT decides which move() runs.
        Vehicle car  = new Car("Toyota", 120);
        Vehicle bike = new Bike("Honda", 80);

        // Put both in a Vehicle[] and loop — each prints its own version.
        Vehicle[] vehicles = { car, bike };
        for (Vehicle v : vehicles) {
            v.move();                                            // calls the subclass version
            System.out.println("  brand: " + v.getBrand()
                             + ", speed: " + v.getSpeed() + " km/h");
        }
    }
}

// ---- Parent class ----
class Vehicle {
    private String brand;   // private = encapsulation
    private int speed;

    Vehicle(String brand, int speed) {   // constructor
        this.brand = brand;
        this.speed = speed;
    }

    // getters (asked for in the exercise)
    public String getBrand() { return brand; }
    public int getSpeed()    { return speed; }

    // base behaviour that children will override
    public void move() {
        System.out.println(brand + " is moving");
    }
}

// ---- Child classes ----
class Car extends Vehicle {
    Car(String brand, int speed) {
        super(brand, speed);    // pass values up to Vehicle's constructor
    }

    @Override
    public void move() {
        System.out.println("Car moves.");
    }
}

class Bike extends Vehicle {
    Bike(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println("Bike moves.");
    }
}