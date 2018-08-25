package my.rnd.practice;

import java.util.Scanner;

class PoisonousGas {

	public static void main(String[] args) {
	
			try {
					Scanner in = new Scanner(System.in);
					long noOfTestCase = in.nextLong();
					long[][] testCases = new long[(int) noOfTestCase][];
					for(long index = 0; index< noOfTestCase; index++) {
						long sizeOfSoldiers = in.nextLong();
						long[] strength = new long[(int) sizeOfSoldiers];
						for(int indexOfSoldier = 0; indexOfSoldier < sizeOfSoldiers; indexOfSoldier++) {
							strength[indexOfSoldier] = in.nextLong();
						}
						testCases[(int) index] = strength;
					}
					
					in.close();
					
					for(int index2 = 0; index2 < noOfTestCase; index2 ++ ) {
						System.out.println(canReduceStrengthToOne(testCases[index2]));
					}
					
			} catch(Exception e) {
				e.printStackTrace();
			}

	}

	static String canReduceStrengthToOne(long[] soldiersStrength) {
		String result = "No";
		try {
				if( soldiersStrength != null && soldiersStrength.length >0 ) {
					
					long totalStrength = 0;
					
					for(int index1 = 0; index1 < soldiersStrength.length; index1 ++ ) {
						if( soldiersStrength[index1] > 0) {
							totalStrength += soldiersStrength[index1];
						}						
					}
					
					if( totalStrength != 0) {
						long modeResult = totalStrength%2;
						if(modeResult == 0) {
							double dividedValue = totalStrength;
							// Strength is even
							do {
									dividedValue = dividedValue / 2;
							} while( dividedValue > 1 );
							
							if( dividedValue == 1) {
								result = "Yes";
							}
						}
					}
					
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
 