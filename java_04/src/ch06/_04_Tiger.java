package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Tiger extends _04_Animal {

	@Override /* 컴파일러에게 매서드 재정의를 알려줌 */
	public void move() {
//		System.out.println("[자식]의 메서드가 호출...");
		System.out.print("호랑이가 네발로 어슬렁어슬렁, ");
		super.move();
	}

	public void hunting() {
		System.out.println("호랑이가 사냥중입니다...");
	}
}
