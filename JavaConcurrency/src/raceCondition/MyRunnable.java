package raceCondition;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		MyRunnable.print();
	}
	
	public static synchronized void print() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	} 

}
