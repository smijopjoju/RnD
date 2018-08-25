package my.rnd.practice.trial.blocking.queue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable{

	private BlockingQueue<String> myQueue;
	
	public BlockingQueueProducer(BlockingQueue<String> myQueue) {
		this.myQueue = myQueue;
	}
	
	@Override
	public void run() {
		
		for(int index=0;index<100;index++) {
			try {
				
				System.out.println("inside BlockingQueueProducer Initiating message put: "+new Date().toString());
				myQueue.put("Message "+index);
				System.out.println(" inside BlockingQueueProducer message generated: "+"Message "+index+" "+new Date().toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
