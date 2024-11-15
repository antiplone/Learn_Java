package ch02;

import java.util.Scanner;

//AI서비스_웹과정반 @5일차
public class _18_DoWhileEx {

	public static void main(String[] args) {
		// 클래스명 변수 = new 클래스명();
		Scanner sc = new Scanner(System.in); /* 콘솔에서 값을 입력받는 클래스 */

		int month = 0;
		System.out.print("월을 입력하세요. : ");

		do {
			month = sc.nextInt(); /* 월을 입력받는다. */
			System.out.println();

			if (month >= 1 && month <= 12) break;

			System.out.print("잘못된 월입니다. (1~12월 입력), 월을 다시 입력받으세요. : ");
		} while(month < 1 || month > 12);

		System.out.println("입력하신 월 : " + month + "월 입니다.");


		final int TODAY_MONTH = 11;
		boolean isQuit = true;
		do {
			System.out.print("몇월인가요? ");
			month = sc.nextInt(); /* 월을 입력받는다. */

			System.out.println();

			if (month >= 1 && month <= 12) { /* 1 ~ 12월의 범위에서 입력받아야한다. */
				System.out.println(month + "월이네요.");
				isQuit = false; /* 종료값을 넘긴다. */

				if (month == TODAY_MONTH) /* 이번달일때 출력 */
					System.out.println("이번달이군요!");
			}
			else {
				System.out.println("잘못된 월입니다. (1 ~ 12월)");
				System.out.print("월을 다시 입력받으세요. : ");
				month = sc.nextInt();
			}
		} while(isQuit);

		System.out.println("종료되었습니다...");

		sc.close(); /* Stream close... */
	}
}
