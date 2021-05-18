package hw7;

public class Cone extends Circle implements VolumetricShape {
    private int radius;
    private int height;

    public Cone() {
    }

    public Cone(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return pi * Math.pow(getRadius(), 2);
    }

    @Override
    public double volumetric() {
        return area() * getHeight() / 3;
    }

    @Override
    public String getName() {
        return "Конус";
    }
}