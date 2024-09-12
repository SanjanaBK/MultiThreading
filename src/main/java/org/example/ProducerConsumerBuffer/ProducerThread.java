package org.example.ProducerConsumerBuffer;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class ProducerThread implements Runnable{
    SharedBuffer buffer;
    public ProducerThread(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(3000);
                buffer.produce(i);
            }
        } catch (Exception e) {

        }
    }

}
