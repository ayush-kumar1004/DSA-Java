# Module 0 — Core Java Basics Recap (Steps 1–8)

A fast cheat-sheet to lock in what you already know before we build on it. Skim it, and if any line makes you go "wait, why?" — that's the one to ask me about.

---

## 1. What Java actually is

- You write `.java` source → the **compiler (`javac`)** turns it into **bytecode** (`.class`) → the **JVM** runs that bytecode.
- "Write once, run anywhere" = the same bytecode runs on any machine that has a JVM.
- **JDK** = the kit to develop (compiler + tools). **JRE** = just to run. **JVM** = the engine that runs bytecode. *(Common interview question.)*

Every program needs an entry point:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, PRAKARSH");
    }
}
```

`main` is where the JVM starts. `System.out.println` prints a line.

---

## 2. Variables & data types

Java is **statically typed** — every variable has a fixed type.

**Primitives (8):**

| Type | Use | Example |
|------|-----|---------|
| `int` | whole numbers | `int age = 22;` |
| `long` | big whole numbers | `long views = 900000L;` |
| `double` | decimals | `double price = 99.9;` |
| `float` | smaller decimals | `float f = 1.5f;` |
| `boolean` | true/false | `boolean ok = true;` |
| `char` | single character | `char grade = 'A';` |
| `byte`, `short` | small ints | rarely used |

**Non-primitive:** `String`, arrays, objects — these are **references** (they point to data, not hold it directly). This distinction matters later.

```java
final double PI = 3.14159; // final = can't be reassigned (a constant)
```

---

## 3. Operators

- **Arithmetic:** `+ - * / %` (`%` is remainder — `7 % 3` = 1)
- **Comparison:** `== != > < >= <=` (returns boolean)
- **Logical:** `&&` (and), `||` (or), `!` (not)
- **Assignment shortcuts:** `+= -= *= /=`, and `++` / `--`

Gotcha: `/` on two ints does **integer division** — `5 / 2` = `2`, not `2.5`. Use a double to get `2.5`.

---

## 4. Control flow (decisions)

```java
if (age >= 18) {
    System.out.println("Adult");
} else if (age > 12) {
    System.out.println("Teen");
} else {
    System.out.println("Kid");
}
```

**switch** — cleaner when checking one variable against many values:

```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Other");
}
```

---

## 5. Loops (repetition)

```java
// for — when you know how many times
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while — repeat while a condition holds
int n = 0;
while (n < 5) { n++; }

// do-while — runs at least once
do { n--; } while (n > 0);

// for-each — loop over a collection/array
for (String name : names) {
    System.out.println(name);
}
```

`break` = exit the loop. `continue` = skip to next iteration.

---

## 6. Arrays

A fixed-size list of one type.

```java
int[] marks = {90, 85, 70};
System.out.println(marks[0]);      // 90  (index starts at 0)
System.out.println(marks.length);  // 3   (no parentheses — it's a field)

String[] names = new String[3];    // empty, size 3
names[0] = "Prakarsh";
```

Gotcha: arrays are **fixed size**. Need a growable list? That's `ArrayList` — Module 2.

---

## 7. Strings

Text. Immutable (every "change" makes a new String).

```java
String s = "Hello";
s.length();          // 5
s.toUpperCase();     // "HELLO"
s.charAt(0);         // 'H'
s.substring(1, 3);   // "el"
s.contains("ell");   // true
s.equals("Hello");   // true  ← ALWAYS use .equals() to compare strings
s == "Hello";        // unreliable — compares references, not text
```

**The single most common beginner bug:** using `==` to compare Strings. Use `.equals()`.

---

## 8. Methods (functions)

Reusable blocks. Take inputs (parameters), optionally return a value.

```java
// returns an int
public static int add(int a, int b) {
    return a + b;
}

// returns nothing → void
public static void greet(String name) {
    System.out.println("Hi " + name);
}

int sum = add(3, 4);   // 7
greet("Prakarsh");
```

- **Return type** before the name (`int`, `void`, `String`...).
- **`void`** = returns nothing.
- **Overloading** = same method name, different parameters (valid and common). Preview of OOP.

---

## Quick self-check (answer these out loud)

1. Difference between JDK, JRE, JVM?
2. Why is `5 / 2` equal to `2` in Java?
3. Why must you compare Strings with `.equals()` and not `==`?
4. What does `arr.length` give you, and why no parentheses?
5. What's the difference between `void` and a method that returns `int`?

If you can answer all five, you're solid on basics — we go straight to OOP (Module 1). If any tripped you, tell me the number and I'll re-explain that one.
