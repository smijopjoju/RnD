package my.rnd.practice.interview;

public class UsernamePattern {

    public static boolean validate(String username) {

        char[] charArr = username.toCharArray();
        int asciiValueForDot = 46;
        int asciiValueStartForLowerCaseAlphabet = 97;
        int asciiValueEndForLowerCaseAlphabet = 122;
        int asciiValueStartForUpperCaseAlphabet = 65;
        int asciiValueEndForUpperCaseAlphabet = 90;

        if(charArr.length < 6 || charArr.length > 20) {
            return false;
        }

        if(!((charArr[0]>=asciiValueStartForUpperCaseAlphabet && charArr[0]<=asciiValueEndForUpperCaseAlphabet)
        || (charArr[0] >= asciiValueStartForLowerCaseAlphabet && charArr[0] <= asciiValueEndForLowerCaseAlphabet))) {
            return false;
        }

        int totalNumberOfDots = 0;
        for(int charValue : charArr) {

            if (charValue == asciiValueForDot) {
                ++totalNumberOfDots;
                if(totalNumberOfDots > 1) {
                    return false;
                }
                continue;
            }


             if(!Character.isDigit(charValue) && charValue < asciiValueStartForUpperCaseAlphabet) {
                 return false;
             }

             if(charValue > asciiValueEndForUpperCaseAlphabet && charValue < asciiValueStartForLowerCaseAlphabet) {
                 return false;
             }

             if(charValue > asciiValueEndForLowerCaseAlphabet) {
                 return false;
             }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("s12fd#s")); // Valid username
        System.out.println(validate("Robert@Domek.")); // Invalid username


    }
}
