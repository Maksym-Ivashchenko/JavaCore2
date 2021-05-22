package hw11;

public class FirstThread extends Thread{
    @Override
    public void run() {
        for (int i = CommonResource.count; i <= CommonResource.sec; i++) {
            synchronized (Thread.currentThread()) {
                try {
                    sleep(1000);
                    System.out.println(i + " сек.");
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
