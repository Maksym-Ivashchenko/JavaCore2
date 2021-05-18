package hw8;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] myArray;
    private int size;

    public MyArrayList() {
        myArray = new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(T value) {
        if (size == myArray.length) {
            Object[] newArray = new Object[myArray.length*2];
            System.arraycopy(myArray, 0, newArray, 0, myArray.length);
            myArray = newArray;
        }
        myArray[size++] = value;
    }

    @Override
    public void remove(int index){
        Object[] newArray = new Object[myArray.length-1];
        System.arraycopy(myArray, 0, newArray, 0, index);
        System.arraycopy(myArray, index + 1, newArray, index, myArray.length - 1-index);
        myArray = newArray;
        size--;
   }

    @Override
    public void clear() {
        size = 0;
        myArray = new Object[10];
    }

    @Override
    public int size(){
        return getSize();
    }

    @Override
   public T get(int index) {
        return (T) myArray[index];
   }

    @Override
    public String toString() {
        return Arrays.toString(myArray);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);

        //myArrayList.clear();

        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);
        myArrayList.add(80);
        myArrayList.add(90);
        myArrayList.add(100);

        myArrayList.remove(4);
        myArrayList.remove(1);

        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.getSize());
        System.out.println(myArrayList.get(0));
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}