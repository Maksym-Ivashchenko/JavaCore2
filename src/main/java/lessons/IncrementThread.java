package lessons;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

class IncrementThread implements Runnable {
    private final String name;
    private final Semaphore semaphore;

    public IncrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Thread " + name + " waiting for permission");
        semaphore.acquire();
        System.out.println("Thread " + name + " got permission");
        for (int i = 0; i < 10; i++) {
            CommonResource.count++;
            System.out.println("Thread " + name + " : " + CommonResource.count);
            Thread.sleep(100);
        }
        System.out.println("Thread " + name + " finished job");
        semaphore.release();
    }
}
