package hw5;

import java.util.Arrays;

class PowTable {
        public static final int[] POWERS_2;
    static {
        POWERS_2 = new int[10];
        POWERS_2[0] = 1;
        POWERS_2[1] = 4;
        POWERS_2[2] = 9;
        POWERS_2[3] = 16;
        POWERS_2[4] = 25;
        POWERS_2[5] = 36;
        POWERS_2[6] = 49;
        POWERS_2[7] = 64;
        POWERS_2[8] = 81;
        POWERS_2[9] = 100;
    }
}

class PowTableTest {
    public static void main(String[] args) {
        //[1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
        System.out.println(Arrays.toString(PowTable.POWERS_2));
    }
}