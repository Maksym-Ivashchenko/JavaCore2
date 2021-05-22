package hw10;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UniteStreams {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        Stream.Builder<T> builder = Stream.builder();
        IntStream.range(0, Math.min(firstList.size(), secondList.size())).forEach(i -> {
            builder.add(firstList.get(i));
            builder.add(secondList.get(i));
        });
        List<T> list = builder.build().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Stream <Integer> stream1 = Arrays.stream(new Integer[] {13, 1, 3, 5, 7, 9});
        Stream <Integer> stream2 = Arrays.stream(new Integer[] {1, 2, 6, 14, 8, 10, 12});
        String string = zip(stream1, stream2).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(string);
    }
}