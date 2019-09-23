package my.rnd.practice.codility;

public class BinaryGap {
    public static void main(String args[]) {
        System.out.println(solution(1610612737));
    }

    public static int solution(int N) {
        String binaryRepresentation = Integer.toBinaryString(N);
        int largestGap = 0;
        int gap = 0;
        char[] charArr = binaryRepresentation.toCharArray();
        int totalLength = charArr.length;
        int gapCounter = 0;
        for(int index = 0; index < totalLength; ++index) {
            if(charArr[index] == '0') {
                if(gapCounter >=1 ) {
                    ++gap;
                }
            } else {
                ++gapCounter;
            }
            if(gapCounter == 2) {
                if(largestGap<gap) {
                    largestGap = gap;
                }
                gapCounter = 1;
                gap = 0;
            }

        }

        return largestGap;
    }
}
