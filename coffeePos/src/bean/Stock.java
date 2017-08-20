package bean;

public class Stock {
	private int wondu;
	private int milk;
	private int sirup;
	private int berry;
	private int mango;
	private int green;
	private int black;
	private int choco;
	
	public Stock (){}
	
	
	public int getWondu() {
		return wondu;
	}
	public void setWondu(int wondu) {
		this.wondu = wondu;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getSirup() {
		return sirup;
	}
	public void setSirup(int sirup) {
		this.sirup = sirup;
	}
	public int getBerry() {
		return berry;
	}
	public void setBerry(int berry) {
		this.berry = berry;
	}
	public int getMango() {
		return mango;
	}
	public void setMango(int mango) {
		this.mango = mango;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public int getChoco() {
		return choco;
	}
	public void setChoco(int choco) {
		this.choco = choco;
	}


	@Override
	public String toString() {
		return String.format("Stock [wondu=%s, milk=%s, sirup=%s, berry=%s, mango=%s, green=%s, black=%s, choco=%s]",
				wondu, milk, sirup, berry, mango, green, black, choco);
	}
	
	
	
}


