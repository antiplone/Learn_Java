package ch09;

//AI서비스_웹과정반 @13일차
/*
 * [면접]
 * 예외 처리 목적 : 정상종료
 * 
 * try {
 *      // 예외가 발생할 수 있는 코드 부분
 * } catch(처리할 예외타입 e) {
 *    // try 블록안에서 예외가 발생했을 때 예외를 처리하는 부분
 * } finally {
 *      // 항상 수행되는 부분(예외가 발생하지 않더라도) 
 *    // 주로 자원해제를 위한 close() 문장이 온다.
 * }
 * 1. 강제예외발생 : throw new Exception(message);
 * 2. 상위 메서드에게 예외 던지기
 *    throws Exception
 * 3. 예외 처리
 *    catch(던진 Exception e){e.getMaessage()}로 받는다.
 * 
 * catch문이 여러개일때(다중 catch) 부모 Exception이 제일 아래오도록 한다. 실행순서는 위에서부터 실행
 */
public class _01_ArrayException {

	public static void main(String[] args) {
		int[] array = new int[5];
		try {
			for (int i = 0; i < array.length; i++) {
				array[i] = i;
				System.out.println(array[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			/* 블록이 다중으로 연접해있을때 이렇게 하는게 더 잘보인다. */
			System.out.println("=== 예외처리부분 ===");
			System.out.println("예외처리 메시지 : " + e.getMessage());
		}
		finally {
			System.out.println("=== finally 부분 ===");
		}
		/*
		 * try {
		 * } [↓최상위 예외가 맨밑
		 * [catch (... e) {}
		 * catch (Exception e) {}
		 * ... e >= 1]
		 * finally {}
		 * ... all]
		 */

		System.out.println("정상종료...");
	}
}

//0
//1
//2
//3
//4
/* 정상이아니면, 
 * === 예외처리부분 ===
 *예외처리 메시지 : Index 5 out of bounds for length 5
 *=== finally 부분 ===
 */
//정상종료...
