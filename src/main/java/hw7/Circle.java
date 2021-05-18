package hw7;

public class Circle extends Shape implements Area {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle() {}

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Круг";
    }

    @Override
    public double area() {
        return pi * Math.pow(getRadius(), 2);
    }

    @Override
    public double volumetric() {
        return 0;
    }
}
