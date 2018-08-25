package my.rnd.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HackerEarthOneValue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
				
				Map<Long,Long> myMap= new HashMap<>();
				long totalNumberOfQueries = in.nextLong();
				int command = 0;
				long val = 0;
				for(int index = 0; index < totalNumberOfQueries; ++index) {
					command = in.nextInt();
					switch (command) {
					case 1:
							val = in.nextLong();
							if(myMap.containsKey(val)) {
								myMap.put(val, myMap.get(val)+1);
							} else {
								myMap.put(val, Long.valueOf(1));
							}
						break;
					case 2:
							val = in.nextLong();
							if(myMap.containsKey(val)) {
								if(myMap.get(val) == 1) {
									myMap.remove(val);
								} else {
									myMap.put(val, myMap.get(val)-1);
								}
								
							} 
						break;
					case 3:
								if(!myMap.isEmpty()) {
									Set<Long> leastFrequencyList = new HashSet<>();
									
									Map.Entry<Long, Long> entry = myMap.entrySet().iterator().next();
									long leastFreqVal = entry.getKey();
									long leastFre = entry.getValue();
									for(Map.Entry<Long, Long> entrySet : myMap.entrySet()) {
										if(entrySet.getValue() < leastFre) {
											leastFre = entrySet.getValue();
											leastFreqVal = entrySet.getKey();
											leastFrequencyList.clear();
										} else if ( entrySet.getValue() == leastFre) {
											leastFrequencyList.add(leastFreqVal);
											leastFrequencyList.add(entrySet.getKey());
											leastFre = entrySet.getValue();
											leastFreqVal = entrySet.getKey();										
										}
									}
									
									long largestNumber = -1;
									if(!leastFrequencyList.isEmpty()) {
										largestNumber = leastFrequencyList.iterator().next();
										for(Long number : leastFrequencyList) {
											if(largestNumber < number) {
												largestNumber = number;
											}
										}
									} else {
										largestNumber =leastFreqVal;
									}
									
									System.out.println(largestNumber);
								} else {									
									System.out.println(-1);
								}
								
						break;
					case 4:
							if(!myMap.isEmpty()) {
								Set<Long> largestFreqList = new HashSet<>();
								
								Map.Entry<Long, Long> entry = myMap.entrySet().iterator().next();
								long largeFreqVal = entry.getKey();
								long largeFre =  entry.getValue();
								for(Map.Entry<Long, Long> entrySet : myMap.entrySet()) {
									if(entrySet.getValue() > largeFre) {
										largeFre = entrySet.getValue();
										largeFreqVal = entrySet.getKey();
										largestFreqList.clear();
									} else if ( entrySet.getValue() == largeFre) {
										largestFreqList.add(largeFreqVal);
										largestFreqList.add(entrySet.getKey());
										largeFre = entrySet.getValue();
										largeFreqVal = entrySet.getKey();										
									}
								}
								
								long smallestNumber = -1;
								if(!largestFreqList.isEmpty()) {
									smallestNumber = largestFreqList.iterator().next();
									for(Long number : largestFreqList) {
										if(smallestNumber > number) {
											smallestNumber = number;
										}
									}
								} else {
									smallestNumber =largeFreqVal;
								}
								System.out.println(smallestNumber);
								
							} else {
								System.out.println(-1);								
							}
						break;
					default:
						break;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

	}

}
