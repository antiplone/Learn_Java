package ch06;

//AI서비스_웹과정반 @9일차
/** 자식 클래스<br>
 * 상속 : 자식클래스 extends 부모클래스
 */
public class _01_Dog extends _01_Animal {
	/* ** 멤버 ******
	 * 변수
	 */

	/* 생성자 */
	public _01_Dog(/* default */) {
		System.out.println("<<< _01_Dog 자식클래스 >>>");
	}
	public _01_Dog(String kind, int legs, int weight) {
//		super(kind, legs, weight);
		System.out.println("<<< _01_Dog 자식클래스 >>>");
	}

	/* 메서드 */
	public void bark() {
		System.out.println("멍멍~~~~~");
	}
}
