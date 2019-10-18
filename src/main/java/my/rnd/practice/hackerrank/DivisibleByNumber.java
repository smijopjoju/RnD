package my.rnd.practice.hackerrank;

public class DivisibleByNumber {

    public static void main(String ...args) {
        System.out.println(divisibleSumPairs(6,5,new int[]{1,2,3,4,5,6}));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int countOfDivisibleNumbers = 0;

        int sumOfNumbers = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i+1; j < n; ++j) {
                sumOfNumbers = ar[i] + ar[j];
                if(sumOfNumbers % k == 0) {
                    ++countOfDivisibleNumbers;
                }
            }

        }

        return countOfDivisibleNumbers;
    }
}
