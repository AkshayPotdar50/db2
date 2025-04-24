package com.sprint.three.intro.javaVersions;

// Java13Features.java
public class Java13Features {

    public static void main(String[] args) {

        // 1. Text Blocks (Preview in Java 13) - Multi-line strings using triple quotes
        // Note: Requires --enable-preview in Java 13 for compilation
        String json = """
            {
                "name": "Java",
                "version": 13
            }
            """;

        System.out.println("Text Block JSON:\n" + json);

        // 2. Switch Expressions (2nd Preview) – same as Java 12, improved clarity
        int num = 3;
        String result = switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> {
                System.out.println("Inside case 3 block");
                yield "Three";
            }
            default -> "Other";
        };
        System.out.println("Switch result: " + result);

        // Note: Preview features require --enable-preview when compiling and running in Java 13.
    }
}

