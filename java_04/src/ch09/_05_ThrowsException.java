package ch09;

import java.util.Scanner;

//AI서비스_웹과정반 @13일차
public class _05_ThrowsException {

	static Scanner sc;

	public static void main(String[] args) {
		/*[나이가 0보다 작을때]
		나이를 입력하세요 : -1
		메시지 : 나이는 0보다 큽니다.!!
		정상종료^^
		 */

		/*[나이가 0보다 클때]
		나이을 입력하세요 : 25
		나이 : 25
		정상종료^^
		*/
		int age;
		try {
			age = readAge();
			System.out.println("나이 : " + age);
		}
		catch (Exception e) {
			System.out.println("메시지 : " + e.getMessage());
		}
		finally {
			try {
				sc.close();
			}
			catch (IllegalStateException e) {

				System.out.println("메시지 : " + e.getMessage());
			}
		}

		System.out.println("정상종료^^");
	}

	public static int readAge() throws Exception {
		System.out.print("나이를 입력하세요 : ");

		sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		if (age < 0)
			throw new Exception("나이는 0보다 큽니다.!!");
		
		return age;
	}
}
