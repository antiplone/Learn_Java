package ch07;

public class _04_Main {

	public static void main(String[] args) {
		/* 다형성을 적용해 인스턴스 생성 */
		_04_TV tv = new _04_SamsungTV();

		tv.turnOn();
		tv.turnOff();
		tv.turnOff();
		tv.turnOn();
		tv.turnOn();
		tv.turnOff();
		tv.turnOff();
		tv.turnOn();
		tv.turnOn();
	}
}
