package hw10;

public class Main {
    public static void main(String[] args) {
        SortName sortName = new SortName();
        RandomNumber randomNumber = new RandomNumber();

        System.out.println(sortName.printNamesOdd(SortName.getNames()));
        System.out.println(sortName.printNamesUpperCase(SortName.getNames()));

        randomNumber.lcg(25214903917L, 11, 2^48, 0L).forEach(System.out::println);
    }
}
