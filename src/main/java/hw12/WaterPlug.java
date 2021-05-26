package hw12;

public class WaterPlug implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println();
        } catch (InterruptedException e) {
        }
    }
}
