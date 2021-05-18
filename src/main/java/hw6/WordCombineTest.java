package hw6;

class WordCombineTest {
    public static void main(String[] args) {
        //true
        System.out.println(new WordCombine().canCombine("ForesT", "tor"));

        //true
        System.out.println(new WordCombine().canCombine("Magic", "Mama"));

        //false
        System.out.println(new WordCombine().canCombine("War", "Piece"));
    }
}

class WordCombine {
    public boolean canCombine(String sourceWord, String targetWord) {
        String[] targetArray = targetWord.toLowerCase().split("");
        try {
            for (int i = targetArray.length-1; sourceWord.toLowerCase().contains(targetArray[i]); i--)
                return true;
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {return false;}
    }
}