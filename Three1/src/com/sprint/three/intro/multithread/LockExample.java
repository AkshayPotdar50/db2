package com.sprint.three.intro.multithread;

import java.util.concurrent.locks.ReentrantLock;

class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocalValue.set((int) (Math.random() * 100)); // Assign a thread-specific value
            System.out.println(Thread.currentThread().getName() + " -> " + threadLocalValue.get());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}


class SharedResourceLock {
    private final ReentrantLock lock = new ReentrantLock();

    public void display() {
        lock.lock(); // Acquiring the lock
        try {
            System.out.println(Thread.currentThread().getName() + " is executing.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Always unlock in `finally` block
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        SharedResourceLock resource = new SharedResourceLock();
        Thread t1 = new Thread(resource::display, "Thread-1");
        Thread t2 = new Thread(resource::display, "Thread-2");

        t1.start();
        t2.start();
    }
}

