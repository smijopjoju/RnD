package my.rnd.practice.hackerrank;



public class FindKangarooCanMeetAtSameLocation {

    public static void main(String ...args) {
        System.out.println(kangaroo(0,3,5,2));
    }
    static String kangaroo(int x1, int v1, int x2, int v2) {

        if(x1 > x2 && v1 > v2) {
            return "NO";
        } else if (x1 < x2 && v1 < v2) {
            return "NO";
        } else if (x1 == x2 && v1 != v2) {
            return "NO";
        }

        long x1Position = x1;
        long x2Position = x2;
        for(int index = 0; index < 10000; ++index) {
            x1Position += v1;
            x2Position += v2;
            if(x1Position == x2Position) {
                return "YES";
            }
        }

        return "NO";
    }
}
