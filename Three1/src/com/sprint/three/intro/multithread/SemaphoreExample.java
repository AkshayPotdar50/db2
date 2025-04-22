package com.sprint.three.intro.multithread;

import java.util.concurrent.Semaphore;

class SharedResource1{
    private Semaphore semaphore = new Semaphore(2); // Only 2 threads can access

    public void accessResource(String threadName) {
        try {
            System.out.println(threadName + " trying to acquire...");
            semaphore.acquire(); // Acquire permit
            System.out.println(threadName + " acquired! Working...");
            Thread.sleep(2000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " releasing...");
            semaphore.release(); // Release permit
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource1 resource = new SharedResource1();

        Runnable worker = () -> {
            String threadName = Thread.currentThread().getName();
            resource.accessResource(threadName);
        };

        for (int i = 1; i <= 5; i++) {
            new Thread(worker, "Thread-" + i).start();
        }
    }
}

