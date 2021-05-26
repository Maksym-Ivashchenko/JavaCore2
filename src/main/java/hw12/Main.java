package hw12;

public class Main {
    public static void main(String[] args) {
        WatterRelease watterRelease = new WatterRelease();
        try {
            Thread hydrogen1 = new Thread(() -> {
                try {
                    watterRelease.hydrogen(new Hydrogen("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread hydrogen2 = new Thread(() -> {
                try {
                    watterRelease.hydrogen(new Hydrogen("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread oxygen = new Thread(() -> {
                try {
                    watterRelease.oxygen(new Oxygen("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //hydrogen1.setName("H");
            //hydrogen2.setName("H");
            //oxygen.setName("O");
            for (int i = 0; i < 5; i++) {
                hydrogen1.start();
                hydrogen2.start();
                oxygen.start();
            }



        } catch (Exception e) {
        }

    }

}
