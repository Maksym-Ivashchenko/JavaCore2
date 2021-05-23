package lessons;

import java.util.concurrent.Semaphore;

public class MySemaphore {

    //public static void main(String[] args) {
    // Semaphore semaphore = new Semaphore(1);
    // new Thread(new IncrementThread("H", semaphore)).start();
    // new Thread(new DecrementThread("O", semaphore)).start();
    //}

}
class Program {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Hidrogen(new Semaphore(2)).start();
            new Oxigen(new Semaphore(1)).start();
        }
    }
}
// класс философа

