package ch01;

//AI서비스_웹과정반 @2일차
/* *
 * 상수(Constant):	프로그램이 실행되는 동안, 값이 변하지 않는 수 또는 변경불가능한 수
 * 					주로 대문자 사용(!변수는 소문자)
 * 					만약 값을 변경해야 할 경우, 상수를 선언한 곳의 초기값만 변경하면 된다.
 * 
 * 문법: final [자료형] [변수명];	예) final double PI = 3.14;
 * 		1) *변수(상수): 변수의 값 변경불가
 * 		2) 메서드: 재정의불가
 * 		3) 클래스: 상속불가
 */
public class _06_VariableEx {

	public static void main(String[] args) {
		/* 수정은 여기서 */
		final int MAX_NUM = 100;
		final int MIN_NUM = 0; /* 여기서 초기화를 안했을때 */

//		MIN_NUM = 0; /* 사용하기전에 초기화만 하면됨 */

		System.out.println("MAX: " + MAX_NUM);
		System.out.println("MIN: " + MIN_NUM);

//		MAX_NUM = 1000; /* 상수는 값을 변경할 수 없음 */

		String name = "홍길동";
		System.out.println("개명전: " + name);

		name = "소지섭";
		System.out.println("개명후: " + name);

		System.out.println("-------------------------");
		/**! 상수로 내정보 출력(MY_NAME, MY_AGE, MY_ASSET, MY_DREAM) */
		final String MY_NAME = "전영대";
		final int MY_AGE = 34;
		final String MY_ASSET = "애매함";
		final String MY_EMAIL = "antiplone@gmail.com";

		System.out.println(MY_NAME);
		System.out.println(MY_AGE);
		System.out.println(MY_ASSET);
		System.out.println(MY_EMAIL);
	}
}
