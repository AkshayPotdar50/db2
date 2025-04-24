package com.sprint.three.intro.javaVersions;

// Java21Features.java

public class Java21Features {

    public void main(String[] args) {

        // 1. Sealed Interfaces – Allow interfaces to restrict their implementations
        // A sealed interface restricts the classes that can implement it
        Vehicle vehicle = new Car();
        describeVehicle(vehicle);

        // 2. Pattern Matching for Switch (Preview) – Simplifies switch statement with pattern matching
        // Requires --enable-preview to compile/run in Java 21
        int dayOfWeek = 2;
        String dayType = switch (dayOfWeek) {
            case 1 -> "Weekend";
            case 2 -> "Weekday";
            case 3 -> "Weekday";
            case 4 -> "Weekday";
            case 5 -> "Weekday";
            case 6 -> "Weekend";
            case 7 -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day: " + dayOfWeek);
        };
        System.out.println("Day type: " + dayType);

        // 3. Project Loom (Virtual Threads) Enhancements – Improved lightweight thread management
        var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(() -> System.out.println("Running in a virtual thread (enhanced)!"));

        // 4. Enhanced Foreign Function & Memory API – Further improvements for native access (not demoed here)
        System.out.println("Java 21 enhances pattern matching, virtual threads, and foreign memory API.");
    }

    // Sealed Interface example
    sealed interface Vehicle permits Car, Truck {}

    final class Car implements Vehicle {}

    final class Truck implements Vehicle {}

    // Method for demonstrating Vehicle types
    static void describeVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            System.out.println("It's a Car.");
        } else if (vehicle instanceof Truck) {
            System.out.println("It's a Truck.");
        }
    }
}

