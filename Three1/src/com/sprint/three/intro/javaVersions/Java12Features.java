package com.sprint.three.intro.javaVersions;

// Java12Features.java
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Java12Features {

    public static void main(String[] args) {

        // 1. Switch Expressions (Preview in Java 12)
        // Note: Requires --enable-preview at compile/run time in Java 12
        int day = 2;
        String dayType = switch (day) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };
        System.out.println("Day type: " + dayType);

        // 2. String.indent(int n) - Indents each line by n spaces
        String textBlock = "Line1\nLine2\nLine3";
        String indented = textBlock.indent(4);
        System.out.println("Indented text:\n" + indented);

        // 3. Compact Number Formatting (e.g., 1K, 1M)
        NumberFormat shortFormatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        shortFormatter.setMaximumFractionDigits(1);

        System.out.println("Compact format (1234): " + shortFormatter.format(1234)); // 1.2K
        System.out.println("Compact format (1_234_567): " + shortFormatter.format(1_234_567)); // 1.2M

        // 4. Shenandoah GC and Microbenchmark Suite – JVM level; not demoed in code
        System.out.println("Shenandoah GC and Microbenchmark Suite are JVM-level features.");
    }
}

