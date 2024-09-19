package org.example.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceStamp {
    StampedLock lock = new StampedLock();
    int a = 10;
    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic lock");
           // a = 11;
            Thread.sleep(6000);

                if (lock.validate(stamp)) {
                    System.out.println("value is " + a);
                    //lock.unlockRead(stamp);
                } else {
                    System.out.println("stamp is not valid");
                }


        } catch (Exception e) {

        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("performing work");
            Thread.sleep(7000);
            a = 9;

        } catch (Exception e) {

        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("lock removed");
        }
    }
}
