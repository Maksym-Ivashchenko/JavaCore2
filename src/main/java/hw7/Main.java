package hw7;

public class Main {
    public static void main(String[] args) {
       ShapeName shapeName = new ShapeName();


        System.out.println(shapeName.getNameShape(new Circle()));
        System.out.println(shapeName.getNameShape(new Cone()));
        System.out.println(shapeName.getNameShape(new Cube()));
        System.out.println(shapeName.getNameShape(new Cylinder()));
        System.out.println(shapeName.getNameShape(new Hexagon()));
        System.out.println(shapeName.getNameShape(new Pyramid()));
        System.out.println(shapeName.getNameShape(new Rhombus()));
        System.out.println(shapeName.getNameShape(new Sphere()));
        System.out.println(shapeName.getNameShape(new Square()));
        System.out.println(shapeName.getNameShape(new Triangle()));

    }
}
