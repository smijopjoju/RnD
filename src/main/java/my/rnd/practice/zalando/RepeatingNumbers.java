package my.rnd.practice.zalando;

public class RepeatingNumbers {

    public static void main(String ...args) {
        int[] A = new int[]{3,5,6,3,3,5};
        System.out.println(solutions(A));
    }

    public static int solutions(int[] A) {
        int repeatingIndicesCount = 0;

        for(int index = 0; index < A.length-1; ++index) {
            for(int secondLoopIndex = index+1; secondLoopIndex < A.length; ++secondLoopIndex) {
                if(A[index] == A[secondLoopIndex]) {
                    ++repeatingIndicesCount;
                }
            }
        }

        return repeatingIndicesCount;
    }
}
