package org.example.ProducerConsumerBuffer;

import java.util.ArrayDeque;

public class SharedBuffer {
    private ArrayDeque<Integer> buffer;
    private int bufferSize;

    public SharedBuffer(int bufferSize) {
        buffer = new ArrayDeque<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        while (buffer.size() == bufferSize) {
            System.out.println("Buffer is full, producer is waiting for consumer.");
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int consume() throws Exception {
        while(buffer.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting for producer.");
            wait();
        }
        int item = buffer.removeFirst();
        notify();
        return item;
    }
}
