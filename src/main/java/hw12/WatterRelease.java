package hw12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WatterRelease {

    static final int COUNT = 12;

    static final Lock lock = new ReentrantLock();
    static final Condition oxygenWait = lock.newCondition();
    static final Condition hydrogenWait = lock.newCondition();

    static volatile int hydrogenCount = 0;

    public static void releaseHydrogen() throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            lock.lock();
            try {
                while (hydrogenCount == 2) {
                    hydrogenWait.await();
                }

                hydrogenCount++;
                System.out.print(Thread.currentThread().getName());

                if (hydrogenCount == 2) {
                    oxygenWait.signalAll();
                }
            } finally {
                lock.unlock();
            }
            Thread.sleep(500);
        }
    }

    public static void releaseOxygen() throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            lock.lock();
            try {
                while (hydrogenCount < 2) {
                    oxygenWait.await();
                }

                hydrogenCount = 0;
                System.out.print(Thread.currentThread().getName());
                System.out.println("");
                hydrogenWait.signalAll();
            } finally {
                lock.unlock();
            }
            Thread.sleep(500);
        }
    }
}