package com.sprint.three.intro.javaVersions;

// Java20Features.java

public class Java20Features {

    public static void main(String[] args) {

        // 1. Record Patterns – Now finalized (Record patterns make working with records easier)
        Person person = new Person("Alice", 30);
        if (person instanceof Person(var name, var age)) {
            System.out.println("Person: Name = " + name + ", Age = " + age);
        }

        // 2. Scoped Values (Preview) – Used to safely manage local variables and memory across threads
        // Scoped Values are still in preview mode, so requires --enable-preview to compile/run in Java 20
        /*try (var scopedValue = ScopedValue.of("Scoped Value Example")) {
            System.out.println("Scoped Value: " + scopedValue);
        }*/

        // 3. Virtual Threads (Finalized) – Lightweight threads for efficient concurrency
        var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(() -> System.out.println("Running in a virtual thread (finalized)!"));

        // 4. Foreign Function & Memory API (Incubator) – Enables access to native memory and functions (not demoed here)
        System.out.println("Java 20 finalizes virtual threads and record patterns, with scoped values in preview.");
    }

    // Record class for pattern matching
    record Person(String name, int age) {}
}

