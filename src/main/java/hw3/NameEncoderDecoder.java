package hw3;

public class NameEncoderDecoder {
    public static String encode(String name){
        return "NOTFORYOU"+name
                .replace("e", "1")
                .replace("u", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("a", "5")+"YESNOTFORYOU";
    }
    public static String decode(String name){
        return name
                .replace("1", "e")
                .replace("2", "u")
                .replace("3", "i")
                .replace("4", "o")
                .replace("5", "a")
                .replaceAll("NOTFORYOU", "")
                .replaceAll("YES", "");
    }

    public static void main(String[] args) {
        NameEncoderDecoder names = new NameEncoderDecoder();
        //"NOTFORYOUCr5bYESNOTFORYOU"
        System.out.println(encode("Crab"));
        //"Crab"
        System.out.println(decode("NOTFORYOUCr5bYESNOTFORYOU"));
        //"NOTFORYOU"
        System.out.println(decode("NOTFORYOUNOTFORYOUYESNOTFORYOU"));
    }
}