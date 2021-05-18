package hw3;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

public class QuadraticEquationSolver {
    public double[] solve(int a, int b, int c) {

        double a1 = (double) a;
        double b1 = (double) b;
        double c1 = (double) c;
        double D;

        D = b1 * b1 - 4 * a1 * c1;
        if (D > 0) {
            double[] Des = new double[2];
            Des[0] = (-b1 + Math.sqrt(D)) / (2 * a1);
            Des[1] = (-b1 - Math.sqrt(D)) / (2 * a1);
            return Des;
        }
        else if (D == 0) {
            double[] Des = new double[1];
            Des[0] = (-b1 / (2 * a1))+1-1;
           return Des;
        }
        else {
            double[] Des = new double[0];
            return Des;
        }
    }

    public static void main(String[] args) {
        QuadraticEquationSolver ship = new QuadraticEquationSolver();
        //[3.0], [-1.0]
        System.out.println(Arrays.toString(ship.solve(1, -2, -3)));
        System.out.println(Arrays.toString(ship.solve(1, 12, 36)));
        System.out.println(Arrays.toString(ship.solve(9, 0, 0)));
    }

}

