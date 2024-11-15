package ch04;

//AI서비스_웹과정반 @8일차
public class _04_05_Car {
	public static final int COLOR_BLACK		= 0x000000; /* RGB */
	public static final int COLOR_WHITE		= 0xffffff;
	public static final int COLOR_RED		= 0xff0000;
	public static final int COLOR_BLUE		= 0x0000ff;
	public static final int COLOR_YELLOW	= 0xffff00;

	private static int serial;
	private String productID;
	private String model;
	private int color;
	private int price;

	public _04_05_Car() {/* default */}
	public _04_05_Car(String model, int color, int price) {
		this.model = model;
		productID = Character.toUpperCase(model.charAt(0)) + "00" + serial++;
		this.color = color;
		this.price = price;
	}
	public _04_05_Car(String model, int color) {
		this.model = model;
		this.color = color;
		productID = Character.toUpperCase(model.charAt(0)) + "00" + serial++;
	}

	/** [read-only] */
	public static int getSerial() {
		return serial;
	}

	/** [read-only] */
	public String getProductID() {
		return productID;
	}

	/** [read-only] */
	public String getModel() {
		return model;
	}

	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public void showDetails() {
		System.out.println("제품ID :\t" + productID);
		System.out.println("모델명 :\t" + model);
		
		String str = "";
		switch (color) {
		case _04_05_Car.COLOR_BLACK:
			str = "검정";
			break;

		case _04_05_Car.COLOR_WHITE:
			str = "흰색";
			break;
			
		case _04_05_Car.COLOR_RED:
			str = "빨강";
			break;
			
		case _04_05_Car.COLOR_BLUE:
			str = "파랑";
			break;
	
		case _04_05_Car.COLOR_YELLOW:
			str = "노랑";
			break;
			
		default:
			break;
		}
		System.out.println("색상 :\t" + str);
		System.out.println("가격 :\t" + price);
	}
}
