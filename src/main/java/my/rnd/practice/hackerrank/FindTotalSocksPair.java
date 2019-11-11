package my.rnd.practice.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTotalSocksPair {

    public static void main(String ...args) {
        System.out.println(sockMerchant(9, new int[]{10,20,20,10,10,30,50,10,20}));
    }

    static int sockMerchant(int n, int[] ar) {
        int totalNumberOfSocksPair = 0;
        Map<Integer,Integer> pairs = new HashMap<>();
        int count = 0;
        for(int color: ar) {
            if(pairs.containsKey(color)) {
                count = pairs.get(color);
                ++count;

                if(count%2 == 0) {
                    ++totalNumberOfSocksPair;
                }

                pairs.put(color,count);
            } else {
                pairs.put(color,1);
            }
        }
        return totalNumberOfSocksPair;
    }
}
