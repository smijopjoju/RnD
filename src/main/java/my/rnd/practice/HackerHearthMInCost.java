package my.rnd.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HackerHearthMInCost {
	
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
					List costOfPetrol = new LinkedList<>();
					List amountOfPetrolList = new LinkedList<>();
					
					for(long i = 0; i<numOfCheckPoints;++i) {
						costOfPetrol.add(in.nextLong());
					}
					
					for(long i = 0; i<numOfCheckPoints;++i) {
						amountOfPetrolList.add(in.nextLong());
					}
					
					testCaseInputs.put(COST_OF_PETROL, costOfPetrol);
					testCaseInputs.put(AMOUNT_OF_PETROL, amountOfPetrolList);
					testCaseList.add(testCaseInputs);
				}
				
				for(Map testCase : testCaseList) {
					System.out.println(estimateMinCost((List)testCase.get(COST_OF_PETROL),(List)testCase.get(AMOUNT_OF_PETROL)));
				}
				
				in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	static long estimateMinCost(List<Long> costOfPetrol, List<Long> amountOfPetrol) {
		
		try {
				List<Long> minCostIndexList = new LinkedList<>();
				List petrolCost = new ArrayList<>();
				petrolCost.addAll(costOfPetrol);
				long resultIndex = 0;
				long totalAmount = 0;
				do {
					resultIndex = findLostPetrolCost(petrolCost);
					petrolCost = costOfPetrol.subList(0, (int)resultIndex);
					minCostIndexList.add(resultIndex);
					
				}while(resultIndex>0);
				
				long index1 = 0;
				for(long index = (minCostIndexList.size()-1); index >=0; --index) {
					long petrolAmount = costOfPetrol.get(minCostIndexList.get((int) index).intValue()).longValue();
					
					List<Long> requiredPetrolList = null;
					if(index == 0) {
						requiredPetrolList = new ArrayList();
						requiredPetrolList.add( amountOfPetrol.get(minCostIndexList.get((int) index).intValue()));
						
					} else {
						index1 = index - 1;
						requiredPetrolList = amountOfPetrol.subList(minCostIndexList.get((int) index).intValue(), minCostIndexList.get((int) index1).intValue());
					}
					
					int sumOfRequiredPetrolAmount = requiredPetrolList.stream().mapToInt(i->i.intValue()).sum();
					totalAmount += (sumOfRequiredPetrolAmount*petrolAmount);
				}
				
				return totalAmount;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	static long findLostPetrolCost( List<Long> costOfPetrol) {
		
		try {
				if( costOfPetrol != null && !costOfPetrol.isEmpty()) {
					long minAmount = costOfPetrol.get(0).longValue();
					long resultIndex = 0;
					for(int index = 0; index < costOfPetrol.size(); index ++) {
						
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
