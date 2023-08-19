package itc;

public class PhotoFrame {
	int id;
	String colour;
	String price;
	
	public PhotoFrame() {
		super();
	}

	public PhotoFrame(int id, String colour, String price) {
		super();
		this.id = id;
		this.colour = colour;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
