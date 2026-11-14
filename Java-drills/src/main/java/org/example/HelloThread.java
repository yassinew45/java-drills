package org.example;

public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread");
    }

    static void main() {
        Thread t = new HelloThread();
        t.start();
    }
}