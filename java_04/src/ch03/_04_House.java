package ch03;

//AI서비스_웹과정반 @7일차
public class _04_House {
	/* 클래스[멤버변수(속성)·메서드(기능, 동작)]
	 * 객체 = 클래스를 기반으로 만들어진 힙메모리 공간
	 */

	/* 멤버변수 */
	final double PLANE = 3.3058;

	private String address = "";	// 강남구
	private int price;				// 가격
	private String kind;			// 아파트
	private int size; 				// 평수 ↔ 면적 = 1평:3.3058㎡

	/* ..메서드 */
	/* setter(set + 멤버변수: 첫글자 대문자) */
	public void setAddress(String address/* 매개변수 */) {
		/* this.(members) */
		this.address = address;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * 면적구하는 리턴함수로 만들어보자
	 * ^^반환값에 돌려줄 데이터형을 잘라서 붙여넣는방법
	 * 라면박스 예제 생각해보자
	 */
	public void/* 반환값이 없다.(간섭하지마, 개무시) */ printInfo(char type/* 매개변수 전달해보자 */) {
		System.out.println("주소: " + this.address);
		System.out.println("가격: " + this.price);
		System.out.println("아파트: " + this.kind);

		float plane = (float)(this.size * PLANE);
		if (type == '평')
			System.out.println("평수: " + this.size);
		else if (type == '면')
			System.out.println("면적: " + plane);
		else {
			System.out.println("평수: " + this.size);
			System.out.println("면적: " + plane);
		}
	}
}
