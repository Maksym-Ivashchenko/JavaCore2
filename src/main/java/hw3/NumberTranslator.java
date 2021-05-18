package hw3;

public class NumberTranslator {
    public int translate(String romanNumber){
        int num;
        switch (romanNumber.toUpperCase().replaceAll("\\s","")) {
            case "I": num=1; break;
            case "II": num=2; break;
            case "III": num=3; break;
            case "IV": num=4; break;
            case "V": num=5; break;
            case "VI": num=6; break;
            case "VII": num=7; break;
            case "VIII": num=8; break;
            case "IX": num=9; break;
            case "X": num=10; break;
            case "XI": num=11; break;
            case "XII": num=12; break;
            default: num=-1; break;
        }
        return num;
    }

    public static void main(String[] args) {
        NumberTranslator numberTranslator = new NumberTranslator();
        System.out.println(numberTranslator.translate("  X  I"));
        System.out.println(numberTranslator.translate("iX  "));
        System.out.println(numberTranslator.translate("XX"));
    }

}
