package hw6;

import java.util.Arrays;

class WordDeleterTest {
    public static void main(String[] args) {
        WordDeleter wordDeleter = new WordDeleter();

        //Hello
        System.out.println(wordDeleter.remove("xiefbidyd yhypno zime coe ycly evrudejy", new String[] {"yhypno", "zime", "ycly", "coe"}));

        //This Sparta
        System.out.println(wordDeleter.remove("This is Sparta", new String[] {"is"}));
    }
}

class WordDeleter {
    public String remove(String phrase, String[] words) {
        String[] phraseArray = phrase.split(" ");
        String [] result = new String[phraseArray.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < phraseArray.length; j++) {
                if (words[i].equals(phraseArray[j]))
                    phraseArray[j] = "";
            }
        }
        int count = 0;
        for (String word : phraseArray) {
            if (!word.isEmpty())
                result[count++] = word;
        }
        return result.length == count ? String.join(" ", result) : String.join(" ", Arrays.copyOfRange(result, 0, count));
    }
}