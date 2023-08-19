package raceCondition;

public class ThreadInterleaving {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
	}

}
