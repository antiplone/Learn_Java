package test;

//AI서비스_웹과정반 @18일차[자바시험]
public class _11_Main {

	public static void main(String[] args) {
		int num1 = 4;
		int num2 = 8;
		_11_Calc calc = new _11_Calculator();

		System.out.println(calc.add(num1, num2) + "\t<--  _11_Calculator.add(num1, num2)");
		System.out.println(calc.substract(num1, num2) + "\t<--  _11_Calculator.substract(num1, num2)");
		System.out.println(calc.times(num1, num2) + "\t<--  _11_Calculator.times(num1, num2)");
		System.out.println(calc.divide(num1, num2) + "\t<--  _11_Calculator.divide(num1, num2)");
	}
}
