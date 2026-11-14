package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CounterDrill {

    public static void main(String[] args) throws InterruptedException {
//        AtomicCounter ac = new AtomicCounter();
        AdderCounter ac = new AdderCounter();
        Runnable task = () -> {
            for(int i=0; i<100_000; i++) {
                ac.increment();
            }
        };

        // create 10 threads and start them
        Thread[] threadList = new Thread[10];
        for(int j=0; j<10; j++) {
            threadList[j] = new Thread(task);
            threadList[j].start();
        }
        for(int j=0; j<10; j++) {
            threadList[j].join();
        }

        System.out.println("Expected 1,000,000, got: " + ac.value());

    }
}

class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);
    public void increment() { c.incrementAndGet(); }
    public void decrement() { c.decrementAndGet(); }
    public int value() { return c.get(); }
}

class AdderCounter {
    private LongAdder a = new LongAdder();
    public void increment() {
        a.increment(); }
    public void decrement() { a.decrement(); }
    public int value() { return a.intValue(); }
}
