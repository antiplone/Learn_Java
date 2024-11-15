package ch02;

//AI서비스_웹과정반 @5일차
public class _14_ForEx {
	public static void main(String[] args) {
		/*
		 * Test4. for문으로 구구단 작성
		 * 2~9단까지 출력
		 * 
		 * *** 구구단 출력 ***
		 * === 2단 ===
		 * 2 * 1 = 2
		 * ...
		 * 2 * 9 = 18
		 * === 9단 ===
		 * 9 * 1 = 9
		 * ...
		 * 9 * 9 = 81
		 * ==========  마지막에 한번만
		 */
		final int START_DAN = 2; /* 시작단 */
		final int LAST_DAN = 9; /* 마지막단 */
		final int MAX_MULT = 9; /* 최대곱 */
		System.out.println("*** 구구단 출력 ***");
		for (/* 시작단 */int dan = START_DAN; dan <= LAST_DAN/* 마지막단 */; dan++) {
			System.out.println(dan + "단 ==================");
			for (int mult = 1; mult <= MAX_MULT/* 몇까지 곱할지 */; mult++) {
				System.out.println(dan + " x " + mult + " = " + (dan * mult));
			}
		}
		System.out.println("END ==============");


		System.out.println("\n" + "*** 실험적인 출력 ***");
		for (int dan = START_DAN; true;) {
			System.out.println(dan + "단 ==================");
			for (int mult = 1; mult <= MAX_MULT; mult++) {
				System.out.println(dan + " x " + mult + " = " + (dan * mult));
			}

			dan += 1;

			if (dan > LAST_DAN) break; /* End Point... */
		}

		for (;;) {
			break; /* 없으면, 무한반복 */
		}
	}
}
