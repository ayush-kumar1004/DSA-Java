// Constructors in Java
// A constructor is a special block of code that is called when an object is created.
// It has the same name as the class and has no return type.
// It can be non-parameterized, parameterized, or a copy constructor.
// Constructor Overloading: Multiple constructors with different parameters.
// Shallow Copy vs Deep Copy:
// - Shallow Copy: Copies reference pointers; changes in copy affect the original.
// - Deep Copy: Creates new reference structures; changes in copy do NOT affect the original.

class ConstructorStudent {
    String name;
    int rollNo;
    int marks[];

    // 1. Non-parameterized Constructor
    ConstructorStudent() {
        System.out.println("Non-parameterized constructor called.");
        this.marks = new int[3];
    }

    // 2. Parameterized Constructor
    ConstructorStudent(String name, int rollNo) {
        System.out.println("Parameterized constructor called.");
        this.name = name;
        this.rollNo = rollNo;
        this.marks = new int[3];
    }

    // 3. Copy Constructor (Deep Copy version)
    // Creates a new array and copies the content.
    ConstructorStudent(ConstructorStudent s) {
        System.out.println("Copy constructor (Deep Copy) called.");
        this.name = s.name;
        this.rollNo = s.rollNo;
        this.marks = new int[s.marks.length];
        for (int i = 0; i < s.marks.length; i++) {
            this.marks[i] = s.marks[i]; // Copies elements individually
        }
    }

    // Constructor/Factory method to demonstrate Shallow Copy specifically
    static ConstructorStudent createShallowCopy(ConstructorStudent original) {
        ConstructorStudent copy = new ConstructorStudent();
        copy.name = original.name;
        copy.rollNo = original.rollNo;
        copy.marks = original.marks; // Reference sharing
        return copy;
    }

    void display() {
        System.out.print("Name: " + name + ", Roll No: " + rollNo + ", Marks: [");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + (i < marks.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

public class Constructors {
    public static void main(String[] args) {
        // Using non-parameterized constructor
        ConstructorStudent s1 = new ConstructorStudent();
        s1.name = "Ayush";
        s1.rollNo = 101;
        s1.marks[0] = 90;
        s1.marks[1] = 85;
        s1.marks[2] = 95;
        System.out.print("Original (s1): ");
        s1.display();

        System.out.println("\n--- Shallow Copy Demonstration ---");
        // Creating a shallow copy of s1
        ConstructorStudent s2 = ConstructorStudent.createShallowCopy(s1);
        System.out.print("Shallow Copy (s2): ");
        s2.display();

        // Modifying marks of s2 (the copy)
        s2.marks[1] = 100;
        System.out.println("Modified s2 marks[1] to 100.");
        
        // Let's print both. Since it was a shallow copy, s1's marks are also modified!
        System.out.print("Original (s1) after shallow modification: ");
        s1.display();
        System.out.print("Shallow Copy (s2): ");
        s2.display();

        System.out.println("\n--- Deep Copy Demonstration ---");
        // Resetting marks
        s1.marks[1] = 85; 

        // Creating a deep copy of s1 using copy constructor
        ConstructorStudent s3 = new ConstructorStudent(s1);
        System.out.print("Deep Copy (s3): ");
        s3.display();

        // Modifying marks of s3 (the deep copy)
        s3.marks[1] = 99;
        System.out.println("Modified s3 marks[1] to 99.");

        // Let's print both. Since it is a deep copy, s1's marks remain unchanged!
        System.out.print("Original (s1) after deep modification: ");
        s1.display();
        System.out.print("Deep Copy (s3): ");
        s3.display();
    }
}
