package com.sprint.three.intro.javaVersions;

// Java16Features.java

public class Java16Features {

    public static void main(String[] args) {

        // 1. Records – Now a standard feature (no preview flag needed)
        User user = new User("Bob", "bob@example.com");
        System.out.println("Record User: " + user.name() + ", " + user.email());

        // 2. Pattern Matching for instanceof – Finalized in Java 16
        Object obj = 123;
        if (obj instanceof Integer i) {
            System.out.println("Squared: " + (i * i));
        }

        // 3. Sealed Classes – 2nd preview, similar to Java 15
        Vehicle vehicle = new Car();
        describeVehicle(vehicle);

        // 4. JDK Internal API Encapsulation (Strong encapsulation of JDK internals)
        System.out.println("JDK internals strongly encapsulated from Java 16 onwards.");
    }

    static void describeVehicle(Vehicle v) {
        if (v instanceof Car) {
            System.out.println("This is a car.");
        } else if (v instanceof Truck) {
            System.out.println("This is a truck.");
        }
    }

    // Record (standard in Java 16)
    record User(String name, String email) {}
}

// Sealed class hierarchy (2nd preview in Java 16)
sealed class Vehicle permits Car, Truck {}

final class Car extends Vehicle {}

final class Truck extends Vehicle {}

