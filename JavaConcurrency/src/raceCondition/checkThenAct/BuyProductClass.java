package raceCondition.checkThenAct;

public class BuyProductClass implements Runnable{
	ProductsClass productsClass = null;
	String productName = null;
	public BuyProductClass(ProductsClass productsClass, String productName) {
		super();
		this.productsClass = productsClass;
		this.productName = productName;
	}

	@Override
	public void run() {
		System.out.println(productsClass.buyProduct(productName));
	}

}
