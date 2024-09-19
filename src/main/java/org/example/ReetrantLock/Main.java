package org.example.ReetrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String args[]) {
        ReentrantLock lock = new ReentrantLock();
        ReadWriteLock rwlock = new ReentrantReadWriteLock();
        SharedResource1 r1 = new SharedResource1(lock, rwlock);
        SharedResource1 r2 = new SharedResource1(lock, rwlock);
        SharedResource1 r3 = new SharedResource1(lock, rwlock);
        SharedResource1 r4 = new SharedResource1(lock, rwlock);
        Thread th1 = new Thread(() -> {
            r1.produce();
        });
        Thread th2 = new Thread(() -> {
            r2.produce();
        });
        Thread th3 = new Thread(() -> {
            r3.consume();
        });
        Thread th4 = new Thread(() -> {
            r4.consume();
        });
        th1.start();
        th3.start();
        th2.start();
        th4.start();
    }
}
