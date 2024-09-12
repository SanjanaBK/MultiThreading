package org.example.ProducerConsumer;

public class SharedResource {
    boolean itemAvailable = false;
    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName()
            + " and invoking all threads which are waiting");
        notifyAll();
    }

    /*
    what if notify is called before wait() then consumer thread keeps on looping unnecessarily
    public synchronized void consumeItem() {
        System.out.println("Consume method invoked" + Thread.currentThread().getName());
        try {
            wait(); //  it releases the monitor lock
        } catch (Exception e) {

        }
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    } */

    public synchronized void consumeItem() {
        System.out.println("Consume method invoked" + Thread.currentThread().getName());
        while (!itemAvailable) {
            try {
                wait(); //  it releases the monitor lock
            } catch (Exception e) {

            }
        }
        System.out.println("Item ocnsumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}
