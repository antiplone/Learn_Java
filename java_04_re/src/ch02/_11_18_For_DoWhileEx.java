package ch02;

import java.util.Scanner;

//AI서비스_웹과정반 @5일차(6일차에 한번수정)
public class _11_18_For_DoWhileEx {

	public static void main(String[] args) {
		/**! for문(단일, 다중), 흐름 제어문(continue, break), do-while문, Scanner클래스 */
		/* 메뉴(do-while), 세기(for) { 흐름제어문 } */
		final int GRADE_LEVEL = 4; /* 초, 중, 고 */
		/* 한개의 반에 수용할수있는 인원설정 ****/
		final int ELEMENTS = 21;
		final int MIDDLES = 25;
		final int HIGHS = 28;
		/*=========================*/
		/* 학교에 몇개의 반이 있는지 설정 ****/
		final int ELEMENTS_NUM = 14;
		final int MIDDLES_NUM = 12;
		final int HIGHS_NUM = 9;
		/*=========================*/
		final int HORIZONTAL_NUM = 6; /* 좌석을 가로로 몇개씩 배치할지 정한다. */

		int gradeGroup = -1;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("(초등:1, 중등:2, 고등:3, 종료:이외의 숫자)중에...");
			System.out.print("어떤학생들의 인원을 알고 싶습니까? ");
			gradeGroup = sc.nextInt();


			int num = 1;
			int fit = 0;
			switch (gradeGroup) {
				case 1: /* 초등학생 */
					for (int i = 1; i <= ELEMENTS_NUM; i++) {
						total += (i * ELEMENTS);
					}
					System.out.println("초등학생들은 최대 " + total + "까지 수용을 할수있습니다.");

					System.out.println("※ 한반의 좌석배치는 이렇습니다 ※");

					fit = (ELEMENTS / HORIZONTAL_NUM) * HORIZONTAL_NUM; /* (가로줄로 몇번 채워지는지) * 가로배치의 수 = 빈자리없이 꽉채웠을때 */
					while (num <= ELEMENTS) {
						if (num < fit) { /* 꽉채운 배치 */
							for (int i = 0; i < HORIZONTAL_NUM; i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
						else { /* 나머지 자리배치 */
							for (int i = 0; i < (ELEMENTS - fit); i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
					}
					break;
				case 2: /* 중학생 */
					for (int i = 1; i <= MIDDLES_NUM; i++) {
						total += (i * MIDDLES);
					}
					System.out.println("중학생들은 최대 " + total + "까지 수용을 할수있습니다.");

					fit = (MIDDLES / HORIZONTAL_NUM) * HORIZONTAL_NUM; /* (가로줄로 몇번 채워지는지) * 가로배치의 수 = 빈자리없이 꽉채웠을때 */
					while (num <= MIDDLES) {
						if (num < fit) { /* 꽉채운 배치 */
							for (int i = 0; i < HORIZONTAL_NUM; i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
						else { /* 나머지 자리배치 */
							for (int i = 0; i < (MIDDLES - fit); i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
					}
					break;
				case 3: /* 고등학생 */
					for (int i = 1; i <= HIGHS_NUM; i++) {
						total += (i * HIGHS);
					}
					System.out.println("고등학생들은 최대 " + total + "까지 수용을 할수있습니다.");

					fit = (HIGHS / HORIZONTAL_NUM) * HORIZONTAL_NUM; /* (가로줄로 몇번 채워지는지) * 가로배치의 수 = 빈자리없이 꽉채웠을때 */
					while (num <= HIGHS) {
						if (num < fit) { /* 꽉채운 배치 */
							for (int i = 0; i < HORIZONTAL_NUM; i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
						else { /* 나머지 자리배치 */
							for (int i = 0; i < (HIGHS - fit); i++) {
								System.out.print("┌┐");
								num += 1;
							}
							System.out.println();
						}
					}
					break;
				default:
					System.out.println("종료...");
			}
		} while(gradeGroup < GRADE_LEVEL);

		sc.close();
	}
}
