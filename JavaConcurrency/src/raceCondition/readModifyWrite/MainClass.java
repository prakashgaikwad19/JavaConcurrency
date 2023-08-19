package raceCondition.readModifyWrite;

public class MainClass {

	public static void main(String[] args) {
		VotingCounterRunnable obj = new VotingCounterRunnable();
		
		Thread state1 = new Thread(obj);
		Thread state2 = new Thread(obj);
		Thread state3 = new Thread(obj);
		Thread state4 = new Thread(obj);
		Thread state5 = new Thread(obj);

		state1.start();
		state2.start();
		state3.start();
		state4.start();
		state5.start();

	}

}
