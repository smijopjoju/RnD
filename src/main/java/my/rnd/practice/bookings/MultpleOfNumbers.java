package my.rnd.practice.bookings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultpleOfNumbers {

    public static void main(String ...args) {
        List<Integer> multiples = multiple(3,5,10,22);
        for(Integer num: multiples) {
            System.out.println(num);
        }
    }

    public static List<Integer> multiple(int x, int y, int z, int n) {
        List<Integer> multiples = new ArrayList<>();
        for(int number =1; number<=n; ++number) {
            if(z != 0) {
                if((number % z) != 0) {
                    if(x != 0 && (number % x) == 0) {
                        multiples.add(number);
                    } else if( y != 0 && (number % y) == 0) {
                        multiples.add(number);
                    }
                }
            } else {
                if(x != 0 && (number % x) == 0) {
                    multiples.add(number);
                } else if( y != 0 && (number % y) == 0) {
                    multiples.add(number);
                }
            }

        }
        return multiples;
    }
}
