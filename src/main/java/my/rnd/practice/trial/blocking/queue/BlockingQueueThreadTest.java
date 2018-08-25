package my.rnd.practice.trial.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueThreadTest {

	public static void main(String ...args) {
		
		try {
				BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
				BlockingQueueProducer producer = new BlockingQueueProducer(queue);
				new Thread(producer).start();
				
				Thread.sleep(10000);
				BlockingQueueConsumer1 consumer1 = new BlockingQueueConsumer1(queue);
				BlockingQueueConsumer2 consumer2 = new BlockingQueueConsumer2(queue);
				
				new Thread(consumer2).start();
				new Thread(consumer1).start();				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
