package test;

//AI서비스_웹과정반 @18일차[자바시험]
public class _11_Calculator implements _11_Calc {

	@Override
	public int add(int num1, int num2) {
		return (num1 + num2);
	}

	@Override
	public int substract(int num1, int num2) {
		return (num1 - num2);
	}

	@Override
	public int times(int num1, int num2) {
		return (num1 * num2);
	}

	@Override
	public int divide(int num1, int num2) {
		return (num1 / num2);
	}
}
