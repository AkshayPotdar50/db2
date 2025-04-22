package com.sprint.three.intro.multithread;

class SharedResource {
    public synchronized void display() {
        System.out.println(Thread.currentThread().getName() + " is executing.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread t1 = new Thread(resource::display, "Thread-1");
        Thread t2 = new Thread(resource::display, "Thread-2");

        t1.start();
        t2.start();
    }
}
