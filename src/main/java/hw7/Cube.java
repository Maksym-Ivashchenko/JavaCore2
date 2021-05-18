package hw7;

public class Cube extends Shape implements VolumetricShape {
    private int side;

    public Cube() {
    }

    public Cube(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double volumetric() {
        return area() * getSide();
    }

    @Override
    public double area() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public String getName() {
        return "Куб";
    }

}