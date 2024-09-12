package org.example;

public class RunnableExample implements Runnable{

    int threadId;

    public RunnableExample (int threadId) {
         this.threadId = threadId;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadId + " threadId " + i);
        }
    }
}
