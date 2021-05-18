package hw6;

import java.util.Arrays;

class PunctuationMarkCounterTest {
    public static void main(String[] args) {
        PunctuationMarkCounter counter = new PunctuationMarkCounter();

        //2
        System.out.println(counter.count("Hello, world!"));

        //1
        System.out.println(counter.count("This is Sparta!"));

        //1
        System.out.println(counter.count("End."));
    }
}

class PunctuationMarkCounter {
    public int count(String phrase) {
        char[] words = phrase.toCharArray();
        int count = 0;
        for (char word : words) {
            if (word == '.' || word == ',' || word == '!' || word == '?' || word == ';' || word == ':' )
                count++;
        }
        return count;
    }
}