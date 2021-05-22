package hw11;

public class SecondThread extends Thread{
        @Override
        public void run() {
            for (int i = CommonResource.count; i <= CommonResource.sec/5; i++) {
                synchronized (Thread.currentThread()) {
                    try {
                        sleep(5000);
                        System.out.println("Прошло 5 секунд");
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
}
