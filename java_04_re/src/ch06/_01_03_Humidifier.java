package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Humidifier extends _01_03_Electronics {

	public static final String MILI_LITER = "ml";

	private int humidify;

	public _01_03_Humidifier(String name, int price, int power, int humidify) {
		super(name, price, power);
		this.humidify = humidify;
	}

	/** [read-only] */
	public int getHumidify() {
		return humidify;
	}


	@Override
	public void details() {
		super.details();
		System.out.println("가습량: " + humidify + MILI_LITER);
	}
}
