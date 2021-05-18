package lessons.stage6;

public class StringWraper implements Iterable{
    private final String value;
    private int cursor = 0;

    public StringWraper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean hasNext() {
        return cursor < value.toCharArray().length;
    }

    @Override
    public String next() {
        return String.valueOf(value.charAt(cursor++));
    }

    @Override
    public void reset() {
        cursor = 0;
    }
}
