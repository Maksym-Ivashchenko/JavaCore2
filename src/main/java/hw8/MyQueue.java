package hw8;

import java.util.Arrays;

public class MyQueue<T> {
    private Object[] myQueueArray;
    private int size;

    public MyQueue() {
        myQueueArray = new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T value) {
        if (size == myQueueArray.length) {
            Object[] newArray = new Object[myQueueArray.length*2];
            System.arraycopy(myQueueArray, 0, newArray, 0, myQueueArray.length);
            myQueueArray = newArray;
        }
        myQueueArray[size++] = value;
    }

    public void remove(int index) {
        Object[] newArray = new Object[myQueueArray.length-1];
        System.arraycopy(myQueueArray, 0, newArray, 0, index);
        System.arraycopy(myQueueArray, index + 1, newArray, index, myQueueArray.length-1-index);
        myQueueArray = newArray;
        size--;
    }

    public void clear() {
        size = 0;
        myQueueArray = new Object[10];
    }

    public int size() {
        return getSize();
    }

    public T get(int index) {
        return (T) myQueueArray[index];
    }

    public T peek() {
        return (T) myQueueArray[0];
    }

   public T poll() {
       Object[] newArray = new Object[myQueueArray.length-1];
       T firstElement = (T) myQueueArray[0];
       System.arraycopy(myQueueArray, 1, newArray, 0, myQueueArray.length-1);
       myQueueArray = newArray;
       size--;
       return firstElement;

   }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);

        //  myQueue.clear();

        myQueue.add(40);
        myQueue.add(50);
        myQueue.add(60);
        myQueue.add(70);
        myQueue.add(80);
        myQueue.add(90);
        myQueue.add(100);

        myQueue.remove(4);

        System.out.println(Arrays.toString(myQueue.myQueueArray));
        System.out.println(myQueue.getSize());
        System.out.println(myQueue.get(1));
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }

}
