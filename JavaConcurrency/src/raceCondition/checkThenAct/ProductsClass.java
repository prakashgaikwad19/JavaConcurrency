package raceCondition.checkThenAct;

import java.util.HashMap;

public class ProductsClass {
	private HashMap<String, Integer> productMap = new HashMap<>();
	
	public ProductsClass() {
		productMap.put("PEN", 1);
		productMap.put("BOOK", 10);
	//	productMap.put("NOTEBOOK", 2);
	}
	
	public synchronized String buyProduct(String key) {
		
		if(productMap.containsKey(key)) {
			Integer quantity  = productMap.get(key);
			if(!quantity.equals(new Integer(0))) {
				productMap.put(key, quantity-1);
				return key+" Order placed "+ Thread.currentThread().getName();
			}
		}
		return key+" not available "+ Thread.currentThread().getName();
				
	}
}
