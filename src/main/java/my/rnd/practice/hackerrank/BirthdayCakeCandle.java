package my.rnd.practice.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeCandle {

    public static void main(String ...args) {
        System.out.println(birthdayCakeCandles(new int[]{3,2,1,5}));
    }

    static int birthdayCakeCandles(int[] ar) {
        int tallestHeight = 0;
        Map<Integer,Integer> candlesHeightsCount = new HashMap<>();
        int value = 0;
        int heightsCount = 0;
        for(int index = 0; index < ar.length; ++index) {
            value = ar[index];
            if(candlesHeightsCount.containsKey(value)) {
                heightsCount = candlesHeightsCount.get(value);
                ++heightsCount;
                candlesHeightsCount.put(value,heightsCount);
            } else {
                heightsCount = 1;
                candlesHeightsCount.put(value,heightsCount);
            }

            if(tallestHeight<value) {
                tallestHeight = value;
            }
        }

        return candlesHeightsCount.get(tallestHeight);
    }
}
