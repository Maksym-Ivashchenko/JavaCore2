package hw6;


class PalindromeCounterTest {
    public static void main(String[] args) {
        PalindromeCounter counter = new PalindromeCounter();

        //1
        System.out.println(counter.count("Level done!"));

        //0
        System.out.println(counter.count("No palindromes"));
    }
}

class PalindromeCounter {
    public int count(String phrase) {
        String[] words = phrase.toLowerCase().split(" ");
        String stringRevers = new StringBuilder(phrase).reverse().toString().toLowerCase();
        String[] wordsReverse = stringRevers.split(" ");

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < wordsReverse.length; j++)
            if (words[i].equals(wordsReverse[j]))
                count++;
        }
        return count;
    }
}