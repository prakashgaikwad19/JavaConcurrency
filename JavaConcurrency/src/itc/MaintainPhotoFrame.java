package itc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintainPhotoFrame {
	Map<String, List<PhotoFrame>> availableFrames = 
			new HashMap<String, List<PhotoFrame>>();
	
	public boolean isAvailable(String type) {
		synchronized (availableFrames) {
			if(!availableFrames.isEmpty() && availableFrames.containsKey(type)) {
				System.out.println(Thread.currentThread().getName()
						+" :isAvailable:: "
						+" This Photo Frame is available in stocks");
				return true;
			} else {
				System.out.println(Thread.currentThread().getName()
						+" :isAvailable:: "
						+" This Photo Frame is not available in stocks");
				return false;			
				}
		}
	}
	
	public void buyStock(String type) {
		synchronized (availableFrames) {
			if(!availableFrames.isEmpty() && availableFrames.containsKey(type)) {
				List<PhotoFrame> photoFrameList = availableFrames.remove(type);
				
				PhotoFrame photoFrame = photoFrameList.remove(0);
				availableFrames.put(type, photoFrameList);
				System.out.println(Thread.currentThread().getName()
						+" :buyStock:: "
						+" PhotoFrame "+ photoFrame.id + " will be delivered");
			} else {
				System.out.println(Thread.currentThread().getName()
						+" :buyStock:: "
						+ " This Photo Frame is out of stock");
			}
		}
	}
	
	public void updateAvailabilityToBuyer(String type) {
		synchronized (availableFrames) {
			while(availableFrames.isEmpty() && !availableFrames.containsKey(type)) {
				try {
					availableFrames.wait();
				} catch (Exception e) {
					System.out.println("EXCEPTION MESSAGE......."+e.getMessage());
				}
				//Send email notification that product is available to the buyers
				System.out.println(Thread.currentThread().getName()
						+" :updateAvailabilityToBuyer:: "
						+" Update Buyer This photo Frame is now available in stock");
			}
		}
	}
	
	public void updateAvailabilityOnUI(String type) {
		synchronized (availableFrames) {
			while(availableFrames.isEmpty() && !availableFrames.containsKey(type)) {
				try {
					availableFrames.wait();
				} catch (Exception e) {
					System.out.println("EXCEPTION MESSAGE......."+e.getMessage());
				}
				//Send email notification that product is available to the buyers
				System.out.println(Thread.currentThread().getName()
						+" :updateAvailabilityOnUI:: "
						+" Update on UI that This photo Frame is now available in stock");
			}
		}
	}
	
	public void putStock(PhotoFrame photoFrame) {
		synchronized (availableFrames) {
			String type = "c-"+photoFrame.colour+"-p-"+photoFrame.price;
			if(availableFrames.containsKey(type)) {
				List<PhotoFrame> photoFrameList = availableFrames.get(type);
				photoFrameList.add(photoFrame);
				availableFrames.put(type, photoFrameList);
			} else {
				List<PhotoFrame> photoFrameList = new ArrayList<PhotoFrame>();
				photoFrameList.add(photoFrame);
				availableFrames.put(type, photoFrameList);
			}
			availableFrames.notifyAll();
			System.out.println(Thread.currentThread().getName()
					+" :putStock:: "
					+ " Stock added now photo frame is available, sending notification "
					+ "to all");
		}
	}
}
