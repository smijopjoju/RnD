package my.rnd.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HackerEarthUnitBalancer {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try {
			
				String unitStr = in.nextLine();
				ArrayList<String> unitsArr = new ArrayList<>(Arrays.asList(unitStr.split(",")));				
				Map<String,String[]> unitRelationMap = new HashMap<>();
				for(int index=0; index<unitsArr.size() -1 ;++index) {	
					String[] lineArr = in.nextLine().split(" ");
					unitRelationMap.put(lineArr[0], lineArr);
				}
				
				unitRelation(unitRelationMap, unitsArr);
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

	}
	
	
	
	static void unitRelation(Map<String,String[]> unitRelationMap,ArrayList<String> unitsArr) {
		List<String[]> relationSequenceList = new ArrayList<>();
		ArrayList<String> addedkeysList = new ArrayList<>();
		String key = (String) unitRelationMap.keySet().toArray()[0];
		String[] valueArr;
		int index = 0;
		while(!unitsArr.isEmpty()) {
			if(unitRelationMap.containsKey(key)) {
				valueArr = unitRelationMap.get(key);
				if( valueArr != null && !addedkeysList.contains(key)) {
					addedkeysList.add(key);
					unitsArr.remove(key);
					key = valueArr[3];					
					relationSequenceList.add(index,valueArr);
					++index;
				} else if(addedkeysList.contains(key)) {
					key = unitsArr.get(0);
					unitsArr.remove(key);
					index = 0;
				}
			} else {
				key = unitsArr.get(0);
				unitsArr.remove(key);
				index = 0;
			}
						
		}
		
		StringBuilder resultStrBuilder = new StringBuilder("1"+relationSequenceList.get(0)[0]);
		long multiVal = 1;
		long multResult = 0;
		for(String[] dataArr : relationSequenceList) {
			
			multResult=multiVal*Long.valueOf(dataArr[2]);			
			resultStrBuilder.append(" = ");
			resultStrBuilder.append(multResult);
			resultStrBuilder.append(dataArr[3]);
			
			multiVal = multResult;//Long.valueOf(dataArr[2]);			
			
		}
		
		System.out.println(resultStrBuilder.toString());
	}

}
