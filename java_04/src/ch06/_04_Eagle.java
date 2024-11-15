package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Eagle extends _04_Animal {

	@Override /* 컴파일러에게 매서드 재정의를 알려줌 */
	public void move() {
//		System.out.println("[자식]의 메서드가 호출...");
		System.out.print("독수리가 날개로 활공하며, ");
		super.move();
	}

	public void flying() {
		System.out.println("독수리가 날개를 펴고 하늘을 납니다.");
	}
}
