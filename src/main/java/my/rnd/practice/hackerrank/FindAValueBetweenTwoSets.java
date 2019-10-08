package my.rnd.practice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class FindAValueBetweenTwoSets {

    public static void main(String ...args) {
        System.out.println(getTotalX(Arrays.asList(1),Arrays.asList(100)));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int totalNumberValuesWhichMetCondition = 0;
        int biggestVal = 0;
        biggestVal = findBiggestValue(a,biggestVal);
        biggestVal = findBiggestValue(b,biggestVal);

        boolean isFactorOfAllElements = false;
        boolean allElementsAreItsFactor = false;
        for(int index = 1; index <= biggestVal; ++index) {
            allElementsAreItsFactor = isAllElementsAreFactors(a,index);
            isFactorOfAllElements = isFactorOfAllElements(b,index);
            if(allElementsAreItsFactor && isFactorOfAllElements) {
                ++totalNumberValuesWhichMetCondition;
            }
        }

        return totalNumberValuesWhichMetCondition;
    }

    public static int findBiggestValue(List<Integer> values, int biggestVal) {

        for(Integer number: values) {
            if(biggestVal < number) {
                biggestVal = number;
            }
        }

        return biggestVal;
    }

    public static boolean isAllElementsAreFactors(List<Integer> values, int number) {

        for(Integer value: values) {
            if(number % value != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFactorOfAllElements(List<Integer> values, int number) {

        for(Integer value: values) {
            if(value % number != 0) {
                return false;
            }
        }
        return true;
    }

}
