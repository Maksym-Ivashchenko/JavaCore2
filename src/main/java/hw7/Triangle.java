package hw7;

public class Triangle extends Shape implements Area {
    private int side;

    public Triangle() {
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Triangle(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(getSide(), 2) * Math.sqrt(3) / 4;
    }

    @Override
    public String getName() {
        return "Треугольник";
    }

    @Override
    public double volumetric() {
        return 0;
    }
}
