package hw12;

public class Hydrogen extends Thread {
    Water h2o;
    Runnable releaseHydrogen;
    Hydrogen(Runnable releaseHydrogen, Water h2o) {
        super( "Hydrogen");
        this.releaseHydrogen = releaseHydrogen;
        this.h2o = h2o;
    }

    @Override
    public void run() {
        try {
            h2o.hydrogen(releaseHydrogen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
