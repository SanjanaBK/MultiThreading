package org.example.ReetrantLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource1 {
    private final ReentrantLock lock;
    private final ReadWriteLock rwlock;
    private boolean itemAvailable = false;
    public SharedResource1(ReentrantLock lock, ReadWriteLock rwlock) {
        this.lock = lock;
        this.rwlock = rwlock;
    }

    public void produce() {
        try {
            //lock.lock();
            rwlock.readLock().lock();
            itemAvailable = true;
            Thread.sleep(4000);
            System.out.println("Item added by " + Thread.currentThread().getName()
                    + " and invoking all threads which are waiting");
            //lock.unlock();
            rwlock.readLock().unlock();
        } catch (Exception e) {

        }

    }
    public void consume() {
        try {

            //lock.lock();
            rwlock.writeLock().lock();
            Thread.sleep(3000);
            itemAvailable =false;
            System.out.println("Item consumed by " + Thread.currentThread().getName()
                    + " and invoking all threads which are waiting");
            //lock.unlock();
            rwlock.writeLock().unlock();
        } catch (Exception e) {

        }

    }
}
