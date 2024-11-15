package ch02;

//AI서비스_웹과정반 @3일차
public class _02_IfEx {

	public static void main(String[] args) {
		/**! num이 양수/음수/0인지 판단 */
//		int num = -5;
		int num = 0;
//		int num = 7;
		String result;

		if (num < 0) {
			System.out.println("결과 : " + num + "(은)는 음수");
		}
		else if (num > 0) {
			System.out.println("결과 : " + num + "(은)는 양수");
		}
		else { /* num is 0 */
			System.out.println("결과 : " + num + "은 0");
		}

		System.out.println("----------------------");

		if (num < 0) {
			result = "음수";
		}
		else if (num > 0) {
			result = "양수";
		}
		else { /* num is 0 */
			result = "0";
		}
		System.out.println("결과 : " + num + "(은)는 " + result);
		System.out.println("종료");
	}
}
