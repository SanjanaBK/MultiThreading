package org.example;

public class MonitorClassSynchronisedExample {
    public synchronized void task1() {
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("task1 done");
        } catch (Exception e) {

        }
    }
    public void task2 () {
        System.out.println("task2 before synchronised");
        synchronized (this) {
            System.out.println("inside synchronised");
        }
    }
    public void task3() {
        System.out.println("task3");
    }
}
