package ch07;

public class _03_Main {

	public static void main(String[] args) {
		_03_Calc calc = new _03_CompleteCalc();
		int num1 = 2;
		int num2 = 4;

		System.out.println(calc.add(num1, num2) + "\t<-- calc.add(num1, num2):덧셈");
		System.out.println(calc.substract(num1, num2) + "\t<-- calc.substract(num1, num2):뺄셈");
		System.out.println(calc.times(num1, num2) + "\t<-- calc.times(num1, num2):곱셈");
		System.out.println(calc.divide(num1, num2/* 0이면, 에러코드 */) + "\t<-- calc.divide(num1, num2):나눗셈");
	}
}
