package org.example;

public class SyncPages {

    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//        Runnable task = () -> {
//            for(int i=0; i < 100_000; i++) {
//                counter.increment();
//            }
//        };

        SynchronizedCounter counter = new SynchronizedCounter();
        Runnable task = () -> {
            for(int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected 200,000, got: " + counter.value());
    }
}

class Counter {
    private int c = 0;
    public void increment() { c++; }
    public void decrement() { c--; }
    public int value() { return c; }
}

class SynchronizedCounter {
    private int c = 0;
    public synchronized void increment() { c++; }
    public synchronized void decrement() { c--; }
    public synchronized int value() { return c; }
}