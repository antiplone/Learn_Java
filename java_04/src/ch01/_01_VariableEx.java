package ch01;

//AI서비스_웹과정반 @1일차
/* *
 * 변수를 이용한 출력
 */
public class _01_VariableEx {
	/**
	 * 자바프로그램의 첫시작을 나타내는 main() 메서드 .. 소문자로 시작한다.
	 * 자바가상머신(JVM: Java Virtual Machine)이 프로그램을 시작하기 위해 호출하는 메서드?
	 */
	public static void main(String[] args) {
		/**!
		 * 변수 선언 및 대입 => 자료형 변수명 = 값;
		 * 변수는 소문자로 시작한다.
		 * 해당 자료형에 맞게 대입되어야 한다.
		 */
		System.out.println("*** 변수 ***"); /* 문자열은 쌍따옴표로 감싸준다. */
		System.out.println("변수 : 하나의 값을 저장할 수 있는 메모리 공간");

		System.out.println("*** 나의 정보 ***");
		int favorite = 7;
		System.out.println("좋아하는 숫자 : " + favorite);

		/**!
		 * String:문자열
		 * char:한글자
		 */
		String name = "전영대";
		System.out.println("이름 : " + name);


		String address = "서울시 양천구";
		System.out.println("주소 : " + address);


		String dream = "프로그래머";
		System.out.println("과거꿈 : " + dream);

		dream = "불로소득"; /* 기존의 변수를 쓸려면, String을 빼면된다. */
		System.out.println("현재꿈 : " + dream);


		char bloodType = 'O';
		System.out.println("혈액형 : " + bloodType);

		System.out.println("--------------------------");
		/**! \t = 탭, \n = 줄바꿈 */
		System.out.println("좋아하는 숫자 : " + favorite + "\t이름 : " + name + "\t주소 : " + address + "\t꿈 : " + dream + "\t혈액형 : " + bloodType);
		System.out.println("--------------------------");
		System.out.println("좋아하는 숫자 : " + favorite + "\n이름 : " + name + "\n주소 : " + address + "\n꿈 : " + dream + "\n혈액형 : " + bloodType);
	}
}
