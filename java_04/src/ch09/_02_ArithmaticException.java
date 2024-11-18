package ch09;

import java.util.Scanner;

//AI서비스_웹과정반 @13일차
public class _02_ArithmaticException {

	public static void main(String[] args) {

		System.out.println("=== 두개의 정수값 입력 ===");
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 값 입력 : ");
		int num1 = sc.nextInt();
//		System.out.println();

		System.out.print("두번째 값 입력 : ");
		int num2 = sc.nextInt();
		System.out.println();

		try { /* 예외발생 가능부 */
			System.out.println("몫 : " + (num1 / num2));
			System.out.println("나머지 : " + (num1 % num2));
		}
		catch (ArithmeticException e) { /* 예외처리부 */
			System.out.println("예외처리 메시지 : " + e.getMessage()); /* 간단한 사항 */
			e.printStackTrace(); /* 비정상 상황을 알고싶을때(세부적인 사항) */
		}
		finally { /* 자원(메모리, Stream...) 해제부 */
			System.out.println("<<< finally >>>");
//			sc.close(); /* IO stream */
		}

		System.out.println("<<< 정상종료 >>>");

		sc.close();
	}
}
