package hw11;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(() -> {
            synchronized (Thread.currentThread()) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finish thread");
        });

        first.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " сек.");
            first.sleep(1000);
            if (i%5 == 0 && i != 0)
                System.out.println("Прошло 5 секунд");
        }
        synchronized (first) {
            first.notify();
        }
    }
}