package my.rnd.practice.sync;

public class JavaLockTest {

	public static void main(String[] args) {
		
		JavaLockTestThread thread1 = new JavaLockTestThread(1);
		JavaLockTestThread thread2 = new JavaLockTestThread(2);

		thread1.setAction(2);//Try by changing the action 1 for class level lock, 2 for object level lock
		thread1.setSleepInMillSec(2500);
		thread2.setAction(1);//Try by changing the action
		thread2.setSleepInMillSec(2000);
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		
		t1.start();
		t2.start();
	}

}
