package hw3;

public class TrurlBank {
    public int sumQuads(int n) {
        int result = 0;

        while(n > 0) {
            result += n * n;
            n--;
        }

        return result;
    }
    public int countSumOfDigits(int number) {
        String numberToString = String.valueOf(number);
        String[] numToM = numberToString.split("");
        int i = 0;
        int sum = 0;
        while (i < numToM.length) {
            sum = sum + Integer.parseInt(numToM[i]);
            i++;
        } return sum;
    }
    public static void main(String[] args) {
        TrurlBank bank = new TrurlBank();

        //Should be 16 - 5 + 4 + 7
        System.out.println(bank.countSumOfDigits(547));
    }
}