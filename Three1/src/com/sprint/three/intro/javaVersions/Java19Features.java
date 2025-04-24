package com.sprint.three.intro.javaVersions;

// Java19Features.java

public class Java19Features {

    public static void main(String[] args) {

        // 1. Record Patterns (Preview) – Simplifies pattern matching for records
        // Requires --enable-preview to compile/run in Java 19
        Person person = new Person("John", 28);
        if (person instanceof Person(var name, var age)) {
            System.out.println("Person's Name: " + name + ", Age: " + age);
        }

        // 2. Virtual Threads (Preview) – Lightweight threads for more scalable programs
        // Virtual threads can be created through Executors
        var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(() -> {
            System.out.println("Running in a virtual thread!");
        });

        // 3. Structured Concurrency (Preview) – Simplifies multi-threading by consolidating task management
       /* try (var service = java.util.concurrent.Executors.newThreadPerTaskExecutor()) {
            service.submit(() -> System.out.println("Task running in structured concurrency"));
        }*/

        // 4. Foreign Function & Memory API (Incubator) – Access to foreign functions and memory (not demoed here)
        System.out.println("Virtual threads and structured concurrency simplify concurrent programming.");
    }

    // Record class used for pattern matching in Java 19
    record Person(String name, int age) {}
}

