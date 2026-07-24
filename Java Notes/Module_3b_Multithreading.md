# Module 3b — Multithreading (Basics)

Multithreading = doing several things at once. It's a favourite Core Java interview topic because it separates "memorized syntax" from "actually understands how Java runs." You need confident basics: how to make a thread, the lifecycle, and why `synchronized` exists. We don't go into deep concurrency theory — just enough that you're never blank.

---

## 1. Process vs thread

- A **process** is a running program (your whole app). It has its own memory.
- A **thread** is a single path of execution *inside* a process. One process can run **many threads at once**, sharing the same memory.

Why bother? Responsiveness and speed — e.g. a web server handling many users at the same time, each on its own thread. (Spring Boot does this for you: each incoming request runs on its own thread.)

The program always starts with one thread: the **main thread** (that's what runs your `main` method).

---

## 2. Two ways to create a thread

**Way A — implement `Runnable` (preferred).**

```java
class Task implements Runnable {
    public void run() {                     // the work the thread does
        System.out.println("Running on: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Task());
        t.start();     // starts a NEW thread → calls run()
    }
}
```

**Way B — extend `Thread`.**

```java
class MyThread extends Thread {
    public void run() { System.out.println("hi from thread"); }
}
new MyThread().start();
```

**Prefer `Runnable`** because your class stays free to extend something else (Java allows only one `extends`), and it separates the *task* from the *thread*. **Interview line:** "I prefer implementing Runnable over extending Thread because it doesn't use up my single inheritance slot and separates the task from the execution mechanism."

Modern short form with a lambda (since `Runnable` is a functional interface):

```java
Thread t = new Thread(() -> System.out.println("quick thread"));
t.start();
```

---

## 3. `start()` vs `run()` — the classic trap

- **`start()`** — creates a new thread and runs `run()` *on that new thread*. ✅
- **`run()`** — if you call it directly, it just runs like a normal method **on the current thread** — no new thread at all. ❌

Interviewers love this. Always call `start()`.

---

## 4. Thread lifecycle (the states)

```
NEW → RUNNABLE → RUNNING → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED
```

- **NEW** — created but not started.
- **RUNNABLE** — ready to run, waiting for CPU.
- **RUNNING** — actively executing.
- **BLOCKED / WAITING** — paused (waiting for a lock, or `sleep()`, or `join()`).
- **TERMINATED** — finished.

---

## 5. Useful methods

```java
Thread.sleep(1000);   // pause current thread for 1000 ms (throws InterruptedException)
t.join();             // wait for thread t to finish before continuing
t.setName("worker");
t.getName();
Thread.currentThread();  // reference to the thread running right now
```

`join()` example — make main wait for a worker:

```java
Thread t = new Thread(() -> System.out.println("done work"));
t.start();
t.join();                 // main pauses here until t finishes
System.out.println("main continues after worker");
```

---

## 6. The core problem: shared data & race conditions

When multiple threads change the **same** variable at once, they can step on each other. This is a **race condition**.

```java
class Counter {
    int count = 0;
    void increment() { count++; }   // NOT atomic: read, add, write
}
```

If 1000 threads call `increment()`, you might end up with *less* than 1000 — two threads read the same value and both write it back, losing an update.

**Fix: `synchronized`** — lets only one thread into the method/block at a time.

```java
class Counter {
    private int count = 0;
    synchronized void increment() { count++; }   // now thread-safe
}
```

`synchronized` puts a **lock** on the object; a second thread must wait until the first leaves. **One-liner:** "A race condition happens when threads access shared mutable data concurrently; I use `synchronized` (or atomic classes) to ensure only one thread modifies it at a time."

You can also synchronize a block:

```java
synchronized (this) { count++; }
```

---

## 7. Two terms to recognize (don't need depth)

- **Deadlock** — thread A holds lock 1 and waits for lock 2, while thread B holds lock 2 and waits for lock 1. Both stuck forever. Avoid by acquiring locks in a consistent order.
- **`volatile`** — marks a variable so every thread reads the latest value from main memory (visibility), not a cached copy. Good to *name*; not needed in depth.

---

## 8. The modern way: ExecutorService (good to mention)

In real apps you rarely create raw `Thread` objects — you use a **thread pool** via `ExecutorService`, which reuses threads efficiently.

```java
import java.util.concurrent.*;

ExecutorService pool = Executors.newFixedThreadPool(3);
pool.submit(() -> System.out.println("task 1"));
pool.submit(() -> System.out.println("task 2"));
pool.shutdown();
```

Just knowing "you use a thread pool / ExecutorService instead of making threads by hand" is enough to sound informed.

---

## 9. Interview questions (drill these)

1. Difference between a process and a thread?
2. Two ways to create a thread — which is better and why?
3. Difference between `start()` and `run()`?
4. What is a race condition? How do you prevent it?
5. What does the `synchronized` keyword do?
6. What is a deadlock?
7. What does `join()` do?
8. What is a thread pool / `ExecutorService`?

---

## 10. Try it yourself

1. Create two threads (using `Runnable` or lambdas). Thread 1 prints numbers 1–5, thread 2 prints letters A–E. Start both and observe that the output interleaves (order isn't guaranteed).
2. Make a shared `Counter` with an `increment()` method. Start 2 threads that each call it 1000 times. Print the final count **without** `synchronized`, then add `synchronized` and compare. See the race condition disappear.
3. Use `join()` so `main` prints `"all done"` only after both threads finish.

Paste your code and I'll walk through it — this is one where *seeing* the race condition happen teaches more than any explanation.

---

**That's all of Week 1.** Once you've gone through Modules 0, 1, 2, 3, and 3b, you've got the entire Core Java foundation interviews probe. Week 2 is where it gets exciting — your first real backend server.
