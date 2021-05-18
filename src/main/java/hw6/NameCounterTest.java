package hw6;

class NameCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new NameCounter().count("Mars is great planet"));

        //2
        System.out.println(new NameCounter().count("Moon is near Earth"));

        //0
        System.out.println(new NameCounter().count("SPACE IS GREAT"));
    }
}

class NameCounter {
    public int count(String text) {
        String[] textArr = text.split(" ");
        int i = 0;
        for (String t: textArr) {
            if ( t.length() > 1 && !t.equals(t.toLowerCase()) && !t.equals(t.toUpperCase()))
                i++;
        } return i;
    }
}