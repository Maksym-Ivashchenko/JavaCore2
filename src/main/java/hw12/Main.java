package hw12;

public class Main {
    public static void main(String[] args) {
            String input = "HOOHOHHHHHOOHOHHHH";

            Water h2o = new Water();
            Runnable releaseHydrogen = () -> System.out.print("H");
            Runnable releaseOxygen = () -> System.out.print("O");

            Thread[] threadArray = new Thread[input.length()];
            for (int i = 0; i < threadArray.length; i++) {
                threadArray[i] = input.charAt(i) == 'H' ?
                        new Hydrogen(releaseHydrogen, h2o) :
                        new Oxygen(releaseOxygen, h2o);
            }

        for (Thread thread : threadArray) {
            thread.start();
        }
    }
}
