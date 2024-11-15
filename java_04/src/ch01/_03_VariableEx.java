package ch01;

//AI서비스_웹과정반 @2일차
public class _03_VariableEx {

	public static void main(String[] args) {
		System.out.println("*** 연산 ***" + "\n");
		int num1 = 40;
		int num2 = 20;

		System.out.println("=== 덧셈 ===");
		int addResult = num1 + num2;
		System.out.println("결과: " + addResult);

		System.out.println("=== 뺄셈 ===");
		int selResult = num1 - num2;
		System.out.println("결과: " + selResult);

		System.out.println("=== 곱셈 ===");
		int mulResult = num1 * num2;
		System.out.println("결과: " + mulResult);

		System.out.println("=== 나눗셈 ===");
		int divResult = num1 / num2;
		System.out.println("결과: " + divResult);

		System.out.println("=== 나머지 ===");
		int /* remain */restResult = num1 % num2;
		System.out.println("결과: " + restResult);
	}
}
