package hw12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateWatter extends Thread {
    private static Integer count = 0;
    private static final Lock lock = new ReentrantLock();

    public static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        add();
    }

    public static void main(String[] args) throws InterruptedException {
        int size = 100_000;
        List<CreateWatter> threads = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            CreateWatter th = new CreateWatter();
            th.start();
            threads.add(th);
        }
        for (CreateWatter t : threads) {
            t.join();
        }
        System.out.println(count);
    }
}
/*
 class Ferry {
        private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());
        //Инициализируем барьер на три потока и таском, который будет выполняться, когда
        //у барьера соберется три потока. После этого, они будут освобождены.

        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 9; i++) {
                new Thread(new Car(i)).start();
                Thread.sleep(400);
            }
        }

        //Таск, который будет выполняться при достижении сторонами барьера
        public static class FerryBoat implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Паром переправил автомобили!");
                } catch (InterruptedException e) {
                }
            }
        }

        //Стороны, которые будут достигать барьера
        public static class Car implements Runnable {
            private int carNumber;

            public Car(int carNumber) {
                this.carNumber = carNumber;
            }

            @Override
            public void run() {
                try {
                    System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                    //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                    //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                    BARRIER.await();
                    System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
                } catch (Exception e) {
                }
            }
        }
    }
* */