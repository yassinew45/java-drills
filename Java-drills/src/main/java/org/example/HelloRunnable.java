package org.example;

public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread");
    }

    static void main() {
        Thread t = new Thread(new HelloRunnable());
        t.start();
    }
}