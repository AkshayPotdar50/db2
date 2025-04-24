package com.sprint.three.intro.javaVersions;

// Java17Features.java

public class Java17Features {

    public static void main(String[] args) {

        // 1. Sealed Classes – Now finalized and standard in Java 17
        Animal animal = new Dog();
        describeAnimal(animal);

        // 2. Switch Enhancements – Introduced earlier, now improved
        int code = 2;
        String status = switch (code) {
            case 1 -> "Pending";
            case 2 -> "Approved";
            case 3 -> "Rejected";
            default -> "Unknown";
        };
        System.out.println("Status: " + status);

        // 3. Pattern Matching and Records already finalized in previous versions

        // 4. JEP 356: Enhanced Pseudo-Random Number Generators
        var rng = java.util.random.RandomGeneratorFactory.of("L64X128MixRandom").create();
        System.out.println("Random number using new generator: " + rng.nextInt(100));

        // 5. Removal of RMI Activation, Applet API – not shown in code
        System.out.println("RMI Activation and Applet API are removed in Java 17.");
    }

    static void describeAnimal(Animal a) {
        if (a instanceof Dog) {
            System.out.println("It's a Dog.");
        } else if (a instanceof Cat) {
            System.out.println("It's a Cat.");
        }
    }
}

// Sealed class finalized in Java 17
sealed class Animal permits Dog, Cat {}

final class Dog extends Animal {}

final class Cat extends Animal {}

