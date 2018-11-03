package my.rnd.practice.sync;

public class JavaLockConceptClass {

	public static synchronized void syncClassLevelTest(int threadIdentifier,long sleepMill) {
		
		try {
				System.out.println(" Making class level lock, Thread ID: "+threadIdentifier);
				Thread.sleep(sleepMill);
				System.out.println(" releasing class level lock, Thread ID: "+threadIdentifier);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void syncThreadLevelTest(int threadIdentifier,long sleepMill) {
		
		try {
			System.out.println(" Making object level lock, Thread ID: "+threadIdentifier);
			Thread.sleep(sleepMill);
			System.out.println(" releasing object level lock, Thread ID: "+threadIdentifier);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
