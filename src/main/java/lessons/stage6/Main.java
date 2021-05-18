package lessons.stage6;

public class Main {
    public static void main(String[] args) {

        String[] arr1 ={"1","2","3"};
        ArrayWraper arrayWraper = new ArrayWraper(arr1);
        StringWraper stringWraper = new StringWraper("value");

        print(arrayWraper);
        print(stringWraper);

    }

    public static void print(Iterable args) {
        while (args.hasNext())
            System.out.println(args.next());
    }
}
