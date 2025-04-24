package com.sprint.three.intro.javaVersions;

// Java14Features.java

public class Java14Features {

    public static void main(String[] args) {

        // 1. Records (Preview in Java 14)
        // Compact syntax for data carrier classes (e.g., DTOs)
        // Requires --enable-preview to compile/run in Java 14
        Person person = new Person("Alice", 30);
        System.out.println("Record: " + person.name() + ", age " + person.age());

        // 2. Pattern Matching for instanceof (Preview in Java 14)
        Object obj = "Pattern matching!";
        if (obj instanceof String s) {
            System.out.println("Length using pattern match: " + s.length());
        }

        // 3. Helpful NullPointerExceptions – Enabled by default in Java 14
        try {
            String s = null;
            s.length(); // This will throw a helpful NPE pointing to the variable 's'
        } catch (NullPointerException e) {
            System.out.println("Helpful NPE: " + e.getMessage());
        }
    }

    // Record declaration (preview feature in Java 14)
    record Person(String name, int age) {}
}
