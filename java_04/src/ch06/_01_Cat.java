package ch06;

//AI서비스_웹과정반 @9일차
/** 자식 클래스<br>
 * 상속 : 자식클래스 extends 부모클래스
 */
public class _01_Cat extends _01_Animal {
	/* ** 멤버 ******
	 * 변수
	 */

	/* 생성자 */
	public _01_Cat(/* default */) {
		System.out.println("<<< _01_Cat 자식클래스 >>>");
	}
	public _01_Cat(String kind, int legs, int weight) {
//		super(kind, legs, weight);
		System.out.println("<<< _01_Cat 자식클래스 >>>");
	}

	/* 메서드 */
	public void cry() {
		System.out.println("야옹~~~~~");
	}
}
