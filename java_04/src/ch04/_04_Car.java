package ch04;

//AI서비스_웹과정반 @8일차
public class _04_Car {
	/* 멤버변수 */
	private String brand;
	private String model;
	private int price;
	private String madeIn;

	// 생성자 => new에 의해 호출된다. 클래스이름과 같고, 반환값이 없다. (void 불가)
	// 1-1. 기본생성자(디폴트생성자) => 인스턴스 생성시점에 호출 
	// => 생성자가 하나도 없을때 자바 컴파일러가 자동추가
	// 매개변수 생성자가 존재시 컴파일러가 디폴트생성자를 자동추가하지 않으므로, 개발자가 추가하지 않으면 컴파일 오류 발생
	public _04_Car() { /* 기본(default) 생성자: 생략하면, 자바컴파일러가 기본으로 생성 */
		System.out.println("디폴트 생성자 호출");
	}

	/**! 매개변수 생성자가 있으면, 컴파일러가 기본 생성자를 생성해주지않는다. */
	public _04_Car(String brand, String model, int price, String madeIn) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.madeIn = madeIn;
	}


	/* 멤버메서드 */
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
}
