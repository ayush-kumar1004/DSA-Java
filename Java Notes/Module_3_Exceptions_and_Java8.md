# Module 3 — Exceptions & Java 8 Features

Two topics in one, because both come up constantly. **Exceptions** = how Java handles errors without crashing. **Java 8 features** (lambdas, streams, Optional) = the modern style you'll see in every real codebase and get asked about. This is the stuff that makes you look current instead of stuck in 2010.

---

# Part A — Exceptions

## 1. What an exception is

An **exception** is Java's way of saying "something went wrong at runtime" — dividing by zero, opening a missing file, calling a method on `null`. Instead of crashing, Java *throws* an exception you can *catch* and handle.

```java
int[] arr = {1, 2, 3};
System.out.println(arr[5]);   // throws ArrayIndexOutOfBoundsException
```

---

## 2. try / catch / finally

```java
try {
    int result = 10 / 0;              // risky code
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero: " + e.getMessage());
} finally {
    System.out.println("This ALWAYS runs (cleanup)");
}
```

- **`try`** — wrap the risky code.
- **`catch`** — handle a specific exception type. You can have multiple catch blocks.
- **`finally`** — always runs, whether or not an exception happened. Used for cleanup (closing files/connections).

You can catch multiple types:

```java
catch (IOException | SQLException e) { ... }
```

---

## 3. The exception hierarchy

```
Throwable
├── Error          → serious JVM problems (OutOfMemoryError) — you DON'T catch these
└── Exception
    ├── (checked)  → IOException, SQLException...  compiler forces you to handle
    └── RuntimeException (unchecked) → NullPointerException,
                                       ArithmeticException,
                                       ArrayIndexOutOfBounds...
```

**Checked vs unchecked** (very common question):
- **Checked** — the compiler *forces* you to handle or declare them (`try/catch` or `throws`). Usually external problems (files, DB, network). Example: `IOException`.
- **Unchecked** (`RuntimeException` and its children) — programming bugs, not forced by the compiler. Example: `NullPointerException`.

**One-liner:** "Checked exceptions are checked at compile time and must be handled or declared; unchecked (runtime) exceptions are not enforced by the compiler and usually signal bugs."

---

## 4. throw vs throws

- **`throw`** — actually *throw* an exception right now.
- **`throws`** — *declare* that a method might throw one (in the signature).

```java
public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException("Not enough balance");
    }
    balance -= amount;
}
```

---

## 5. Custom exceptions

Make your own for domain-specific errors — just extend `Exception` (checked) or `RuntimeException` (unchecked).

```java
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

You'll do exactly this in Spring Boot (e.g. `UserNotFoundException`).

---

## 6. Best practices (say these and you sound senior)

- Catch **specific** exceptions, not bare `catch (Exception e)`.
- Never leave an empty catch block (swallowing errors silently).
- Use `finally` or **try-with-resources** for cleanup:

```java
try (Scanner sc = new Scanner(System.in)) {
    // sc auto-closes at the end, even on error
}
```

---

# Part B — Java 8 Features

## 7. Lambda expressions

A **lambda** is a short, anonymous function — a block of code you pass around like a value. Syntax: `(params) -> body`.

```java
// old way: anonymous class
Runnable r1 = new Runnable() {
    public void run() { System.out.println("run"); }
};

// lambda way — same thing, tiny
Runnable r2 = () -> System.out.println("run");

// with params
Comparator<Integer> byValue = (a, b) -> a - b;
```

Lambdas work with **functional interfaces** — any interface with exactly one abstract method (`Runnable`, `Comparator`, `Callable`, or your own marked `@FunctionalInterface`).

---

## 8. Streams — the big one

A **Stream** lets you process a collection in a clean, pipeline style: filter → transform → collect. No manual loops.

```java
import java.util.*;
import java.util.stream.*;

List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

// old way
List<Integer> evens = new ArrayList<>();
for (int n : nums) if (n % 2 == 0) evens.add(n);

// stream way
List<Integer> evens2 = nums.stream()
    .filter(n -> n % 2 == 0)     // keep evens
    .collect(Collectors.toList()); // → [2, 4, 6]
```

The common operations:

```java
nums.stream()
    .filter(n -> n > 2)          // keep some
    .map(n -> n * 10)            // transform each → 30,40,50,60
    .forEach(System.out::println);

long count = nums.stream().filter(n -> n % 2 == 0).count();      // 3
int sum    = nums.stream().mapToInt(Integer::intValue).sum();   // 21
Optional<Integer> max = nums.stream().max(Comparator.naturalOrder());

List<String> names = users.stream()
    .map(u -> u.getName())       // extract names
    .collect(Collectors.toList());
```

- **`filter`** — keep elements matching a condition.
- **`map`** — transform each element.
- **`collect`** — gather results back into a list/set/map.
- **`reduce` / `sum` / `count`** — combine into one value.

**Interview line:** "Streams let me process collections declaratively — filter, map, collect — instead of writing explicit loops, which is more readable."

---

## 9. Optional — killing the NullPointerException

`Optional<T>` is a box that either holds a value or is empty — a clean way to say "this might be null" so callers handle it safely.

```java
Optional<User> found = userRepo.findByEmail("x@y.com");

if (found.isPresent()) {
    System.out.println(found.get().getName());
}
// or cleaner:
String name = found.map(User::getName).orElse("Unknown");
```

You'll see `Optional` all over Spring Data JPA (`findById` returns one). **One-liner:** "Optional is a container that may or may not hold a value — it forces you to handle the empty case and avoids NullPointerExceptions."

---

## 10. Method references (quick)

Shorthand for a lambda that just calls one method: `System.out::println` means `x -> System.out.println(x)`. Nice to recognize; not essential to master.

---

## Interview questions (drill these)

1. What is the difference between checked and unchecked exceptions?
2. Difference between `throw` and `throws`?
3. What does `finally` do? Does it run if there's a `return` in `try`? *(Yes.)*
4. What is a lambda expression? What's a functional interface?
5. What is a Stream? Explain `filter` vs `map`.
6. What problem does `Optional` solve?
7. What is try-with-resources?

---

## Try it yourself

Given `List<String> names = List.of("prakarsh", "aditi", "rahul", "amit", "anita");`

1. Use a **stream** to keep only names starting with `"a"`, uppercase them, and collect into a new list. (Expect `[ADITI, AMIT, ANITA]`.)
2. Count how many names have more than 4 letters.
3. Write a method `divide(int a, int b)` that throws a custom `DivideByZeroException` when `b == 0`, and call it inside a `try/catch`.

Paste your code and I'll check it.
