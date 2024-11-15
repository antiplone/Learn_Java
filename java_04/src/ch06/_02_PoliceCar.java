package ch06;

//AI서비스_웹과정반 @9일차
public class _02_PoliceCar extends _02_Car {
	/* ** 멤버 ******
	 * 변수
	 */

	/* 생성자 */
	public _02_PoliceCar(/* default */) {
		System.out.println("<<< _02_PoliceCar 자식클래스 >>>");
	}

	/* 메서드 */
	public void siren() {
		System.out.println("사이렌을 울리다.~~");
	}
}
