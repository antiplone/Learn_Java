package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Fan extends _01_03_Electronics {

	public static final String BLADE = "날개";

	private int blades;
	private int windLevel;


	public _01_03_Fan(String name, int price, int power, int blades, int windLevel) {
		super(name, price, power);
		this.blades = blades;
		this.windLevel = windLevel;
	}


	/** [read-only] */
	public int getBlades() {
		return blades;
	}

	/** [read-only] */
	public int getWindLevel() {
		return windLevel;
	}


	@Override
	public void details() {
		super.details();
		System.out.println("날개수: " + blades + BLADE);
		System.out.println("풍량: " + windLevel + _01_03_Electronics.LEVEL);
	}
}
