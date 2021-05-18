package hw5;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

class QuarkeTrack {
private int sums;

    public int getSum() {
        return sums;
    }

    public QuarkeTrack(int[] lines){
         int sum = 0;
        for (int element : lines)
            sum += element;
        sums = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuarkeTrack that = (QuarkeTrack) o;
        return sums == that.sums;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + sums;
        return result;
    }
}
class QuarkeTrackTest {
    public static void main(String[] args) {
        int[] track1Data = {1, 3, 5};
        int[] track2Data = {3, 5, 4};
        int[] track3Data = {1, 5, 3};

        QuarkeTrack track1 = new QuarkeTrack(track1Data);
        QuarkeTrack track2 = new QuarkeTrack(track2Data);
        QuarkeTrack track3 = new QuarkeTrack(track3Data);
        System.out.println();
        //false
        System.out.println(track1.equals(track2));

        //true
        System.out.println(track1.equals(track3));

        //Can be true or false
        System.out.println(track1.hashCode() == track2.hashCode());

        //true
        System.out.println(track1.hashCode() == track3.hashCode());
    }
}
