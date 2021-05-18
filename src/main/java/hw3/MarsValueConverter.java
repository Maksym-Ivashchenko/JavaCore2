package hw3;

public class MarsValueConverter {
    public int changeMoneyAmount(float startAmount, float toRemove) {
        return (int) (startAmount - toRemove);
    }

    public byte calculateMoneySum(int sum1, int sum2) {
        return (byte) (sum1 + sum2);
    }

    public short halfOfMoney(double startMoney) {
        return (short) (startMoney/2);
    }

    public static void main(String[] args) {
        MarsValueConverter converter = new MarsValueConverter();

        //Should be 10
        System.out.println(converter.changeMoneyAmount(100f, 40.5f));

        //Should be 17
        System.out.println(converter.calculateMoneySum(50, 40));

        //Should be 9.18
        System.out.println(converter.halfOfMoney(1000.9999));
    }
}