package hw12;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WatterRelease {
/*
    static Lock lock = new ReentrantLock(true);
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        try {
            Thread h1 = new Thread(() -> {
                try {
                    hydrogenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread h2 = new Thread(() -> {
                try {
                    hydrogenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread o = new Thread(() -> {
                try {
                    oxygenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            h1.start();
            h2.start();
            o.start();

            try {
                h1.join();
                h2.join();
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

    }

    public static void hydrogenProducer() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("h");
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public static void oxygenProducer() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("o");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }*/
// The semaphore ensures that the H2/0 thread executes the wait state, that is, only 2 H threads and 1 O thread can execute each time
private final Semaphore h2 = new Semaphore(2, false);
    private final Semaphore o = new Semaphore(1, false);

    // Barrier to ensure that threads are executed in groups of three or three
    private final CyclicBarrier barrier = new CyclicBarrier(3);

    public WatterRelease() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h2.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            throw new InterruptedException(e.getMessage());
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        h2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            throw new InterruptedException(e.getMessage());
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        o.release();
    }
}
