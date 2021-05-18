package hw6;

class ShortWordCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new ShortWordCounter().count("Java is great language", 2));

        //2
        System.out.println(new ShortWordCounter().count("Java is great language", 4));

        //3
        System.out.println(new ShortWordCounter().count("Java is great language", 5));

        //4
        System.out.println(new ShortWordCounter().count("Java is great language", 100));
    }
}

class ShortWordCounter {
    public int count(String phrase, int minLength) {
        String[] words = phrase.split(" ");
        int i = 0;
        int count = 0;
        for (String word : words) {
            if (words[i++].length() <= minLength)
                count++;
        }
        return count;
    }
}