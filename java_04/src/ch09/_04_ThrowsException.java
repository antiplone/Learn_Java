package ch09;

import java.util.Scanner;

//AI서비스_웹과정반 @13일차
/* 1. 강제예외발생 : throw new Exception(message);
 * 2. 상위 메서드에게 예외 던지기
 *    throws Exception
 * 3. 예외 처리
 *    catch(던진 Exception e){e.getMaessage()}로 받는다.
 */
public class _04_ThrowsException {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			sc.next();
		}

		String name;
		try {
			name = readName();
			System.out.println("이름 : " + name);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("메시지 : " + e.getMessage());
		} finally {
			try {
				scan.close();
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("메시지 : " + e.getMessage());
			}
		}

		System.out.println("<<< 정상종료 >>>");
	}

	public static String readName() throws Exception { /* 2. 상위 메서드에게 예외 던지기 => throws Exception */
		System.out.print("이름을 입력하세요 : ");

		String name = scan.next();

		if (name.length() < 2) {
			/* 1. 강제예외발생 : throw new Exception(message); */
			throw new Exception("이름은 2글자 이상입니다."); /* Exception 매개변수 생성자 호출 */
		}

		return name;
	}
}
