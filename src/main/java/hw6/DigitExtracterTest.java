package hw6;

import java.util.Arrays;

class DigitExtracterTest {
    public static void main(String[] args) {
        DigitExtracter digitExtracter = new DigitExtracter();

        int[] extracted = digitExtracter.extract("april 5, year 2000");

        //[5, 2, 0, 0, 0]
        System.out.println(Arrays.toString(extracted));
    }
}

class DigitExtracter {
    public int[] extract(String text) {
        String str = text.replaceAll("[^\\d.]", "");
        int count = 0;
        char [] stringArray = str.toCharArray();
        int [] intArray = new int[stringArray.length];
        for (char i : stringArray) {
            int m = Character.getNumericValue(i);
            intArray[count] = m;
            count += 1;
        }
        return intArray;
    }
}