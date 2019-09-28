package my.rnd.practice.hackerrank;

public class MinMaxSum {

    public static void main(String... args) {
        miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});
        //2063136757 2744467344
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

        Long miniSum = 0L;
        for (int index = 0; index < 4; ++index) {
            miniSum += arr[index];
        }

        Long maxSum = 0L;
        for (int index = arr.length - 1; index >= 1; --index) {
            maxSum += arr[index];
        }

        System.out.println(miniSum + " " + maxSum);
    }


}
