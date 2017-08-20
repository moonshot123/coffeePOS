package bean;

public class Coffee extends Object{
	private String name;
	private String size;
	private String shot;
	private String temp;
	private int price;
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getShot() {
		return shot;
	}
	public void setShot(String shot) {
		this.shot = shot;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Coffee [name=" + name + ", size=" + size + ", shot=" + shot + ", temp=" + temp + ", price=" + price
				+ "]";
	}
	
	
}
