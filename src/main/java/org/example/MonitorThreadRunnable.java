package org.example;

public class MonitorThreadRunnable implements Runnable {
    MonitorClassSynchronisedExample obj;
    MonitorThreadRunnable(MonitorClassSynchronisedExample obj) {
        this.obj = obj;
    }
    @Override
    public void run() {
        obj.task1();
    }
}
