package threadPriority;

public class MainClass {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		t1.setPriority(9);
		t1.start();
		System.out.println("Priority of main thread "
				+ Thread.currentThread().getPriority());
		
		//still main thread execute first bcoz OS level scheduling 
	}

}
