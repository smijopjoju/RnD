package my.rnd.practice.hackerrank;

public class MinMaxSum1 {

    public static void main(String... args) {
        minMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});
        //2063136757 2744467344
    }

    public static void minMaxSum(int[] arr) {
        Long maxSum = 0L;
        Long minSum = 0L;
        int arraySize = arr.length-1;
        int count = 0;
        Long sum = 0L;
        int currentIndex = 0;
        for(int index = 0; index <= arraySize; ++index) {
            count = 0;
            currentIndex = index;
            //StringBuilder sumStr = new StringBuilder();
            while(count<4) {
                /*sumStr.append(arr[currentIndex])
                        .append(" + ");*/
                sum+= arr[currentIndex];
                ++currentIndex;
                if(currentIndex>4) {
                    currentIndex = 0;
                }
                ++count;
            }
            /*sumStr.append("=").append(sum);
            System.out.println(sumStr);*/
            if(maxSum == 0 && minSum == 0) {
                maxSum = sum;
                minSum = sum;
            }
            if(sum > maxSum) {
                maxSum = sum;
            } else if(sum < minSum) {
                minSum = sum;
            }
            sum = 0L;
        }

        System.out.println(minSum+" "+maxSum);
    }

}
