package hw12;

public class Main {
    public static void main(String[] args) {
        try {
            Thread hydrogen1 = new Thread(() -> {
                try {
                    WatterRelease.releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread hydrogen2 = new Thread(() -> {
                try {
                    WatterRelease.releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread oxygen = new Thread(() -> {
                try {
                    WatterRelease.releaseOxygen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            hydrogen1.setName("H");
            hydrogen2.setName("H");
            oxygen.setName("O");

            hydrogen1.start();
            hydrogen2.start();
            oxygen.start();

            try {
                hydrogen1.join();
                hydrogen2.join();
                oxygen.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

    }

}
