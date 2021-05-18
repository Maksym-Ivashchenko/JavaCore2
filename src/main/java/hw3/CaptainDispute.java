package hw3;

public class CaptainDispute {
    public String evenOrOdd(int number) {
        String num;
               return num = number%2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        CaptainDispute captainDispute = new CaptainDispute();

        //Should be even
        System.out.println(captainDispute.evenOrOdd(10));

        //Should be odd
        System.out.println(captainDispute.evenOrOdd(5));
    }
}