package ch02;

//AI서비스_웹과정반 @5일차
public class _13_ForEx {

	public static void main(String[] args) {
		/*
		 * for문을 이용해 콘솔에서 단을 입력받아 구구단 출력
		 * 단을 입력하세요 : 2
		 * === 2단 ===
		 * 2 * 1 = 2..
		 * 2 * 9 = 18
		 * =========== 
		 */
		final int MAX_MULT = 9;
		int dan = 2;
		System.out.println("=== " + dan + "단 ===");
		System.out.println("=== 일반for문 ===");
		for (int i = 1; i <= MAX_MULT; i++) {
			System.out.println(dan + " x " + i);
		}
		System.out.println("=== 증감항을 사용하지않은 for문 ===");
		for (int i = 1; i <= MAX_MULT;/* 생략가능 */) {
			System.out.println(dan + " x " + i++);
		}
		System.out.println("=== 증감항과 조건문을 사용하지않은 for문 ===");
		for (int i = 1; true/* 조건문을 무한반복 */;/* 생략 */) {
			if (i <= MAX_MULT)
				System.out.println(dan + " x " + i++);
			else break; /* 무한반복일때 반복을 끝내는 처리를 해야한다. */
		}
	}
}
