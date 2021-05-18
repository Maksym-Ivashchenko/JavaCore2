package hw7;

public class Hexagon extends Shape implements Area {
    private int side;

    public Hexagon() {
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Hexagon(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 1.5 * Math.sqrt(3) * Math.pow(getSide(), 2);
    }

    @Override
    public String getName() {
        return "Шестигранник";
    }

    @Override
    public double volumetric() {
        return 0;
    }
}
