package threadSleep;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable{

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+" Started Executing");
		long startTime = System.currentTimeMillis();
			try {
				Thread.currentThread().sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+" sleep time is "+(+System.currentTimeMillis()-startTime));
		
			
			long startTime1 = System.currentTimeMillis();
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+" sleep time calculated using TimeUnit "
					+(+System.currentTimeMillis()-startTime1));
		
		}
	

}
