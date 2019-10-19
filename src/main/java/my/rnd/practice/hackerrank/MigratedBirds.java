package my.rnd.practice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MigratedBirds {

    public static void main(String args[]) {
        try {
            System.out.println(migratoryBirds(Arrays.asList(1,2,3,4,5,4,3,2,1,3,4)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static int migratoryBirds(List<Integer> arr) {
        int birdType = -1;
        int birdsMaxSpottedCount = 0;
        int birdsTypes[] = new int[5];

        int index = 0;
        for(Integer val: arr) {
            index = val-1;
            birdsTypes[index] = ++birdsTypes[index];
            if(birdsMaxSpottedCount < birdsTypes[index]) {
                birdsMaxSpottedCount = birdsTypes[index];
                birdType = val;
            } else if (birdsMaxSpottedCount == birdsTypes[index] && birdType > val) {
                birdType = val;
            }
        }

        return birdType;
    }
}
