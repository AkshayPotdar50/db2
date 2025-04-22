package com.sprint.three.intro.runnableAndCallable;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 10;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);

        try {
            System.out.println("Result: " + future.get()); // Waits and gets the result
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
