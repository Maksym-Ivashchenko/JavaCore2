package hw7;

public class Square extends Shape implements Area {
    private int side;

    public Square() {
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public String getName() {
        return "Квадрат";
    }

    @Override
    public double volumetric() {
        return 0;
    }
}
