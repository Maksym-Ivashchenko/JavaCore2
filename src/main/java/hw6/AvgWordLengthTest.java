package hw6;

class AvgWordLengthTest {
    public static void main(String[] args) {
        //6
        System.out.println(new AvgWordLength().count("Launch Rocket"));

        //4.5
        System.out.println(new AvgWordLength().count("Life is strange thing"));
    }
}

class AvgWordLength {
    public double count(String phrase) {
        String[] phraseArray = phrase.split(" ");
        String phraseLength = phrase.replaceAll(" ", "");
        return (double) phraseLength.length()/phraseArray.length;
    }
}