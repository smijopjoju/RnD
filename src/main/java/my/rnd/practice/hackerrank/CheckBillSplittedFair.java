package my.rnd.practice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class CheckBillSplittedFair {

    public static void main(String args[]) {
        bonAppetit(Arrays.asList(3,10,2,9),1,7);
    }

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

        long totalAmountForTheItemsBothPartiesHad = 0;

        for(int index = 0; index < bill.size(); ++index) {
            if(index == k) continue;
            totalAmountForTheItemsBothPartiesHad += bill.get(index);
        }

        long annasActualBillAmount = totalAmountForTheItemsBothPartiesHad / 2;
        long amountShouldReturnToAnna = b - annasActualBillAmount;
        if(amountShouldReturnToAnna == 0) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(amountShouldReturnToAnna);
        }

    }
}
