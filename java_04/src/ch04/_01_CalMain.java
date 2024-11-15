package ch04;

//AI서비스_웹과정반 @7일차
public class _01_CalMain {

	public static void main(String[] args) {
		double num1 = 8.0;
		double num2 = 4.0;
		_01_Calculator calc = new _01_Calculator();

		System.out.println(calc.add(num1, num2)			+ "\t<--  calc.add(num1, num2)");
		System.out.println(calc.sub(num1, num2)			+ "\t<--  calc.sub(num1, num2)");
		System.out.println(calc.mul(num1, num2)			+ "\t<--  calc.mul(num1, num2)");
		System.out.println(calc.div(num1, num2)			+ "\t<--  calc.div(num1, num2)");
		System.out.println(calc.mod(num1 + 3, num2)		+ "\t<--  calc.mod(num1 + 3, num2)");
		System.out.println(calc.sqr(num1)				+ "\t<--  calc.sqr(num1)");

//		calc.setNumbers(num1, num2);
//		calc.add();
	}
}
