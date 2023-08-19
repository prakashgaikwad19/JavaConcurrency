package itc;

public class ITCMainClass {
	public static void main(String[] args) {
		MaintainPhotoFrame maintainPhotoFrame = new MaintainPhotoFrame();
		
		Thread UI_Thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type = "c-red-p-1000";
				maintainPhotoFrame.updateAvailabilityOnUI(type);
			}
		}, "UI_Thread");		
		UI_Thread.start();
		
		Thread buyerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type = "c-red-p-1000";
				if(maintainPhotoFrame.isAvailable(type)) {
					maintainPhotoFrame.buyStock(type);
				} else {
					maintainPhotoFrame.updateAvailabilityToBuyer(type);
				}
			}
		},"buyerThread");
		buyerThread.start();
		
		Thread sellerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type ="c-red-p-1000";
				PhotoFrame photoFrame = new PhotoFrame(1, "red", "1000");
				maintainPhotoFrame.putStock(photoFrame);
			}
		},"sellerThread");
		sellerThread.start();
	}
}
