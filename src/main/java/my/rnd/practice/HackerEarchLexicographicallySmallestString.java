package my.rnd.practice;

import java.util.Scanner;

public class HackerEarchLexicographicallySmallestString {

	
	public static void main(String ...args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		long k	=	in.nextLong();
		System.out.println(findLexiSmallestString(new StringBuilder(str),k));
	}
	
	public static String findLexiSmallestString(StringBuilder inputStr, long k) {
		
		try {
				if(inputStr.length()>=k) {										
					StringBuilder resultStr = new StringBuilder();
					while(inputStr.length()>0) {
						int abstractIndex = smallestCharacter(inputStr, k);
						resultStr.append(inputStr.charAt(abstractIndex));
						inputStr.deleteCharAt(abstractIndex);						
					}
					
					return resultStr.toString();
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static int smallestCharacter(StringBuilder inputStr, long k) {
				
		if(inputStr.length() > 0) {
			char smallestChar = inputStr.charAt(0);
			int smallestCharIndex = 0;
			int lenght = (int) (inputStr.length() > k ? k : inputStr.length()); 
			for(int index = 1; index < lenght; index ++) {
				if(smallestChar>inputStr.charAt(index)) {
					smallestChar = inputStr.charAt(index);
					smallestCharIndex = index;
				}
			}
			
			return smallestCharIndex;
		}
		
		return 0;
	}
}
