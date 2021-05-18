package hw6;

class SummaryCreatorTest {
    public static void main(String[] args) {
        SummaryCreator summaryCreator = new SummaryCreator();

        //Mars
        String shortPhrase = "Mars";
        System.out.println(summaryCreator.create(shortPhrase));

        //Java is very po...
        String longPhrase = "Java is very popular language";
        System.out.println(summaryCreator.create(longPhrase));
    }
}

class SummaryCreator {
    public String create(String text) {
        if (text.length() >= 16){
            text = text.substring(0, 16);
            if (!text.endsWith(" "))
                return text.substring(0, 15) + "...";
            return text.trim();
        }
        return text;
    }
}