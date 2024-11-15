package ch02;

//AI서비스_웹과정반 @4일차
public class _10_WhileEx {

	public static void main(String[] args) {
//		[ while 문법 ]
//		1. 초기값;
//		2. while 조건식
//		while(조건식) {
//			수행문1;
//
//			2-1. 초기값;
//			while (조건식) { 2-2. 조건식
//				수행문2;
//				증감식; 2-3. 증감식
//			}
//
//			증감식;  // 3. 증감식
//		}


//		while문으로 구구단 작성
//		2~9단까지 출력
//
//		****************
//		*** 구구단 출력 ***
//		****************
//		=== 2단 ===
//		2 * 1 = 2
//		...
//		2 * 9 = 18
//		=== 9단 ===
//		9 * 1 = 9
//		...
//		9 * 9 = 81
//		==========  마지막에 한번만

		System.out.println("****************");
		System.out.println("*** 구구단 출력 ***");
		System.out.println("****************");
		int dan = 2;
		while (dan <= 9) {
			System.out.println("==== " + dan + "단 ====");

			int mult = 1;
			while (mult <= 9) {
				System.out.println(dan + " x " + mult + " = " + (dan * mult++));
				// mult++;
			}

			dan += 1;
		}
	}
}
