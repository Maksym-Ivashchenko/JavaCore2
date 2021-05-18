package hw6;

class BigOrSmallTest {
    public static void main(String[] args) {
        //Small
        System.out.println(new BigOrSmall().calculate("Java"));

        //Big
        System.out.println(new BigOrSmall().calculate("JAVA"));

        //Same
        System.out.println(new BigOrSmall().calculate("jAvA"));
    }
}

class BigOrSmall {
    public String calculate(String text) {
        String upperLetter = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            upperLetter += Character.isUpperCase(c) ? c : "";
        }
        int lowerLetter = text.length() - upperLetter.length();
        if (upperLetter.length()>lowerLetter)
            return "Big";
        if (upperLetter.length()<lowerLetter)
            return "Small";
        return "Same";
    }
}