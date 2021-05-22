package hw10;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSort {


    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};

        String list = Stream.of(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::valueOf)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(list);
    }
}
