package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Human extends _04_Animal {

	@Override /* 컴파일러에게 매서드 재정의를 알려줌 */
	public void move() {
		System.out.println("[자식 ↓]의 메서드가 호출...");
		System.out.print("사람이 두발로 걸어서, ");
		super.move();
	}
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
