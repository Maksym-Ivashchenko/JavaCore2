package hw12;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {

    CyclicBarrier barrier = new CyclicBarrier(3, new WaterPlug());
    Semaphore semaphoreH2 = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(1);

    public Water() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH2.acquire();
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        semaphoreH2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        semaphoreO.release();
    }
}
