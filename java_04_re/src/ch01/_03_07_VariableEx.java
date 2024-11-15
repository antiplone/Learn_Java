package ch01;

//AI서비스_웹과정반 @2일차
public class _03_07_VariableEx {

	public static void main(String[] args) {
		/**! 묵시적·명시적 형변환, 인·디코딩, 상수, 산술연산자 */
		/* 넓이·높이의 표시라벨? */
		final char DISPLAY_WIDTH = 'W'; /* String과 다르게 ''값이 비어서는 안된다. */
		final char DISPLAY_HEIGHT = 'H';

		final int SCREEN_WIDTH = 1920; /* 화면넓이 */
		final int SCREEN_HEIGHT = 1080; /* 화면높이 */

		/* 정수형으로 계산된 결과가, 묵시적으로 실수형 double으로 변환된다. */
		double half_width = 1920 / 2; /* 넓이의 중앙 */
		/* 1080(정수형) / 2.0f(실수형:float)의 계산이 double로 묵시적으로 변환 */
		double half_height = 1080 / 2.0f; /* 높이의 중앙 */

		System.out.println("넓이:" + DISPLAY_WIDTH + " = " + SCREEN_WIDTH);
		System.out.println("높이:" + DISPLAY_HEIGHT + " = " + SCREEN_HEIGHT);

		/* DISPLAY_WIDTH와 DISPLAY_HEIGHT를 인코딩후 다시 디코딩한다. */
		int encodeW = (int)DISPLAY_WIDTH;
		System.out.print("W -- 인코딩 -> " + encodeW);
		System.out.println(" -- 디코딩 -> " + (char)encodeW);
		int encodeH = (int)DISPLAY_HEIGHT;
		System.out.print("H -- 인코딩 -> " + encodeH);
		System.out.println(" -- 디코딩 -> " + (char)encodeH);

		/* float형을 명시적으로 정수형인 int로 변환해서 출력한다. */
		System.out.println("화면넓이의 중앙 = " + (int)half_width);
		System.out.println("화면높이의 중앙 = " + (int)half_height);

		/* 결과값이 큰자료형인 half_width:double로 변환이 되어서 h_width에 대입 */
		double h_width = SCREEN_WIDTH - half_width;
		System.out.println("h_width: " + h_width);

		/* 화면의 넓이(SCREEN_WIDTH)를 넓이의 반으로 나눴을때의 나머지 */
		int result = (int)(SCREEN_WIDTH % half_width); /* 결과값을 int형으로 변환 */
		System.out.println("화면의 넓이 % 넓이의 반 = " + result);
	}
}
