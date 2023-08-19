package raceCondition.readModifyWrite;

public class VotingCounterRunnable implements Runnable{
	private int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()
					+" BEFORE INCREMENTING COUNTER "+ getCounter());
			
			setCounter(getCounter()+1);
			
			System.out.println(Thread.currentThread().getName()
					+" AFTER INCREMENTING COUNTER "+ getCounter());
		}
		
	}
	
}
