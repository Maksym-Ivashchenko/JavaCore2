package lessons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MySemaphore {
    private CyclicBarrier cyclicBarrier;
    private Semaphore hydrogen;
    private Semaphore oxygen;
    public MySemaphore() {
               this.cyclicBarrier = new CyclicBarrier(3);
               this.hydrogen = new Semaphore(2);
               this.oxygen = new Semaphore(1);
           }
            public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
               hydrogen.acquire();
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
                try {
                        cyclicBarrier.await();
                        hydrogen.release();
                    } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                    }
            }

            public void oxygen(Runnable releaseOxygen) throws InterruptedException {
                oxygen.acquire();
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();
                try {
                        cyclicBarrier.await();
                        oxygen.release();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
            }

    public static void main(String[] args) throws InterruptedException {
        MySemaphore mySemaphore = new MySemaphore();
    }
}


