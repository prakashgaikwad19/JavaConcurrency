package raceCondition.checkThenAct;

public class MainClass {

	public static void main(String[] args) {
		ProductsClass productsClass = new ProductsClass();
		
		Thread t1 = new Thread(new BuyProductClass(productsClass, "PEN"));
		Thread t2 = new Thread(new BuyProductClass(productsClass, "PEN"));

		t1.start();
		
		t2.start();
	}

}
