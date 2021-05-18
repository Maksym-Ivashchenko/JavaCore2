package lessons.stage6;

import java.util.Arrays;

public class ArrayWraper implements Iterable{
    private final String[] array;
    private int cursor = 0;

    public ArrayWraper(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }

    @Override
    public String next() {
        return array[cursor++];
    }

    @Override
    public void reset() {
        cursor = 0;
    }
}
