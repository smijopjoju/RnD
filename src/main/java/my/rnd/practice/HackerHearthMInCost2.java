package my.rnd.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HackerHearthMInCost2 {
	
	public static final String COST_OF_PETROL = "COST_OF_PETROL";
	public static final String AMOUNT_OF_PETROL = "AMOUNT_OF_PETROL";
	
		
	public static void main( String args[] ) {
	
		try {
				Scanner in = new Scanner(System.in);
				long testCaseNo = in.nextLong();
				List<Map> testCaseList = new ArrayList<>();
				
				for(long index = 0; index<testCaseNo;++index) {
					Map testCaseInputs = new HashMap<>();
					int numOfCheckPoints = in.nextInt();
					long[] costOfPetrolMap = new long[numOfCheckPoints];
					long[] amountOfPetrolMap = new long[numOfCheckPoints];
					
					for(int i = 0; i<numOfCheckPoints;++i) {
						costOfPetrolMap[i]=in.nextLong();
					}
					
					for(int i = 0; i<numOfCheckPoints;++i) {						
						amountOfPetrolMap[i]=in.nextLong();
					}
					
					testCaseInputs.put(COST_OF_PETROL, costOfPetrolMap);
					testCaseInputs.put(AMOUNT_OF_PETROL, amountOfPetrolMap);
					testCaseList.add(testCaseInputs);
				}
				
				for(Map testCase : testCaseList) {
					System.out.println(estimateMinCost((long[])testCase.get(COST_OF_PETROL),(long[])testCase.get(AMOUNT_OF_PETROL)));
				}
				
				in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	static long estimateMinCost(long[] costOfPetrol, long[] amountOfPetrol) {
		
		try {
				Stack<Long> minCostIndexList = new Stack<>();							
				int resultIndex = costOfPetrol.length;
				long totalAmount = 0;
				do {
					resultIndex = findLostPetrolCost(costOfPetrol,0,resultIndex);					
					minCostIndexList.add(Long.valueOf(resultIndex));					
				}while(resultIndex>0);
				
				long size = minCostIndexList.size();
				for(long index = 0; index<size; ++index) {
					int minCostIndex = minCostIndexList.pop().intValue();
					int index1 = minCostIndexList.empty() ? amountOfPetrol.length : minCostIndexList.peek().intValue();
					long petrolAmount = costOfPetrol[minCostIndex];
					long sumOfRequiredPetrolAmount = (long) 0;
					
					for(int sumIndex = minCostIndex; sumIndex < index1; ++sumIndex) {
						sumOfRequiredPetrolAmount+= amountOfPetrol[sumIndex];
					}
					
					totalAmount += (sumOfRequiredPetrolAmount*petrolAmount);
				}
				
				return totalAmount;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	static int findLostPetrolCost( long[] costOfPetrol,int startIndex,int endIndex) {
		
		try {
				if( costOfPetrol != null && costOfPetrol.length > 0) {
					long minAmount = costOfPetrol[startIndex];
					int resultIndex = 0;
					for(int index = startIndex; index < endIndex; ++index) {
						
						if(minAmount>costOfPetrol[index]) {
							minAmount = costOfPetrol[index];
							resultIndex = index;  
						}
					}
					return resultIndex;
				}				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
