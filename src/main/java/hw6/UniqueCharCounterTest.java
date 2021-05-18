package hw6;

import java.util.Arrays;

class UniqueCharCounterTest {
    public static void main(String[] args) {
        UniqueCharCounter charCounter = new UniqueCharCounter();

        //3
        System.out.println(charCounter.count("123javarush"));

        //4
        System.out.println(charCounter.count("ab100"));

        //3
        System.out.println(charCounter.count("Java"));
    }
}

class UniqueCharCounter {
    public int count(String phrase) {
        char[] words = phrase.toCharArray();
        Arrays.sort(words);
        int count = 1;
        char letter = words[0];
        for (int i = 0; i<words.length; i++) {
            if (letter != words[i]){
                count++;
                letter = words[i];
            }
        }
        return count;
    }
}