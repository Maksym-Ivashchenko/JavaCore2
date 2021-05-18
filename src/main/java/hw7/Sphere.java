package hw7;

public class Sphere extends Circle implements VolumetricShape {
    private int radius;

    public Sphere() {
    }

    public Sphere(int radius) {
        this.radius = radius;
       }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return pi * Math.pow(getRadius(),2);
    }

    @Override
    public double volumetric() {
        return 4 * area() * getRadius() / 3;
    }

    @Override
    public String getName() {
        return "Сфера";
    }
}
