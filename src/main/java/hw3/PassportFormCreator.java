package hw3;

import java.util.*;

public class PassportFormCreator {
    public void createForms() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String lastname = scanner.nextLine();
        int age = scanner.nextInt();
        System.out.println(name + " " + lastname + " " + (age*10));
        System.out.println(name.toUpperCase());
        System.out.println(lastname.toUpperCase());
        System.out.println(age*10);
        scanner.close();
    }

    //Test
    public static void main(String[] args) {
        new PassportFormCreator().createForms();
    }
}
