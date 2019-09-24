package my.rnd.practice.hackerrank;

public class MinMaxSum {

    public static void main(String... args) {
        miniMaxSum(new int[]{1, 3, 9, 7, 5});
    }

    public static void miniMaxSum(int[] arr) {

        int temp = 0;
        for (int index = 0; index < arr.length - 1; ++index) {
            for (int index1 = index + 1; index1 < arr.length; ++index1) {
                if (arr[index] > arr[index1]) {
                    temp = arr[index1];
                    arr[index1] = arr[index];
                    arr[index] = temp;
                }
            }

        }

        int miniSum = 0;
        for (int index = 0; index < 4; ++index) {
            miniSum += arr[index];
        }

        int maxSum = 0;
        for (int index = arr.length - 1; index >= 1; --index) {
            maxSum += arr[index];
        }

        System.out.println(miniSum + " " + maxSum);
    }


}
