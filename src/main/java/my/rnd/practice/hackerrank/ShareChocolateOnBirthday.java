package my.rnd.practice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ShareChocolateOnBirthday {
    public static void main(String ...args) {
            System.out.println(birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2));
    }

    static int birthday(List<Integer> s, int d, int m) {
        int totalWaysToShareChocolate = 0;
        int chocolatesSize = s.size();
        int innerLoopSize = 0;
        int sum = 0;
        for (int outerLoopIndex = 0; outerLoopIndex < chocolatesSize; ++outerLoopIndex) {
            innerLoopSize = outerLoopIndex + m;
            if (innerLoopSize <= chocolatesSize) {
                for (int innerLoopIndex = outerLoopIndex; innerLoopIndex < innerLoopSize; ++innerLoopIndex) {
                    sum += s.get(innerLoopIndex);
                }

                if (sum == d) {
                    ++totalWaysToShareChocolate;
                }
            } else {
                if (m == 1 && s.size() == 1) {
                    if (s.get(0) == d) {
                        ++totalWaysToShareChocolate;
                    }
                }
            }

            sum = 0;
        }

        return totalWaysToShareChocolate;
    }


}
