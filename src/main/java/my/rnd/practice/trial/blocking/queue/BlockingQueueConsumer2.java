package my.rnd.practice.trial.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer2 implements Runnable {

	private BlockingQueue<String> myQueue;
	
	public BlockingQueueConsumer2(BlockingQueue<String> myQueue) {
		this.myQueue = myQueue;
	}
	
	@Override
	public void run() {
		System.out.println("BlockingQueueConsumer2 started");
		while(true) {
			try {				
				String message = myQueue.take();
				System.out.println("Inside BlockingQueueConsumer2: "+message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
