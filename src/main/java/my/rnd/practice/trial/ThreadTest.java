package my.rnd.practice.trial;

public class ThreadTest extends Thread{

	public static void main(String[] args) {
		new ThreadTest().start();
	}
	
	public void run() {
		System.out.println("Test");
	}
	
	public void run(String s) {
		System.out.println("Build");
	}

}
