package hw6;

import java.util.Arrays;

class DoubleSpaceCleanerTest {
    public static void main(String[] args) {
        DoubleSpaceCleaner cleaner = new DoubleSpaceCleaner();

        //Hello World
        System.out.println(cleaner.clean("Hello World"));

        //Hello World
        System.out.println(cleaner.clean("       Hello              World          "));
    }
}

class DoubleSpaceCleaner {
    public String clean(String phrase) {
        String [] words = phrase.split(" ");
        String [] result = new String[words.length];
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty())
                result[count++] = word;
        }
        return result.length == count ? String.join(" ", result) : String.join(" ", Arrays.copyOfRange(result, 0, count));
    }
}