package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Electronics extends _01_03_Product {

	public static final String LEVEL = "단계";
	public static final char WATT = 'w';

	private int power;


	public _01_03_Electronics(String name, int price, int power) {
		super(name, price);
		this.power = power;
	}


	/** [read-only] */
	public int getPower() {
		return power;
	}


	@Override
	public void details() {
		super.details();
		System.out.println("소비전력:\t" + power + WATT);
	}
}
