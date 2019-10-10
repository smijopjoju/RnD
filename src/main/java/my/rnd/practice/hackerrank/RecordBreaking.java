package my.rnd.practice.hackerrank;

public class RecordBreaking {

    public static void main(String ...args) {
        int[] record = breakingRecords(new int[]{3,4,21,36,10,28,35,5,24,42});
        System.out.println("Max: "+record[0]);
        System.out.println("Least: "+record[1]);
    }

    static int[] breakingRecords(int[] scores) {
        int leastScore = scores[0];
        int maxScore = scores[0];
        int recordHoler[] = new int[]{0,0}; // 0 for Max record break, 1 for least values record break;
        for(int index = 1; index < scores.length; ++index) {
            if(leastScore>scores[index]) {
                leastScore = scores[index];
                recordHoler[1] = ++recordHoler[1];
            }

            if(maxScore<scores[index]) {
                maxScore = scores[index];
                recordHoler[0] = ++recordHoler[0];
            }
        }
        return recordHoler;
    }
}
