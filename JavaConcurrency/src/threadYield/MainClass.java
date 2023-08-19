package threadYield;

public class MainClass {

	public static void main(String[] args) {
		//op not getting as per req. yield() method not supported may be
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
	}

}
