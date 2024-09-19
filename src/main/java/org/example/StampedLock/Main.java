package org.example.StampedLock;


public class Main {
    public static void main(String args[]) {
        SharedResourceStamp resource = new SharedResourceStamp();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });
        Thread th2 = new Thread( () -> {
           resource.consumer();
        });

        th1.start();
        th2.start();
    }
}
