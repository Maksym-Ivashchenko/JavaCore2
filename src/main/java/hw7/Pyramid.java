package hw7;

public class Pyramid extends Shape implements VolumetricShape {
    private int side;
    private int height;

    public Pyramid() {
    }

    public Pyramid(int side, int height) {
        this.side = side;
        this.height = height;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double area() {
        return Math.pow(getSide(), 2) * Math.sqrt(3) / 4;
    }

    @Override
    public double volumetric() {
        return area() * getHeight() / Math.sqrt(9);
    }

    @Override
    public String getName() {
        return "Пирамида";
    }
}
