package lessons;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MySemaphore {
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Hydrogen(new Semaphore(2), "H").start();
            new Oxygen(new Semaphore(1), "O").start();
        }
    }
}


