package threadJoin;

import java.util.concurrent.TimeUnit;

public class MainClass {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		
		try {
			//t1.join();
			TimeUnit.SECONDS.timedJoin(t1, 30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Contdown completed Chandrayan 2 launch started");
	}
}
