package com.sprint.three.intro.runnableAndCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable task executed");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(task); // No return value
        executor.shutdown();
    }
}
