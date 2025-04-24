package com.sprint.three.intro.javaVersions;

// Java15Features.java

public class Java15Features {

    public static void main(String[] args) {

        // 1. Text Blocks (Standard) – Now fully supported (no preview needed)
        String html = """
            <html>
                <body>
                    <h1>Hello, Java 15!</h1>
                </body>
            </html>
            """;
        System.out.println("Text Block HTML:\n" + html);

        // 2. Sealed Classes (Preview) – Restrict which classes can extend a class
        // Requires --enable-preview in Java 15
        Shape shape = new Circle();
        printShapeType(shape);

        // 3. Hidden Classes – for frameworks, used via MethodHandles (not demoed here)
        System.out.println("Hidden classes used by frameworks, not directly demoable here.");
    }

    static void printShapeType(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("It's a Circle.");
        } else if (shape instanceof Rectangle) {
            System.out.println("It's a Rectangle.");
        }
    }
}

// Sealed class example (preview feature in Java 15)
sealed class Shape permits Circle, Rectangle {}

final class Circle extends Shape {}

final class Rectangle extends Shape {}

