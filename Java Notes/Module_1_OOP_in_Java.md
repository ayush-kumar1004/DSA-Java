# Module 1 — OOP in Java

**The single most important interview topic.** Almost every Java interview opens with some version of "explain OOP" or "what are the four pillars." Nail this module and you've handled a huge chunk of your interviews. Everything in Spring Boot later is built on these ideas, so this is also the foundation for the whole roadmap.

---

## 1. The core idea: class vs object

- A **class** is a blueprint. A **object** is a real thing built from that blueprint.
- Blueprint of a house (class) → the actual houses built from it (objects).

```java
// The blueprint
class Student {
    String name;     // fields (also called attributes / state)
    int age;

    void introduce() {              // method (behavior)
        System.out.println("Hi, I'm " + name);
    }
}

// Using it
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();   // s1 is an OBJECT
        s1.name = "Prakarsh";
        s1.age = 22;
        s1.introduce();               // Hi, I'm Prakarsh

        Student s2 = new Student();   // a different object
        s2.name = "Aditi";
    }
}
```

`new Student()` builds an object in memory; `s1` holds a reference to it. `s1` and `s2` are two independent objects from the same class.

**Interview line:** "A class is a template that defines state (fields) and behavior (methods); an object is an instance of that class created at runtime with `new`."

---

## 2. Constructors

A special method that runs when you create an object — used to set it up. Same name as the class, no return type.

```java
class Student {
    String name;
    int age;

    // constructor
    Student(String name, int age) {
        this.name = name;   // 'this' = the current object
        this.age = age;
    }
}

Student s1 = new Student("Prakarsh", 22);  // clean, one line
```

- `this.name = name` means "set *this object's* name field to the parameter `name`." `this` clears up the naming clash.
- If you write no constructor, Java gives you a free empty one. Write your own and that free one disappears (unless you add it back).
- **Constructor overloading** = multiple constructors with different parameters (e.g. one that takes name+age, one that takes just name).

---

## 3. The four pillars (memorize these — always asked)

### Pillar 1 — Encapsulation
**Bundle data + methods together, and hide the data behind methods.** You make fields `private`, then expose controlled `get`/`set` methods. This protects data from invalid changes.

```java
class BankAccount {
    private double balance;   // hidden — can't touch directly from outside

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;   // validation lives here
    }
}
```

Why it matters: nobody can set `balance = -5000` from outside. All access goes through methods you control. **Interview line:** "Encapsulation = data hiding via private fields + public getters/setters, giving controlled access."

### Pillar 2 — Inheritance
**One class reuses another.** A child class (`extends`) gets the parent's fields and methods, and can add its own.

```java
class Animal {
    void eat() { System.out.println("eating"); }
}

class Dog extends Animal {   // Dog IS-A Animal
    void bark() { System.out.println("woof"); }
}

Dog d = new Dog();
d.eat();   // inherited from Animal
d.bark();  // its own
```

- `super` refers to the parent (e.g. `super.eat()` or `super(...)` to call the parent constructor).
- Test to use inheritance: the **"IS-A"** relationship. A Dog *is a* Animal. ✅ A Car is *not* an Engine (that's "HAS-A" → use a field instead).

### Pillar 3 — Polymorphism
**"Many forms" — the same call behaves differently depending on the object.** Two types:

**(a) Overriding (runtime):** child redefines a parent method.

```java
class Animal { void sound() { System.out.println("some sound"); } }
class Cat extends Animal { void sound() { System.out.println("meow"); } }

Animal a = new Cat();   // reference type Animal, object is Cat
a.sound();              // "meow"  ← the OBJECT's version runs
```

**(b) Overloading (compile-time):** same method name, different parameters (you saw this in Module 0).

```java
int add(int a, int b) { return a + b; }
double add(double a, double b) { return a + b; }
```

**Interview line:** "Overloading = same name, different parameters, resolved at compile time. Overriding = child replaces parent's method, resolved at runtime."

### Pillar 4 — Abstraction
**Show *what* something does, hide *how*.** You expose a simple interface and hide the messy details. Done with **abstract classes** and **interfaces**.

```java
interface Payment {
    void pay(double amount);   // WHAT it does, no HOW
}

class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");  // the HOW
    }
}

Payment p = new UpiPayment();
p.pay(500);
```

Everyone using `Payment` just calls `pay()` — they don't care if it's UPI, card, or cash. That's abstraction.

---

## 4. Interface vs abstract class (very common interview question)

| | Interface | Abstract class |
|---|---|---|
| Keyword | `implements` | `extends` |
| Multiple? | A class can implement **many** interfaces | Can extend **only one** class |
| Fields | constants only | normal fields allowed |
| Methods | abstract by default (+ `default` methods allowed) | mix of abstract + normal |
| Use when | "can-do" capability many unrelated classes share (`Comparable`, `Runnable`) | closely related classes sharing common base code |

**One-liner to remember:** "Interface = a contract of what a class *can do*; abstract class = a partially-built base class to *extend*."

---

## 5. Four keywords you'll be asked about

- **`static`** — belongs to the *class*, not any object. Shared by all. `Math.max()` is static — you don't make a `Math` object. `main` is static so the JVM can call it without creating an object.
- **`final`** — can't change. `final` variable = constant; `final` method = can't override; `final` class = can't extend.
- **`this`** — the current object.
- **`super`** — the parent object.

---

## 6. Interview questions from this module (drill these)

1. What is the difference between a class and an object?
2. Explain the four pillars of OOP with a real example. *(Practice saying this in 60 seconds.)*
3. Difference between method overloading and overriding?
4. Interface vs abstract class — when do you use each?
5. What is encapsulation and why is it useful?
6. What does the `static` keyword mean? Why is `main` static?
7. What is the difference between `this` and `super`?
8. Can Java have multiple inheritance? *(Answer: not via classes — to avoid ambiguity — but yes via multiple interfaces.)*

---

## 7. Try it yourself (do this — it's how it sticks)

Model a tiny system. Create:

1. A class `Vehicle` with `private` fields `brand` and `speed`, a constructor, and a getter for each.
2. A method `move()` that prints `"<brand> is moving"`.
3. Two subclasses `Car` and `Bike` that **extend** `Vehicle` and **override** `move()` with their own message.
4. In `main`, make a `Car` and a `Bike`, put both in an `Animal[]`… I mean a `Vehicle[]` array, loop over it, and call `move()` on each. Watch polymorphism in action — each prints its own version.

Paste your code here when done and I'll review it line by line and point out anything to fix. If you get stuck anywhere, tell me exactly where and we debug it together.

---

**Coaching map:** this module underpins everything from your coaching step 9 onward — every controller, entity, and service class you'll write in Spring Boot is a Java class using these exact concepts. Solid here = the rest gets much easier.
