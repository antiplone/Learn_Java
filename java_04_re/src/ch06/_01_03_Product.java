package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Product {

	private String name;
	private int price;

	private static int total;

	public _01_03_Product() {
		this.total += 1;
	}

	public _01_03_Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	/** [read-only] */
	public static int getTotal() {
		return total;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public void details() {
//		System.out.println("상품명:\t" + name);
		System.out.println("<<< " + name + " >>>");
		System.out.println("가격:\t" + price);
	}
}
