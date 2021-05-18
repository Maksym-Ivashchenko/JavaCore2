package hw4;

public class Stars {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        int n1000 = count / 1000;
        int n100 = (count - n1000 * 1000) / 100;
        int n10 = (count - (n1000 * 1000) - (n100 * 100)) / 10;
        int n = count - (n1000 * 1000) - (n100 * 100) - (n10 * 10);
        return "X".repeat(n1000) + "Y".repeat(n100) + "Z".repeat(n10) + "*".repeat(n);
    }

    public static void main(String[] args) {
        Stars stars = new Stars();
        stars.setCount(3153);
        System.out.println(stars);
        System.out.println(stars.getCount());
    }
}
