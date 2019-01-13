package my.rnd.practice.trial;

import java.util.Stack;

public class QueueWithTwoStack {

	private Stack<Object> insert = new Stack<>();
	private Stack<Object> remove = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithTwoStack queueObj = new QueueWithTwoStack();
		
		for(int i = 0; i< 10; ++i) {
			System.out.println(" Insert Order: "+i);
			queueObj.add(i);
		}
		
		System.out.println("FIFO");
		for(int i = 0; i< 10; ++i) {
			System.out.println(queueObj.poll());
		}
	}

	
	public boolean add(Object elem) {
		boolean success = false;
		try {
				if(elem != null) {
					insert.push(elem);
					if(remove.isEmpty()) {
						remove.push(elem);
					} else {
						remove.add(0, elem);
					}
				}
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return success;
	}
	
	public Object poll() {
		Object returnVal = null;
		try {
				if( remove.isEmpty()) {
					System.out.println(" Queue is empty");
				} else {
					returnVal = remove.pop();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
}
