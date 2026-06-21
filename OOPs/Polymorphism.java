// Polymorphism in Java
// Polymorphism means "many forms". It allows objects to behave differently based on context.
// Two types:
// 1. Compile-time Polymorphism (Method Overloading)
//    - Methods in the same class have the same name but different signatures (parameters).
// 2. Run-time Polymorphism (Method Overriding & Dynamic Method Dispatch)
//    - A subclass provides a specific implementation for a method defined in its superclass.
//    - Superclass reference pointing to subclass object resolves the method call at run-time.

// Base class for method overloading
class Calculator {
    // Method Overloading: Same name, different parameter types / count
    
    // Add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Add two double values
    double add(double a, double b) {
        return a + b;
    }
}

// Parent class for Run-time polymorphism
class SoundProducer {
    void makeSound() {
        System.out.println("Some generic sound.");
    }
}

// Child class overriding the makeSound method
class Lion extends SoundProducer {
    @Override
    void makeSound() {
        System.out.println("The lion roars: Roar!");
    }
}

// Another child class overriding the makeSound method
class Bird extends SoundProducer {
    @Override
    void makeSound() {
        System.out.println("The bird chirps: Tweet Tweet!");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("--- 1. Compile-Time Polymorphism (Method Overloading) ---");
        Calculator calc = new Calculator();
        
        System.out.println("Adding 2 ints (5 + 10): " + calc.add(5, 10));
        System.out.println("Adding 3 ints (5 + 10 + 15): " + calc.add(5, 10, 15));
        System.out.println("Adding 2 doubles (5.5 + 4.5): " + calc.add(5.5, 4.5));

        System.out.println("\n--- 2. Run-Time Polymorphism (Method Overriding) ---");
        
        // Creating parent references to child objects (Dynamic Method Dispatch)
        SoundProducer baseSound = new SoundProducer();
        SoundProducer lionSound = new Lion();
        SoundProducer birdSound = new Bird();

        // The method version executed is determined at RUN-TIME based on the actual object type
        baseSound.makeSound(); // Prints: Some generic sound.
        lionSound.makeSound(); // Prints: The lion roars: Roar!
        birdSound.makeSound(); // Prints: The bird chirps: Tweet Tweet!
    }
}
