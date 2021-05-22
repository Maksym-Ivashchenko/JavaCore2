package hw11;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        FirstThread first = new FirstThread();
        SecondThread second = new SecondThread();

        first.start();
        second.start();

        synchronized (first) {first.notify();}
        synchronized (second) {second.notify();}

    }
}