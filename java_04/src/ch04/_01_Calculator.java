package ch04;

//AI서비스_웹과정반 @7일차
/*
 * 메서드(함수) : 클래스의 기능 구현
 * - 입력을 받아 처리 결과를 반환하는 기능
 * 1) 메서드 호출시 메서드명이 일치해야 한다.
 * 2) 매개변수 갯수와 type(자료형)이 일치해야 한다.
 * 3) 리턴타입도 일치해야 한다.
 *    단, 변수명은 달라도 무관
 *    
 * 문법 : public 반환형 메서드명(매개변수1,..) {
 *           return 반환값;   // 처리결과를 리턴하며, 반환형과 일치해야 한다.
 *    }
 *    반환형이 void(비어있다는 뜻)으로 선언된 메서드는 결과값을 반환하지 않는다.
 */
public class _01_Calculator {
//	private double num1;
//	private double num2;
//	
//	public void setNumbers(double num1, double num2) {
//		this.num1 = num1;
//		this.num2 = num2;
//	}
//	
//	public void add() {
//		System.out.println("num1 + num2 = " + (num1 + num2));
//	}
//
//
	/* 멤버메서드 */
	public double add(double num1, double num2) {
		double result = num1 + num2;
		return result; /* return = final is 종단점 */
		/*error! double result = num1 + num2; */
	}

	public double sub(double num1, double num2) {
		double result = num1 - num2;
		return result;
	}

	public double mul(double num1, double num2) {
		double result = num1 * num2;
		return result;
	}

	public double div(double num1, double num2) {
		double result = num1 / num2;
		return result;
	}

	public double mod(double num1, double num2) {
		double result = num1 % num2;
		return result;
	}

	public double sqr(double num) {
		return (num * num);
	}

	public double root(double num) {
		double result = 0.0;
		return result;
	}
}
