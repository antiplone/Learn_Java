package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Fish extends _04_Animal {

	@Override /* 컴파일러에게 매서드 재정의를 알려줌 */
	public void move() {
//		System.out.println("[자식]의 메서드가 호출...");
		System.out.print("물고기가 바다속에서 헤엄치며, ");
		super.move();
	}
	
	public void eating() {
		System.out.println("물고기가 배가 터질때까지 먹는중입니다...");
	}
}
