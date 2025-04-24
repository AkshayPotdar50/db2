package com.sprint.three.intro.javaVersions;

// Java9Features.java
import java.util.*;
import java.util.stream.*;

public class Java9Features {

    // Demonstrates Java 9 features
    public static void main(String[] args) {

        // 1. Factory methods for Collections (Immutable)
        List<String> names = List.of("Alice", "Bob", "Charlie"); // Immutable list
        Set<Integer> numbers = Set.of(1, 2, 3); // Immutable set
        Map<Integer, String> map = Map.of(1, "One", 2, "Two");

        System.out.println("Names: " + names);
        System.out.println("Numbers: " + numbers);
        System.out.println("Map: " + map);


        // 2. Improved Stream API - takeWhile, dropWhile
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 1, 2);
        List<Integer> taken = nums.stream().takeWhile(n -> n < 4).toList();
        List<Integer> dropped = nums.stream().dropWhile(n -> n < 4).toList();

        System.out.println("TakeWhile (<4): " + taken);    // [1, 2, 3]
        System.out.println("DropWhile (<4): " + dropped);  // [4, 5, 1, 2]

        // 3. Optional.ifPresentOrElse
        Optional<String> opt = Optional.of("Java 9");
        opt.ifPresentOrElse(
                val -> System.out.println("Value: " + val),
                () -> System.out.println("Value not present")
        );



        // 4. Private methods in interfaces (demoed via helper method call)
        InterfaceWithPrivateMethod obj = new InterfaceImpl();
        obj.publicMethod();

        // Note: JShell is an interactive REPL and cannot be demoed here
    }
}


// Demonstrating private method in interface
interface InterfaceWithPrivateMethod {
    default void publicMethod() {
        System.out.println("Calling private helper...");
        privateHelper();
    }

    private void privateHelper() {
        System.out.println("This is a private method in interface (Java 9)");
    }
}

class InterfaceImpl implements InterfaceWithPrivateMethod {}
