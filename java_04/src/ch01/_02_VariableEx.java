package ch01;

//AI서비스_웹과정반 @1일차
/* *
 * 1. 기본자료형(Primitive Type) : 실제 '값'이 저장되는 공간
 * 		- 정수형 :	byte(1byte:바이트), short(2byte), int(4byte): 기본, long(8byte)
 * 		- 실수형 :	float(4byte), double(8byte): 기본
 * 		- 문자형 :	char(2byte)
 * 		- 부울형 :	boolean(1byte) -> true / false [C에서는 1, 0이 비교가 되지만, 자바는 형변환 필요]
 * 
 * 2. 참조형(Reference Type) : 실제 객체를 가리키는 주소값이 저장되는 공간 - 참조변수의 자료형
 * 		- 클래스, 인터페이스, 배열
 * 
 * 3. 문자열 : String 클래스
 */
public class _02_VariableEx {/* '{}' level을 맞춰라 */

	public static void main(String[] args) {
		System.out.println("=== 정수형 변수 ===");
		int num1 = 10; /* 선언과 동시에 초기화 */
		long num2 = 12345678900L; /* long형은 숫자뒤에 L이나 l을 붙인다. int와 구분 */
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);

		System.out.println("=== 실수형 변수 ===");
		float fnum1 = 3.14f; // float형은 숫자뒤에 F나 f를 붙인다. double형과 구분
		double dnum1 = 5.5 /* or 5.5d */; /* 기본형이라 안붙여도 된다. */
		System.out.println("fnum1: " + fnum1);
		System.out.println("dnum1: " + dnum1);

		System.out.println("=== 문자형 변수 ===");
		String str = "저녕대"; /* String은 클래스 타입이므로 반드시 대문자로 시작. 초기화시 쌍따옴표를 사용하며, 공백이 없어도 된다. String str = ""; */
		System.out.println("str: " + str);

		char grade = 'A'; /* '' 값이 비어있을순 없다. */
		System.out.println(grade + "학점");

		System.out.println("=== 부울형 변수 ===");
		boolean isMarried = true; /* 참, 1이라는 값을 가지고 있음 */
		boolean isWorker = false; /* 거짓, 0이라는 값을 가지고 있음 */

		System.out.println("결혼했니? " + isMarried);
		System.out.println("직장이있니? " + isWorker);
	}
}
//=== 정수형 변수 ===
//num1: 10
//num2: 12345678900
//=== 실수형 변수 ===
//fnum1: 3.14
//dnum1: 5.5
//=== 문자형 변수 ===
//str: 저녕대
//A학점
//=== 부울형 변수 ===
//결혼했니? true
//직장이있니? false
