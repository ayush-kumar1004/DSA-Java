# Java Methods Cheat Sheet — Common Classes & Functions

Your one-stop reference so you never have to google "how to do X in Java" for the basics. Keep this open while you code. Every method has a signature, what it does, and a quick example.

Import shortcut for most of these: `import java.util.*;`

---

## 1. String

Strings are **immutable** — every "changing" method returns a *new* String; it doesn't modify the original.

| Method | Does | Example → result |
|--------|------|------------------|
| `length()` | number of characters | `"hello".length()` → `5` |
| `charAt(i)` | char at index i | `"hello".charAt(1)` → `'e'` |
| `substring(a)` | from index a to end | `"hello".substring(2)` → `"llo"` |
| `substring(a, b)` | index a to b-1 | `"hello".substring(1,4)` → `"ell"` |
| `indexOf(s)` | first index of s, or -1 | `"hello".indexOf("l")` → `2` |
| `lastIndexOf(s)` | last index of s | `"hello".lastIndexOf("l")` → `3` |
| `contains(s)` | is s inside? | `"hello".contains("ell")` → `true` |
| `startsWith(s)` / `endsWith(s)` | prefix/suffix check | `"hello".startsWith("he")` → `true` |
| `equals(s)` | same text? (**use this, not `==`**) | `"a".equals("a")` → `true` |
| `equalsIgnoreCase(s)` | same ignoring case | `"Hi".equalsIgnoreCase("hi")` → `true` |
| `toUpperCase()` / `toLowerCase()` | change case | `"Hi".toUpperCase()` → `"HI"` |
| `trim()` | remove leading/trailing spaces | `"  hi  ".trim()` → `"hi"` |
| `strip()` | like trim, Unicode-aware | `" hi ".strip()` → `"hi"` |
| `replace(a, b)` | replace all a with b | `"aaa".replace("a","b")` → `"bbb"` |
| `split(regex)` | break into array | `"a,b,c".split(",")` → `["a","b","c"]` |
| `toCharArray()` | to char[] | `"hi".toCharArray()` → `['h','i']` |
| `isEmpty()` | length == 0? | `"".isEmpty()` → `true` |
| `isBlank()` | empty or only spaces? | `"  ".isBlank()` → `true` |
| `String.valueOf(x)` | any type → String | `String.valueOf(42)` → `"42"` |
| `String.format(...)` | formatted string | `String.format("%d-%s", 5, "x")` → `"5-x"` |
| `repeat(n)` | repeat n times | `"ab".repeat(2)` → `"abab"` |
| `+` operator | concatenate | `"a" + "b"` → `"ab"` |

---

## 2. StringBuilder (for building strings in loops)

When you build a string piece by piece (especially in a loop), use `StringBuilder` — it's **mutable** and far faster than `+`.

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ").append("World");
sb.insert(0, ">> ");
sb.reverse();
String result = sb.toString();
```

| Method | Does |
|--------|------|
| `append(x)` | add to the end |
| `insert(i, x)` | insert at index i |
| `delete(a, b)` | remove chars a..b-1 |
| `deleteCharAt(i)` | remove one char |
| `replace(a, b, str)` | replace range |
| `reverse()` | reverse the whole thing |
| `charAt(i)` / `setCharAt(i, c)` | get/set a char |
| `length()` | current length |
| `toString()` | convert to a String |

---

## 3. ArrayList / List `<E>`

```java
List<String> list = new ArrayList<>();
```

| Method | Does | Example |
|--------|------|---------|
| `add(x)` | append to end | `list.add("a")` |
| `add(i, x)` | insert at index i | `list.add(0, "x")` |
| `get(i)` | element at index i | `list.get(0)` |
| `set(i, x)` | replace element at i | `list.set(1, "b")` |
| `remove(i)` | remove by **index** | `list.remove(0)` |
| `remove(obj)` | remove by **value** | `list.remove("a")` |
| `size()` | number of elements | `list.size()` |
| `isEmpty()` | is it empty? | `list.isEmpty()` |
| `contains(x)` | does it hold x? | `list.contains("a")` |
| `indexOf(x)` | first index of x, or -1 | `list.indexOf("a")` |
| `clear()` | remove everything | `list.clear()` |
| `set/get` | update/read | see above |
| `addAll(coll)` | add all from another | `list.addAll(other)` |
| `sort(comparator)` | sort in place | `list.sort(Comparator.naturalOrder())` |
| `forEach(action)` | do something to each | `list.forEach(System.out::println)` |
| `toArray()` | to an array | `list.toArray(new String[0])` |
| `List.of(...)` | quick **immutable** list | `List.of("a","b")` |

**Careful:** `remove(int)` removes by index, `remove(Object)` removes by value. For a `List<Integer>`, `list.remove(2)` removes index 2, not the value 2 — use `list.remove(Integer.valueOf(2))` for the value.

---

## 4. HashMap / Map `<K, V>`

```java
Map<String, Integer> map = new HashMap<>();
```

| Method | Does | Example |
|--------|------|---------|
| `put(k, v)` | add/overwrite pair | `map.put("a", 1)` |
| `get(k)` | value for key (null if absent) | `map.get("a")` → `1` |
| `getOrDefault(k, d)` | value, or default d | `map.getOrDefault("x", 0)` → `0` |
| `containsKey(k)` | has this key? | `map.containsKey("a")` |
| `containsValue(v)` | has this value? | `map.containsValue(1)` |
| `remove(k)` | delete a key | `map.remove("a")` |
| `size()` | number of pairs | `map.size()` |
| `isEmpty()` | empty? | `map.isEmpty()` |
| `keySet()` | all keys (a Set) | `for (String k : map.keySet())` |
| `values()` | all values | `for (int v : map.values())` |
| `entrySet()` | all key-value pairs | see below |
| `putIfAbsent(k, v)` | put only if key missing | `map.putIfAbsent("a", 9)` |
| `merge(k, v, fn)` | combine with existing | `map.merge("a", 1, Integer::sum)` (great for counting) |
| `forEach((k,v)->...)` | loop over pairs | `map.forEach((k,v)-> ...)` |

**Iterating a map:**

```java
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}
```

**Counting pattern (very common):**

```java
map.put(word, map.getOrDefault(word, 0) + 1);
// or
map.merge(word, 1, Integer::sum);
```

---

## 5. HashSet / Set `<E>`

```java
Set<String> set = new HashSet<>();
```

| Method | Does |
|--------|------|
| `add(x)` | add (ignored if already present) |
| `remove(x)` | remove x |
| `contains(x)` | is x present? |
| `size()` | count |
| `isEmpty()` | empty? |
| `clear()` | empty it |
| `addAll(coll)` | union with another |
| `retainAll(coll)` | keep only common (intersection) |
| `removeAll(coll)` | remove those in coll (difference) |
| `Set.of(...)` | quick immutable set |

**Remove duplicates from a list:** `new HashSet<>(myList)` or `myList.stream().distinct().toList()`.

---

## 6. Arrays (`java.util.Arrays`)

Utility methods for plain arrays. `import java.util.Arrays;`

| Method | Does | Example |
|--------|------|---------|
| `Arrays.toString(arr)` | print an array nicely | `Arrays.toString(new int[]{1,2})` → `"[1, 2]"` |
| `Arrays.sort(arr)` | sort ascending | `Arrays.sort(arr)` |
| `Arrays.fill(arr, x)` | set every element to x | `Arrays.fill(arr, 0)` |
| `Arrays.copyOf(arr, n)` | copy, new length n | `Arrays.copyOf(arr, 5)` |
| `Arrays.copyOfRange(arr,a,b)` | copy a slice | |
| `Arrays.equals(a, b)` | same contents? | |
| `Arrays.asList(arr)` | array → List | `Arrays.asList("a","b")` |
| `Arrays.stream(arr)` | array → Stream | `Arrays.stream(arr).sum()` |
| `Arrays.binarySearch(arr,x)` | index of x (must be sorted) | |

`arr.length` — the size of an array (a **field**, no `()`, unlike `list.size()`).

---

## 7. Collections (`java.util.Collections`)

Utility methods for Lists/Sets. `import java.util.Collections;`

| Method | Does |
|--------|------|
| `Collections.sort(list)` | sort ascending |
| `Collections.sort(list, cmp)` | sort with comparator |
| `Collections.reverse(list)` | reverse order |
| `Collections.max(list)` / `min(list)` | largest / smallest |
| `Collections.shuffle(list)` | random order |
| `Collections.frequency(list, x)` | count occurrences of x |
| `Collections.emptyList()` | an empty list |
| `Collections.unmodifiableList(list)` | read-only view |

---

## 8. Math (`java.lang.Math` — no import needed)

| Method | Does | Example |
|--------|------|---------|
| `Math.max(a, b)` / `Math.min(a, b)` | larger / smaller | `Math.max(3, 7)` → `7` |
| `Math.abs(x)` | absolute value | `Math.abs(-5)` → `5` |
| `Math.pow(a, b)` | a to the power b | `Math.pow(2, 3)` → `8.0` |
| `Math.sqrt(x)` | square root | `Math.sqrt(16)` → `4.0` |
| `Math.round(x)` | nearest whole | `Math.round(2.6)` → `3` |
| `Math.ceil(x)` / `Math.floor(x)` | round up / down | `Math.ceil(2.1)` → `3.0` |
| `Math.random()` | random 0.0–1.0 | `(int)(Math.random()*6)+1` → dice |
| `Math.PI` | π constant | `3.14159...` |

For random numbers you can also use `Random`: `new Random().nextInt(100)` → 0–99.

---

## 9. Wrapper classes & parsing (Integer, Double, etc.)

Converting between Strings and numbers — you'll do this constantly with user input.

| Method | Does | Example |
|--------|------|---------|
| `Integer.parseInt(s)` | String → int | `Integer.parseInt("42")` → `42` |
| `Double.parseDouble(s)` | String → double | `Double.parseDouble("3.14")` |
| `Long.parseLong(s)` | String → long | |
| `Boolean.parseBoolean(s)` | String → boolean | |
| `String.valueOf(x)` | number → String | `String.valueOf(42)` → `"42"` |
| `Integer.valueOf(s)` | String → Integer object | |
| `Integer.MAX_VALUE` / `MIN_VALUE` | int limits | `2147483647` |
| `Integer.toBinaryString(n)` | int → binary text | `Integer.toBinaryString(5)` → `"101"` |

**Autoboxing:** Java auto-converts `int` ↔ `Integer`, so `list.add(5)` into a `List<Integer>` just works.

---

## 10. Character (`java.lang.Character`)

Handy for string/char problems (very common in coding rounds).

| Method | Does |
|--------|------|
| `Character.isDigit(c)` | is it 0–9? |
| `Character.isLetter(c)` | is it a–z/A–Z? |
| `Character.isLetterOrDigit(c)` | alphanumeric? |
| `Character.isWhitespace(c)` | space/tab/newline? |
| `Character.isUpperCase(c)` / `isLowerCase(c)` | case check |
| `Character.toUpperCase(c)` / `toLowerCase(c)` | change case |
| `Character.getNumericValue(c)` | `'7'` → `7` |

---

## 11. Scanner — reading input (`java.util.Scanner`)

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);

int n      = sc.nextInt();       // read an int
double d   = sc.nextDouble();    // read a double
String w   = sc.next();          // read one word
sc.nextLine();                   // consume leftover newline (common gotcha!)
String line = sc.nextLine();     // read a whole line
boolean b  = sc.nextBoolean();
sc.close();
```

**Gotcha:** after `nextInt()`/`nextDouble()`, call an extra `sc.nextLine()` before reading a full line, or it reads an empty string.

---

## 12. Iterator (looping with safe removal)

Usually you use a for-each loop, but to **remove while looping** you need an Iterator:

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String s = it.next();
    if (s.equals("x")) it.remove();   // safe removal
}
```

---

## 13. Stream quick reference (from Module 3)

```java
list.stream()
    .filter(x -> x > 2)          // keep matching
    .map(x -> x * 2)             // transform each
    .sorted()                    // sort
    .distinct()                  // remove duplicates
    .limit(5)                    // take first 5
    .collect(Collectors.toList());   // gather to list

list.stream().count();                       // how many
list.stream().anyMatch(x -> x > 5);          // any match? → boolean
list.stream().allMatch(x -> x > 0);          // all match?
list.stream().mapToInt(Integer::intValue).sum();   // sum
list.stream().max(Comparator.naturalOrder()); // → Optional
```

---

## Quick "which do I use?" recap

- Text you build in a loop → **StringBuilder**
- Ordered list of things → **ArrayList**
- Look something up by key → **HashMap**
- Unique items only → **HashSet**
- Array helpers → **Arrays.xxx**
- List/Set helpers → **Collections.xxx**
- Math → **Math.xxx**
- Text ↔ number → **Integer.parseInt / String.valueOf**
- Read input → **Scanner**

Whenever you hit a method you don't recognize while coding, drop it here and I'll explain it — but 90% of what you'll need for interviews and your project is on this page.
