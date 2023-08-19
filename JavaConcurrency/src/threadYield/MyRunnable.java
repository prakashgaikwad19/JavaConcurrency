package threadYield;

public class MyRunnable implements Runnable{

	@Override
	public void run() {

		System.out.println("Started Executing Run method of Thread :"
									+Thread.currentThread().getName());
		for(int i=0;i<=10;i++) {
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"  "+i);

			if(i==5) {
				Thread.yield();
			}
		}
		}
	

}
