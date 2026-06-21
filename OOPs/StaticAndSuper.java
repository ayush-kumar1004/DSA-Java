// Static and Super keywords in Java
// 1. static keyword:
//    - static variables: Shared by all objects of the class (class-level variable).
//    - static methods: Can be called without creating an object. Can only access static data.
//    - static block: Executed once when the class is loaded. Used for initializing static variables.
// 2. super keyword:
//    - Used to refer to immediate parent class's instance variables.
//    - Used to invoke immediate parent class's methods.
//    - Used to invoke immediate parent class's constructors (must be the first line).

class Parent {
    String name = "Parent Class Variable";

    Parent() {
        System.out.println("Parent constructor called.");
    }

    void display() {
        System.out.println("Display method inside Parent class.");
    }
}

class Child extends Parent {
    String name = "Child Class Variable";

    Child() {
        // Calling parent constructor
        super(); 
        System.out.println("Child constructor called.");
    }

    void showValues() {
        // Accessing child's field
        System.out.println("Name in Child class: " + this.name);
        
        // Accessing parent's field using super
        System.out.println("Name in Parent class (using super): " + super.name);
    }

    @Override
    void display() {
        System.out.println("Display method inside Child class.");
    }

    void invokeParentMethod() {
        // Invoking overridden parent method
        super.display();
    }
}

class UniversityStudent {
    String name;
    int id;
    
    // static variable
    static String universityName;

    // static block
    static {
        universityName = "ABC Technical University";
        System.out.println("Static block executed: University name initialized to: " + universityName);
    }

    UniversityStudent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // static method
    static void changeUniversity(String newName) {
        universityName = newName;
        // System.out.println(this.name); // ERROR: Cannot use 'this' or access non-static fields inside static context
    }

    void displayDetails() {
        System.out.println("Student: " + name + " (ID: " + id + ") | University: " + universityName);
    }
}

public class StaticAndSuper {
    public static void main(String[] args) {
        System.out.println("--- 1. Demonstration of 'super' keyword ---");
        Child c = new Child();
        c.showValues();
        c.display();
        System.out.print("Invoking parent method from child: ");
        c.invokeParentMethod();

        System.out.println("\n--- 2. Demonstration of 'static' keyword ---");
        // Creating student objects
        UniversityStudent s1 = new UniversityStudent("Ayush", 101);
        UniversityStudent s2 = new UniversityStudent("Aman", 102);

        s1.displayDetails();
        s2.displayDetails();

        // Changing the static variable using static method
        System.out.println("\nChanging university name for all students...");
        UniversityStudent.changeUniversity("XYZ National University");

        s1.displayDetails();
        s2.displayDetails();
    }
}
