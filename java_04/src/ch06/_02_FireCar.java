package ch06;

//AI서비스_웹과정반 @9일차
public class _02_FireCar extends _02_Car {
	/* ** 멤버 ******
	 * 변수
	 */

	/* 생성자 */
	public _02_FireCar(/* default */) {
		System.out.println("<<< _02_FireCar 자식클래스 >>>");
	}

	/* 메서드 */
	public void water() {
		System.out.println("물을 뿌리다.~~");
	}
}
