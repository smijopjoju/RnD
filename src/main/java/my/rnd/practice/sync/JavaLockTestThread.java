package my.rnd.practice.sync;

public class JavaLockTestThread implements Runnable {

	private int identifier = 0;
	
	private int action = 0;
	
	private long sleepInMillSec = 0l;
	
	public JavaLockTestThread(int identifier) {
		this.identifier = identifier;
	}
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}



	public void setSleepInMillSec(long sleepInMillSec) {
		this.sleepInMillSec = sleepInMillSec;
	}

	@Override
	public void run() {
		JavaLockConceptClass coneptClassObj = new JavaLockConceptClass();
		System.out.println(" Started excuting thread: "+identifier);
		
		switch(action) {
			case 1:
					System.out.println(" Try to test class level lock in thread: "+identifier);
					coneptClassObj.syncClassLevelTest(identifier,sleepInMillSec);
					System.out.println(" Class level lock in thread: "+identifier+" is completed");
					break;
			case 2:
					System.out.println(" Try to test object level lock in thread: "+identifier);
					coneptClassObj.syncThreadLevelTest(identifier,sleepInMillSec);
					System.out.println(" Object level lock in thread: "+identifier+" is completed");
					break;
			default:
					break;
		}
	}

}
