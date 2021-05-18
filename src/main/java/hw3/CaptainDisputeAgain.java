package hw3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CaptainDisputeAgain {
    public int findMin(int[] triple) {

        return triple[0]<triple[1] && triple[0]<triple[2] ? triple[0] :
                triple[1]<triple[0] && triple[1]<triple[2] ? triple[1] : triple[2];
    }

    public static void main(String[] args) {
        CaptainDisputeAgain captainDispute = new CaptainDisputeAgain();

        //Should be even
        System.out.println(captainDispute.findMin(new int[] {1, 10, 3}));
        System.out.println(captainDispute.findMin(new int[] {50, 4, 100}));


    }
}

