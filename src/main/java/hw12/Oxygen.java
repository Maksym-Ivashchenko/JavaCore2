package hw12;

public class Oxygen extends Thread {
    Water h2o;
    Runnable releaseOxygen;
    Oxygen(Runnable releaseOxygen, Water h2o) {
        super( "Oxygen");
        this.releaseOxygen = releaseOxygen;
        this.h2o = h2o;
    }

    @Override
    public void run() {
        try {
            h2o.oxygen(releaseOxygen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
