package org.example.ProducerConsumer;

public class ConsumeTask implements Runnable{
    SharedResource resource;
    ConsumeTask (SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch(Exception e) {
        }
        resource.consumeItem();
    }

}
