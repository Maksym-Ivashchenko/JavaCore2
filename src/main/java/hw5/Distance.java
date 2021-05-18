package hw5;

import static java.lang.Math.*;
class DistanceTest {
    public static void main(String[] args) {
        //Expect 14
        System.out.println(new Distance(10, 10, 20, 20).getDistance());

        //Expect 23
        System.out.println(new Distance(10, 10, 27, 25).getDistance());
    }
}
class Distance {
    static int startX;
    static int startY;
    static int endX;
    static int endY;

    public static int getStartX() {
        return startX;
    }

    public static int getStartY() {
        return startY;
    }

    public static int getEndX() {
        return endX;
    }

    public static int getEndY() {
        return endY;
    }

    Distance(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }
    public int getDistance() {
        return (int) Math.round(sqrt(pow((endX - startX), 2) + pow((endY - startY), 2)));
    }
}
