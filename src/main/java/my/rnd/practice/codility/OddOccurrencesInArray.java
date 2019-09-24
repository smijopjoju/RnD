package my.rnd.practice.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static void main(String ...args) {
        System.out.println(solutions(new int[]{1,2,1,3,2,5,5}));
    }

    public static int solutions(int A[]) {
        int oddOccurrenceValue = 0;

        Map<Integer,Integer> occurrenceTracker = new HashMap<>();
        Integer tracker = 0;
        for(int index = 0; index < A.length; ++index) {
            int value = A[index];
            if(occurrenceTracker.containsKey(value)) {
                tracker = occurrenceTracker.get(value);
                occurrenceTracker.put(value,++tracker);
            } else {
                tracker = 0;
                occurrenceTracker.put(value,++tracker);
            }
        }

        for(Map.Entry<Integer,Integer> trackerEntry: occurrenceTracker.entrySet()) {
            tracker = trackerEntry.getValue();
            if(tracker%2 != 0) {
                oddOccurrenceValue = trackerEntry.getKey();
                break;
            }
        }

        return oddOccurrenceValue;
    }
}
