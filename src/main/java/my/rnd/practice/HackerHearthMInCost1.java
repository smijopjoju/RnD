package my.rnd.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HackerHearthMInCost1 {
	
	public static final String COST_OF_PETROL = "COST_OF_PETROL";
	public static final String AMOUNT_OF_PETROL = "AMOUNT_OF_PETROL";
	
	public static void main( String args[] ) {
	
		try {
				Scanner in = new Scanner(System.in);
				long testCaseNo = in.nextLong();
				List<Map> testCaseList = new ArrayList<>();
				
				for(long index = 0; index<testCaseNo;++index) {
					Map testCaseInputs = new HashMap<>();
					long numOfCheckPoints = in.nextLong();
					Map costOfPetrolMap = new HashMap<>();
					Map amountOfPetrolMap = new HashMap<>();
					
					for(long i = 0; i<numOfCheckPoints;++i) {
						costOfPetrolMap.put(i,in.nextLong());
					}
					
					for(long i = 0; i<numOfCheckPoints;++i) {
						amountOfPetrolMap.put(i,in.nextLong());
					}
					
					testCaseInputs.put(COST_OF_PETROL, costOfPetrolMap);
					testCaseInputs.put(AMOUNT_OF_PETROL, amountOfPetrolMap);
					testCaseList.add(testCaseInputs);
				}
				
				for(Map testCase : testCaseList) {
					System.out.println(estimateMinCost((Map)testCase.get(COST_OF_PETROL),(Map)testCase.get(AMOUNT_OF_PETROL)));
				}
				
				in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	static long estimateMinCost(Map<Long,Long> costOfPetrol, Map<Long,Long> amountOfPetrol) {
		
		try {
				Stack<Long> minCostIndexList = new Stack<>();							
				long resultIndex = costOfPetrol.size();
				long totalAmount = 0;
				do {
					resultIndex = findLostPetrolCost(costOfPetrol,0L,resultIndex);					
					minCostIndexList.add(resultIndex);					
				}while(resultIndex>0);
				
				long size = minCostIndexList.size();
				for(long index = 0; index<size; ++index) {
					long minCostIndex = minCostIndexList.pop().intValue();
					long index1 = minCostIndexList.empty() ? amountOfPetrol.size() : minCostIndexList.peek();
					long petrolAmount = costOfPetrol.get(minCostIndex).longValue();
					long sumOfRequiredPetrolAmount = (long) 0;
						
					sumOfRequiredPetrolAmount = amountOfPetrol.entrySet().stream().filter(map->(map.getKey().longValue()>=minCostIndex
								 && map.getKey().longValue()<index1)).mapToLong(i->i.getValue().longValue()).sum();
										
					totalAmount += (sumOfRequiredPetrolAmount*petrolAmount);
				}
				
				return totalAmount;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	static long findLostPetrolCost( Map<Long,Long> costOfPetrol,Long startIndex,Long endIndex) {
		
		try {
				if( costOfPetrol != null && !costOfPetrol.isEmpty()) {
					long minAmount = costOfPetrol.get(startIndex).longValue();
					long resultIndex = 0;
					for(long index = startIndex.intValue(); index < endIndex.intValue(); ++index) {
						
						if(minAmount>costOfPetrol.get(index)) {
							minAmount = costOfPetrol.get(index);
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
