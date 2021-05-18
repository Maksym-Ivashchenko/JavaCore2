package hw6;

class SensitiveDataSearcherTest {
    public static void main(String[] args) {
        SensitiveDataSearcher searcher = new SensitiveDataSearcher();

        //false
        System.out.println(searcher.isSensitiveDataPresent("Hello world"));

        //true
        System.out.println(searcher.isSensitiveDataPresent("Pass: swordfish"));
    }
}

class SensitiveDataSearcher {
    public boolean isSensitiveDataPresent(String phrase) {
        String[] words = phrase.split(" ");
        String[] sensetiveData = new String[]{"pass", "key", "login", "email"};
        boolean count = false;
        for (String word : words) {
            for (String sensetive : sensetiveData){
                if (word.toLowerCase().contains(sensetive))
                count = true;
            }
        }
        return count;
    }
}