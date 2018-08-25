package my.rnd.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HackerEarthHighestAverage {

	public static void main(String ...args) {
		Scanner in = new Scanner(System.in);
		try {
			long n = in.nextLong();
			
			long[] aArr = new long[(int) n];
			for(int index = 0; index < n; index ++) {
				aArr[index] = in.nextLong();
			}
			
			long q = in.nextLong();
			//long[] qArr = new long[(int) q];
			
			List<Long> resultList = new LinkedList<>();
			for(int index = 0; index < q; index ++) {
				long k = in.nextLong();
				long result = highestAverage(aArr,k);
				resultList.add(result);
			}
			
			for(Long l : resultList) {
				System.out.println(l);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
	
	public static long highestAverage(long[] aArr, long k) {
		long sum = 0;
		double avg = 1;
		long length = 0;
		try {
				
				if( aArr.length > 0) {
					
					for(int index = 0; index<aArr.length ; ++index) {
						
							sum+=aArr[index];
							avg = sum/(index+1);		
							if(avg<k) {
								++length;
							}
					}
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return length;
	}
	
	
}
