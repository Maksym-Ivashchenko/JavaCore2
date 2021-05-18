package hw7;

public class Rhombus extends Shape implements Area {
    private int height;
    private int weight;

    public Rhombus() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rhombus(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public double area() {
        return ((getWeight() * getHeight()) / 2);
    }

    @Override
    public String getName() {
        return "Ромб";
    }

    @Override
    public double volumetric() {
        return 0;
    }
}
