package my.rnd.practice.zalando;

public class BinaryOperations {

    public static void main(String ...args) {
        String s = "011100";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int actionCount = 0;
        Integer value = Integer.parseInt(s,2);
        while(value>0) {
            if(value % 2 == 0) {
                value /= 2;
            } else {
                value -= 1;
            }
            ++actionCount;
        }
        return actionCount;
    }
}
