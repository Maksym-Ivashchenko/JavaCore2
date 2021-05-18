package hw5;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class TargetFinderTest {
    public static void main(String[] args) {
        int[] aiCoords = {-34, 31};
        int[][] targets = {
                {2, 31},
                {7, 31},
                {-26, 31},
                {-23, 31},
                {-13, 31}
        };
        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        //Expect [-26, 31]
       System.out.println(Arrays.toString(nearestTarget));
    }
}

class TargetFinder {
    public int[] findTarget(int[] aiCoords, int[][] targets){
        int[] distance = new int[2];
        double min = Math.sqrt(Math.pow(Math.abs(targets[0][0] - aiCoords[0]), 2) +
                Math.pow(Math.abs(targets[0][1] - aiCoords[1]), 2));
            for (int j=0; j<=targets.length-2; j++)
            {
               if (min <= Math.sqrt(Math.pow(Math.abs(targets[j+1][0] - aiCoords[0]), 2) +
                    Math.pow(Math.abs(targets[j+1][1] - aiCoords[1]), 2))) {
               } else {
                   min = Math.sqrt(Math.pow(Math.abs(targets[j + 1][0] - aiCoords[0]), 2) +
                           Math.pow(Math.abs(targets[j + 1][1] - aiCoords[1]), 2));
                   distance[0] = targets[j + 1][0];
                   distance[1] = targets[j + 1][1];
               }
            }
        return distance;
    }
}
