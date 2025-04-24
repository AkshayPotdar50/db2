package com.sprint.three.intro.javaVersions;

// Java10Features.java
import java.util.*;

public class Java10Features {

    public static void main(String[] args) {

        // 1. Local Variable Type Inference using 'var'
        var message = "Hello from Java 10"; // Compiler infers String
        var number = 42; // Compiler infers int
        var list = List.of("A", "B", "C"); // Compiler infers List<String>

        System.out.println(message);
        System.out.println("Number: " + number);
        System.out.println("List: " + list);

        // 2. Copy of Collections - Creates a shallow copy (also unmodifiable)
        var copyList = List.copyOf(list); // Throws exception if list has nulls
        System.out.println("Copy of List: " + copyList);

        // 3. Application Class-Data Sharing (AppCDS)
        // This is a JVM optimization and cannot be demonstrated directly in code.
        System.out.println("AppCDS helps reduce startup time by sharing class metadata (not shown in code).");
    }
}
