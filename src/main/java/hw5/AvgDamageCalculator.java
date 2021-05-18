package hw5;

class AvgDamageCalculator {
    public int calculateAvg(int[] samples) {
        int result = 0;
        try {
        int sum = 0;
        for(int sampleValue: samples) {
            sum += sampleValue;
        }
           result = sum / samples.length;
        } catch (ArithmeticException e) {
        } finally {

        } return result;
    }
}

class AvgDamageCalculatorTest {
    public static void main(String[] args) {
        //5
        System.out.println(new AvgDamageCalculator().calculateAvg(new int[] {2, 4, 6, 8}));

        //0
        System.out.println(new AvgDamageCalculator().calculateAvg(new int[0]));
    }
}