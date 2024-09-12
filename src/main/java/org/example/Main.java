package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void threadExample() {
        //general multithreading example
        ThreadExample th1 = new ThreadExample();
        ThreadExample th2 = new ThreadExample();
        th1.start();
        th2.start();

        // this will be run sequentially
        //th1.run();
        //th2.run();
    }
    public static void runnableExample() {
        RunnableExample re = new RunnableExample(1);
        RunnableExample re2 = new RunnableExample(2);
        Thread thread1 = new Thread(re);
        Thread thread2 = new Thread(re2);
        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.join();
            System.out.println(" join ");
            System.out.println(thread2.isAlive());
        } catch (InterruptedException e) {

        }
    }
    public static void monitorLockExample() {
        MonitorClassSynchronisedExample example = new MonitorClassSynchronisedExample();
        // if th1 acquires monitor lock, th2 has to wait for th1 to release lock before it can acquire it
        Thread th1 = new Thread(example::task1);
        Thread th2 = new Thread(example::task2);
        Thread th3 = new Thread(example::task3);
        th1.start();
        th2.start();
        th3.start();

        // using runnable obj
        MonitorThreadRunnable runnable = new MonitorThreadRunnable(example);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }
    public static void main(String[] args) {
        //threadExample();
        //runnableExample();
        monitorLockExample();
    }
}