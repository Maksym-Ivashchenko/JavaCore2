package hw6;

import java.util.Arrays;

class WordSplitterTest {
    public static void main(String[] args) {
        WordSplitter wordSplitter = new WordSplitter();

        String[] words = wordSplitter.split("Hello      world");
        //[hello, world]
        System.out.println(Arrays.toString(words));
    }
}

class WordSplitter {
    public String[] split(String phrase) {
            String [] words = phrase.split(" ");
            String [] result = new String[words.length];
            int count = 0;
            for (String word : words) {
                if (!word.isEmpty())
                    result[count++] = word.toLowerCase();
            }
            return result.length == count ? result : Arrays.copyOfRange(result, 0, count);

    }
}