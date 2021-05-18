package hw7;

public class ShapeName {

    Shape circle = new Circle();
    Shape square = new Square();
    Shape triangle = new Triangle();
    Shape rhombus = new Rhombus();
    Shape hexagon = new Hexagon();
    Shape sphere = new Sphere();
    Shape cylinder = new Cylinder();
    Shape cone = new Cone();
    Shape cube = new Cube();
    Shape pyramid = new Pyramid();


    public String getNameShape(Shape shape) {
       return shape.getName();
    }
}
