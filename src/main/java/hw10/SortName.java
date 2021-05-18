package hw10;

import java.util.*;
import java.util.stream.Collectors;

public class SortName {
     private static final List<Person> names = new ArrayList<>();

    {
        names.add(new Person(1, "Ivan"));
        names.add(new Person(2, "Maks"));
        names.add(new Person(3, "Peter"));
        names.add(new Person(4, "Markus"));
        names.add(new Person(5, "Leonid"));
        names.add(new Person(6, "Dmitriy"));
        names.add(new Person(7, "Georg"));
        names.add(new Person(8, "Vitaliy"));
        names.add(new Person(9, "Victor"));
    }

    public String printNamesOdd(List<Person> personList) {
        return personList.stream()
                .filter(s -> s.getId() % 2 != 0)
                .map(Person::toString)
                .collect(Collectors.joining(", "));
    }

    public String printNamesUpperCase(List<Person> personList) {

        return personList.stream()
                .map(s -> s.getName().toUpperCase())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
    SortName sortName = new SortName();
        System.out.println(sortName.printNamesOdd(names));
        System.out.println(sortName.printNamesUpperCase(names));
    }
}
class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }
}