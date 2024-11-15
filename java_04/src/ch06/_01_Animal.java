package ch06;

//AI서비스_웹과정반 @9일차
/** 부모 클래스<br><br>
 * [면접]
 * 상속 : 자식클래스 extends 부모클래스 { .... }
 * - extends : 확장하다의 의미
 * - 공통으로 사용하는 멤버변수와 멤버메서드를 부모클래스에서 정의한다.
 * - 부모클래스는 일반적이고 공통적이며, 자식클래스는 구체적이고 유일하다.
 * 
 * - 사용이유 : 부모클래스의 멤버변수와 멤버메서드를 재사용.
 *          중복되는 코드를 줄임으로써 손쉽게 개발, 유지보수 가능
 * - 부모클래스의 멤버를 private으로 선언한 경우, 자식클래스에서 접근할 수 없다.
 *   접근제어자 protected의 경우 자식클래스에서 접근 가능
 * 
 */
public class _01_Animal {
	/* ** 멤버 ******
	 * 변수
	 */
	private String kind;	/* 종류	고양이	멍뭉이 */
	private int legs;		/* 다리	4		4 */
	private int weight;		/* 체중	5		10 */

	/* 생성자 */
	public _01_Animal(/* default */) {
		System.out.println("<<< _01_Animal 부모클래스 >>>");
	}
	public _01_Animal(String kind, int legs, int weight) {
		System.out.println("<<< _01_Animal 부모클래스 >>>");
		this.kind = kind;
		this.legs = legs;
		this.weight = weight;
	}


	/* get·setter */
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/** 클래스 정보 출력 */
	public void printInfo() {
		System.out.println("종류:\t" + kind);			/* getKind() */
		System.out.println("다리:\t" + legs + '개');		/* getLegs() */
		System.out.println("체중:\t" + weight + "kg");	/* getWeight() */
	}
}
