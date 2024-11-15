package ch07;

//AI서비스_웹과정반 @11일차
public /* concrete <> */abstract class _01_Computer {
	/*일반메서드* *구현*/
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

	/*추상메서드* *구현*/
	public abstract void display();
	public abstract void typing();
}
