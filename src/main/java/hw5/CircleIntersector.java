package hw5;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class CircleIntersector {
    static int x1;
    static int y1;
    static int r1;
    static int x2;
    static int y2;
    static int r2;

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getR1() {
        return r1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getR2() {
        return r2;
    }

CircleIntersector(int x1, int y1, int r1, int x2, int y2, int r2) {
        this.x1 = x1;
        this.y1 = y1;
        this.r1 = r1;
        this.x2 = x2;
        this.y2 = y2;
        this.r2 = r2;
    }

    @Override
    public String toString() {
        double distanse = sqrt(pow((y2 - y1), 2) + pow((x2 - x1), 2));
        if(distanse <= (r1 + r2))
            return "intersects";
        return "not intersects";
    }
}

class CircleIntersectorTest {
    public static void main(String[] args) {
        //intersects
        System.out.println(new CircleIntersector(0, 0, 2, 4, 0, 2));

        //not intersects
        System.out.println(new CircleIntersector(0, 0, 1, 4, 0, 2));

        //not intersects
        System.out.println(new CircleIntersector(5, 5, 2, 8, 8, 2));
    }
}