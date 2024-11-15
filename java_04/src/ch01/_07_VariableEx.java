package ch01;

//AI서비스_웹과정반 @2일차
public class _07_VariableEx {

	public static void main(String[] args) {
		int mathScore = 90;
		int engScore = 70;

		int totalScore = mathScore + engScore; /* (int)90 + (int)70 */
		System.out.println(totalScore); /* 160 */

		double avgScore = totalScore / 2.0; /* (int)160 + (double)2.0 */
		System.out.println(avgScore); /* 80.0 */
	}
}
