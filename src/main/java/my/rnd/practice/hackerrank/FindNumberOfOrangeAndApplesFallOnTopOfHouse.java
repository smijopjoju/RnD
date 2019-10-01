package my.rnd.practice.hackerrank;

public class FindNumberOfOrangeAndApplesFallOnTopOfHouse {

    public static void main(String ...args) {
        countApplesAndOranges(7,11,5,15,new int[]{-2,2,1},new int[]{5,-6});
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int applesFallOnHouseCount = 0;
        int orangesFallOnHouseCount = 0;

        int distance = 0;
        for(int index = 0; index < apples.length; ++index) {
            distance = a + apples[index];
            if(distance>= s && distance <= t ) {
                ++applesFallOnHouseCount;
            }
        }

        for(int index = 0; index < oranges.length; ++index) {
            distance = b + oranges[index];
            if(distance>= s && distance <= t ) {
                ++orangesFallOnHouseCount;
            }
        }

        System.out.println(applesFallOnHouseCount);
        System.out.println(orangesFallOnHouseCount);
    }
}
