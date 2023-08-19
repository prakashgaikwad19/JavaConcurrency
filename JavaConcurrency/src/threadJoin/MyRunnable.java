package threadJoin;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Chandrayan 2 count down started......");
		for(int i=0;i<=10;i++) {
			System.out.println(10-i);
		}
	}

}
