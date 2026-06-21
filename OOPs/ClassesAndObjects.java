// Classes and Objects in Java
// A class is a blueprint or template from which individual objects are created.
// An object is an instance of a class that has state (attributes) and behavior (methods).

class SimpleStudent {
    // Attributes / Properties (State)
    String name;
    int rollNo;
    double cgpa;

    // Methods (Behavior)
    void study() {
        System.out.println(name + " is studying.");
    }

    void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + this.name); // 'this' refers to the current object
        System.out.println("Roll No: " + this.rollNo);
        System.out.println("CGPA: " + this.cgpa);
    }
}

public class ClassesAndObjects {
    public static void main(String[] args) {
        // Creating an object of the SimpleStudent class using the 'new' keyword
        SimpleStudent s1 = new SimpleStudent();

        // Assigning values to object attributes
        s1.name = "Ayush";
        s1.rollNo = 45;
        s1.cgpa = 9.2;

        // Calling methods on the object
        s1.displayDetails();
        s1.study();

        System.out.println("-------------------------");

        // Creating another object
        SimpleStudent s2 = new SimpleStudent();
        s2.name = "Rohan";
        s2.rollNo = 12;
        s2.cgpa = 8.5;

        s2.displayDetails();
        s2.study();
    }
}
