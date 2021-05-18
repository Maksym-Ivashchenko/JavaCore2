package hw3;

import java.util.*;

public class MoonComputerTests {
    public void testBasicInputOutput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
        scanner.close();
    }

    public void testMath() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = a + b;
        int sub = a - b;
        int multiply = a * b;
        int divide = a / b;

        System.out.println(sum + " " + sub + " " + multiply + " " + divide);

        scanner.close();
    }
    public void testLogicalOperators(){
        Scanner scanner = new Scanner(System.in);
        boolean c1 = scanner.nextBoolean();
        boolean c2 = scanner.nextBoolean();
        boolean c3 = scanner.nextBoolean();
        System.out.println((c1&c2) + " " + (c1&c2|c3));
        scanner.close();
    }
    //Test output on true, true, false standard input
    public static void main(String[] args) {
        new MoonComputerTests().testLogicalOperators();
    }
}