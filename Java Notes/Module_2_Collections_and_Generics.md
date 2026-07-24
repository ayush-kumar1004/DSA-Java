# Module 2 — Collections & Generics

Arrays are fixed-size and clumsy. The **Collections Framework** is Java's set of ready-made, resizable data structures — lists, sets, maps. You will use these *constantly* in real projects (a list of users, a map of settings), and "ArrayList vs HashMap" type questions are guaranteed in interviews. This is one of the highest-yield modules.

---

## 1. The big picture

Three families you must know:

| Family | Keeps | Duplicates? | Ordered? | Main classes |
|--------|-------|-------------|----------|--------------|
| **List** | a sequence | ✅ allowed | ✅ by index | `ArrayList`, `LinkedList` |
| **Set** | unique items | ❌ no dupes | depends | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Map** | key → value pairs | keys unique | depends | `HashMap`, `LinkedHashMap`, `TreeMap` |

(`Map` is technically not a `Collection`, but it's part of the framework and always taught alongside.)

All of these live in `java.util`, so start files with `import java.util.*;`.

---

## 2. List — an ordered, index-based sequence

The workhorse. Think "a resizable array."

```java
import java.util.*;

List<String> names = new ArrayList<>();   // <String> = holds Strings only
names.add("Prakarsh");
names.add("Aditi");
names.add("Prakarsh");        // duplicates allowed

System.out.println(names.get(0));   // Prakarsh  (index starts at 0)
System.out.println(names.size());   // 3
names.remove("Aditi");
System.out.println(names.contains("Aditi"));  // false

for (String n : names) {            // loop over it
    System.out.println(n);
}
```

**`ArrayList` vs `LinkedList`** (classic question):
- **`ArrayList`** — backed by an array. Fast to *read by index* (`get(i)`). Slower to insert/delete in the middle. **Use this 95% of the time.**
- **`LinkedList`** — nodes linked together. Fast to insert/delete at the ends. Slow to read by index. Rarely needed.

**One-liner:** "ArrayList = fast random access; LinkedList = fast insertion/deletion at ends. I default to ArrayList."

---

## 3. Set — a bag of unique items

No duplicates. Great for "have I seen this already?"

```java
Set<Integer> ids = new HashSet<>();
ids.add(1);
ids.add(2);
ids.add(1);                 // ignored — already there
System.out.println(ids.size());   // 2
```

- **`HashSet`** — fastest, **no order**.
- **`LinkedHashSet`** — keeps **insertion order**.
- **`TreeSet`** — keeps items **sorted**.

**Use case:** removing duplicates from a list → `new HashSet<>(myList)`.

---

## 4. Map — key → value lookups

The most useful structure in real apps. Look something up by a key.

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Prakarsh", 90);
scores.put("Aditi", 85);
scores.put("Prakarsh", 95);        // same key → overwrites → 95

System.out.println(scores.get("Prakarsh"));      // 95
System.out.println(scores.containsKey("Aditi")); // true
System.out.println(scores.getOrDefault("Rahul", 0)); // 0 (safe default)

// iterate
for (Map.Entry<String, Integer> e : scores.entrySet()) {
    System.out.println(e.getKey() + " → " + e.getValue());
}
```

- **`HashMap`** — fastest, no order. **Your default.**
- **`LinkedHashMap`** — keeps insertion order.
- **`TreeMap`** — keeps keys sorted.

**`ArrayList` vs `HashMap`** (the #1 collections interview question):
"A List stores an ordered sequence you access by index; a Map stores key–value pairs you access by key. Use a List for 'a bunch of things in order,' a Map for 'look this up by an id/name.'"

---

## 5. Generics — the `<...>` part

Those angle brackets (`List<String>`) are **generics**. They tell the compiler exactly what type lives inside, so:

1. **Type safety** — you can't accidentally put an `int` into a list of Strings; it won't compile.
2. **No casting** — `names.get(0)` gives you a `String` directly, not a generic `Object` you have to cast.

```java
List<String> a = new ArrayList<>();  // only Strings
a.add("hi");
// a.add(5);   ← compile error, caught early = good

List raw = new ArrayList();          // no generics = the OLD, unsafe way — avoid
```

You can write your own generic method/class too, using a type placeholder `<T>`:

```java
public static <T> T firstOf(List<T> list) {
    return list.get(0);   // works for any type T
}
```

**Interview line:** "Generics give compile-time type safety and remove the need for casting."

---

## 6. `equals()` and `hashCode()` — why collections need them

When you put your own objects in a `HashSet`/`HashMap`, Java decides "are these two objects the same?" using **`equals()`**, and buckets them using **`hashCode()`**. If you don't override them, two objects with identical fields are treated as *different*.

```java
class User {
    String email;
    User(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;
        return this.email.equals(((User) o).email);
    }
    @Override
    public int hashCode() { return email.hashCode(); }
}
```

**The rule:** if you override `equals()`, you MUST override `hashCode()` too, or Sets/Maps misbehave. (In practice, IntelliJ auto-generates both, and records/Lombok do it for you — but *know why*.)

---

## 7. Sorting: Comparable vs Comparator

- **`Comparable`** — the object's *natural* order. Implement `compareTo()` inside the class.
- **`Comparator`** — an *external, custom* order. Pass one to `sort()`.

```java
List<Integer> nums = new ArrayList<>(List.of(3, 1, 2));
Collections.sort(nums);                       // natural order → [1, 2, 3]
nums.sort(Comparator.reverseOrder());         // custom → [3, 2, 1]

// sort users by email
users.sort(Comparator.comparing(u -> u.email));
```

**One-liner:** "Comparable = one natural ordering baked into the class; Comparator = many custom orderings defined outside it."

---

## 8. Interview questions (drill these)

1. Difference between `ArrayList` and `LinkedList`?
2. Difference between a `List`, a `Set`, and a `Map`?
3. `ArrayList` vs `HashMap` — when do you use each?
4. How does a `HashSet` guarantee uniqueness? *(via `hashCode()` + `equals()`)*
5. What are generics and why use them?
6. Why must you override `hashCode()` when you override `equals()`?
7. `Comparable` vs `Comparator`?
8. How do you remove duplicates from a list? *(`new HashSet<>(list)`)*

---

## 9. Try it yourself

Build a mini phone book:

1. Make a `Map<String, String>` for name → phone number.
2. Add 3 contacts. Print all of them with a loop over `entrySet()`.
3. Look up one contact by name and print the number (use `getOrDefault` so a missing name prints `"Not found"`).
4. Make a `List<String>` of names with a couple of duplicates, then print the **unique** names by converting it to a `HashSet`.

Paste your code and I'll review it. Bonus if you also sort the names alphabetically before printing.
