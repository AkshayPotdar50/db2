package com.sprint.three.intro;

// Exception Handling Demo
public class ExceptionHandlingDemo {

    // Method that throws an exception
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b; // Might throw ArithmeticException if b == 0
    }

    public static void main(String[] args) {
        try {
            // Attempting division by zero
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling the exception
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Finally block always executes
            System.out.println("Execution completed, finally block executed.");
        }

        System.out.println("Program continues after exception handling.");
    }
}
