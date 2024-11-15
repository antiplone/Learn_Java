package ch07;

public class _04_SamsungTV implements _04_TV {

	@Override
	public void turnOn() {
		System.out.println(_04_TV.BRAND + "TV를 켰답니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println(_04_TV.BRAND + "TV를 껐답니다.");
	}
}
