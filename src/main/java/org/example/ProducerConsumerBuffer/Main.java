package org.example.ProducerConsumerBuffer;

public class Main {

    public static void main(String args[]) {
        SharedBuffer buffer = new SharedBuffer(3);
        ProducerThread producerThread = new ProducerThread(buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();

    }
}
