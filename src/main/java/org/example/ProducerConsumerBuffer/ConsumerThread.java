package org.example.ProducerConsumerBuffer;

public class ConsumerThread implements Runnable{
    SharedBuffer buffer;

    public ConsumerThread(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        System.out.println("Consumer thread: " + Thread.currentThread().getName());
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(10000);
                int item = buffer.consume();
                System.out.println("Consumed item " + item);

            }
        }catch(Exception e) {

        }

    }
}
