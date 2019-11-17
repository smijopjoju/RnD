package my.rnd.practice.hackerrank;

public class FindMinimumPageCountRequired {

    public static void main(String... args) {
        System.out.println(pageCount(6,2));
    }

    static int pageCount(int n, int p) {
        int numberOfPageTurnRequiredFromFront = findPageTurnRequiredFromFront(n,p);
        int numberOfPageTurnRequiredFromEnd = findPageTurnRequiredFromEnd(n,p);
        return minimumPageTurnRequired(numberOfPageTurnRequiredFromFront, numberOfPageTurnRequiredFromEnd);
    }

    static int findPageTurnRequiredFromFront(int n, int p) {
        int totalPageTurnRequired = 0;
        int pageNumber = 1;
        while (pageNumber != p) {
            ++totalPageTurnRequired;
            ++pageNumber;
            if (pageNumber != p) {
                ++pageNumber;
            }
        }

        return totalPageTurnRequired;
    }

    static int findPageTurnRequiredFromEnd(int n, int p) {
        int totalPageTurnRequired = 0;
        int pageNumber = n;
        boolean isLastPageNumberOnRight = n % 2 != 0 ? true : false;

        if(n == p) {
            return totalPageTurnRequired;
        }

        if (isLastPageNumberOnRight) {
            --pageNumber;
        }

        while (pageNumber != p) {
            ++totalPageTurnRequired;
            --pageNumber;
            if (pageNumber != p) {
                --pageNumber;
            }
        }

        return totalPageTurnRequired;
    }


    static int minimumPageTurnRequired(int front, int end) {
        if (front < end) {
            return front;
        }
        return end;
    }

}
