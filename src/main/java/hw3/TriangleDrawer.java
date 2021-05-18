package hw3;

public class TriangleDrawer {
    public String drawTriangle(int side){
        String tr = "";
        while (side>0) {
            tr += "*".repeat(side) + "\n";
               side--;
        } return tr;
    }

    public static void main(String[] args) {
        TriangleDrawer triangleDrawer = new TriangleDrawer();
        System.out.println(new TriangleDrawer().drawTriangle(3));
    }

}
