package org.example.ProducerConsumer;

public class Main {
    public static void main(String args[]) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new ProduceTask(resource));
        Thread consumerThread = new Thread(new ConsumeTask(resource));
        consumerThread.start();
        producerThread.start();
    }
}
