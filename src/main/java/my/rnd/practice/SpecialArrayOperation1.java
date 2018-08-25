package my.rnd.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpecialArrayOperation1 {

	public static final String VALUES_LIST = "values";
	public static final String OPERATIONS_LIST = "operations";
	
	public static void main(String[] args) {
		
		try {
				Scanner in = new Scanner(System.in);
				
				long noOfVal = in.nextLong();
				long noOfQuery = in.nextLong();
				
				List<Long> valuesList = new ArrayList<>();
				for(long valIndex = 0; valIndex < noOfVal; ++valIndex) {
					valuesList.add(in.nextLong());
				}
				
				List<Long> kOperationsList = new LinkedList<>();
				for(long operIndex = 0; operIndex < noOfQuery; ++operIndex) {
					kOperationsList.add(in.nextLong());
				}
				
				in.close();
				
				if( valuesList != null && kOperationsList != null) {
					findTheMagicValue(valuesList, kOperationsList);
				}
				
		} catch( Exception e) {
			e.printStackTrace();
		}
		
	}

	static void findTheMagicValue(List<Long> valuesList, List<Long> kOperationsList) {
		
		try {
				for(Long kOper : kOperationsList) {
					List<Long> tempValuesList = new ArrayList<>();
					tempValuesList.addAll(valuesList);
					specialOperation(tempValuesList, kOper);
				}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void specialOperation(List<Long> valuesList, Long operationsCount) {
		
		try {
					if(valuesList != null && !valuesList.isEmpty() ) {
						for(long index = 0; index < operationsCount.longValue(); ++index) {
							Collections.sort(valuesList);
							int maxIndex = valuesList.size() != 0 ? valuesList.size()-1 : 0;
							long maxVal = valuesList.get(maxIndex);
							long minVal = valuesList.get(0);
							long diff = maxVal - minVal;
							valuesList.remove(valuesList.size()-1);
							valuesList.remove(0);
							valuesList.add(diff);
						}
						
						long sumOfVal = valuesList.stream().mapToLong(l->l.longValue()).sum();
						System.out.println(sumOfVal);
					}					
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}
}
