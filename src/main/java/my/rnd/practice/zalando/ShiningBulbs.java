package my.rnd.practice.zalando;

public class ShiningBulbs {

    public static void main(String ...args) {
        int A[] = new int[]{2,1,3,5,4};
        int moments = solution(A);
        System.out.println(moments);
    }

    public static int solution(int[] A) {
        int moments = 0;
        int[] sequenceArray = new int[A.length];
        for(int index = 0; index < A.length; ++index) {
            int currentVal = A[index];
            sequenceArray[currentVal-1] = currentVal;
            if(isAllBulbsAreShiningAtTheMoment(sequenceArray,currentVal)) {
                ++moments;
            }
        }
        return moments;
    }

    public static boolean isAllBulbsAreShiningAtTheMoment(int[] sequenceArray, int index) {
        boolean isItShines = true;
        for(int sequenceArrayIndex = 0; sequenceArrayIndex < index; ++sequenceArrayIndex) {
            if(sequenceArray[sequenceArrayIndex] == 0) {
                isItShines = false;
                break;
            }
        }
        return isItShines;
    }
}
