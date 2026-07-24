# Java Full-Stack — 1-Month Placement Roadmap

**Your tutor's plan for PRAKARSH** · Goal: interview-ready basics + one solid full-stack project you can talk about confidently.

---

## The honest framing

You don't need to be a Java expert in a month. You need three things:

1. **Fundamentals you can explain out loud** — so in an interview you're never blank ("what is this man?" never happens).
2. **One real full-stack project** you built and understand end to end — this is what 80% of interview questions actually come from.
3. **A short list of "must-answer" interview questions** you've drilled.

We build all three. Depth comes later on the job; AI helps you code, but AI can't sit in your interview for you — *that's* what these fundamentals are for.

---

## Versions we'll use (current as of July 2026)

- **Java 21 (LTS)** — the version most companies and tutorials use. (Latest LTS is Java 25, and Java 26 is out, but 21 has the most learning material and job relevance. Any of 17/21/25 is fine — the *language* is what matters, not the number.)
- **Spring Boot 3.x** — the industry standard right now. (Spring Boot 4.1 is the newest release, but 3.x is what most codebases and interviewers know. What you learn transfers directly.)
- **Tools:** JDK 21, IntelliJ IDEA Community (free), PostgreSQL + pgAdmin (your coaching already uses this), Postman, Git + GitHub.

---

## How each topic works

Every module has the same rhythm — this is the "written notes + teach here" style you picked:

1. I give you a **notes doc** (like this one) you keep and revise from.
2. We **walk through it together** in chat, with examples.
3. You do a **tiny "Try it yourself"** exercise so it sticks.
4. We note the **interview questions** that come from that topic.

You never just read passively. You explain it back to me — that's the test of whether you actually know it.

---

## The 4-week map

### Week 1 — Core Java, made solid
The foundation every interview probes. You're "fairly comfortable" here, so we move fast.

- **Module 0** — Basics recap (variables, loops, arrays, strings, methods). *Cheat-sheet, already written for you.*
- **Module 1** — OOP: classes, objects, the 4 pillars. *The #1 interview topic. Written for you today.*
- **Module 2** — Collections (List, Set, Map) + Generics.
- **Module 3** — Exceptions, and key Java 8 features (Streams, Lambdas, Optional).
- **Module 3b** — Multithreading basics: `Thread` vs `Runnable`, thread lifecycle, `synchronized`, why concurrency matters. *(Common Core Java interview topic — covered to confident-basics level.)*

**End of week:** you can confidently answer "explain OOP with an example," "difference between ArrayList and HashMap," and "how do you create a thread in Java."

### Week 2 — From Java to the backend
Where your coaching lost you. We rebuild it cleanly.

- **Module 4** — SQL essentials + JDBC (how Java talks to a database).
- **Module 5** — Why Spring Boot exists: IoC, Dependency Injection, beans — explained simply.
- **Module 6** — Your first REST API: `@RestController`, GET/POST, running a server, testing in Postman. *(This is Spring MVC in action — the DispatcherServlet request flow behind your coaching's steps 20–22, minus the old manual `web.xml` config.)*

**End of week:** you have a running Spring Boot server that returns data. This is the "aha" moment.

### Week 3 — Real backend + database
The core of a full-stack app.

- **Module 7** — Spring Data JPA / Hibernate: entities, repositories, saving to Postgres without writing SQL.
- **Module 8** — Layered architecture: Controller → Service → Repository (the pattern every company uses).
- **Module 9** — Build **Project part 1**: a working REST backend for a mini social app (users, posts) — aligned with your coaching's Twitter-clone so your screenshots still work.

**End of week:** a real backend with a database behind it. CRUD working.

### Week 4 — Full stack + interview polish
Tie it together and get you interview-ready.

- **Module 10** — The frontend: connecting a simple UI (HTML/JS or Thymeleaf), forms, showing data.
- **Module 11** — Auth basics: signup, login, sessions/cookies (matches your coaching steps 21–24).
- **Module 12** — Finish the **capstone project**: signup → post → feed → follow.
- **Module 13** — Resume (your project + skills, using numbers) and a drilled **interview Q&A sheet**.

**End of week:** one project you built + can explain, a resume line for it, and ~40 interview questions you can answer.

---

## What "done" looks like

By the end you can:
- Explain OOP, collections, and exceptions with your own examples.
- Describe how a request flows: browser → controller → service → repository → database → back.
- Show a GitHub repo of a full-stack app you built.
- Answer the common "tell me about your project" + Java basics questions without freezing.

That is exactly the "I've clearly seen this and can handle it" level you asked for.

---

## How we'll actually run it

- We go **one module at a time.** You tell me "next" when ready; I give the notes + teach it here.
- If a coaching step (9–31) maps to a module, I'll point it out so you can still submit their screenshots/assignments.
- Ask me *anything* mid-module — "wait, what's a bean?" is exactly the kind of question I want.
- Roughly **1 module a day** hits the one-month target with room for the project.

Let's go. Module 0 (recap) and Module 1 (OOP) are ready for you now.
