package hw6;

class WordFreqCounterTest {
    public static void main(String[] args) {
        WordFreqCounter freqCounter = new WordFreqCounter();

        //0.5
        System.out.println(freqCounter.countFreq("Hello Java", "java"));

        //0
        System.out.println(freqCounter.countFreq("gupo oqozun Udxag viymofwik fitua ypucm", "Udxag"));
    }
}

class WordFreqCounter {
    public float countFreq(String phrase, String word) {
        String [] newWords = phrase.split(" ");
        float count = 0;
        for (String newWord : newWords) {
            if (newWord.toLowerCase().equals(word.toLowerCase()))
            count++;
        }
        return count / (float) newWords.length;
    }
}