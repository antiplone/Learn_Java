package ch02;

//AI서비스_웹과정반 @3일차
public class _01_IfEx {

	public static void main(String[] args) {
		/**! [if - else if - else문] */
//		if(조건식1) {			/* 조건식1이 참인 경우 수행문1을 실행 */
//		   수행문1;
//		}
//		else if(조건식2) {	/* 조건식2이 참인 경우 수행문2을 실행 */
//		   수행문2;
//		}   
//		else if(조건식3) {	/* 조건식3이 참인 경우 수행문3을 실행 */
//		   수행문3;
//		}   
//		else {				/* 위의 조건이 모두 해당되지 않는 경우 수행문4를 실행 */
//		   수행문4;
//		}
//
//		수행문5;   // 무조건 실행

		/**! 8살이상이면, "학교에 다닙니다." 출력, 그렇지 않으면, "학교에 다니지 않습니다." 출력, "종료" 출력  */
		int age = 5;
//		if (age <= 8) {
//			System.out.println("학교에 다닙니다.");
//		}
//		else {
//			System.out.println("학교에 다니지 않습니다.");
//		}
		if (age >= 8) {
			System.out.println("학교에 다니지 않습니다.");
		}
		else {
			System.out.println("학교에 다닙니다.");
		}

		System.out.println("종료");

		System.out.println("<<< 3항 연산자 >>>");
		/* 결과 = 조건식 ? 참 : 거짓; */

		String result = (age >= 8) ? "학교에 다닙니다." : "학교에 다니지않습니다.";
		System.out.println(result);
	}
}
