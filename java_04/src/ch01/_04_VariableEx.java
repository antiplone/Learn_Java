package ch01;

//AI서비스_웹과정반 @2일차
/* *
 * 소 -> 대 : 자동형변환(묵시적~) => 생략가능 => 자료손실 발생X
 * 		소괄호, 중괄호, 대괄호에서 소괄호는 괄호라고 부르기도 하듯이 묵시적은 그런식이다.
 * 대 -> 소 : 강제 형변환(명시적~) => 생략불가 => 자료손실이 발생...
 */
public class _04_VariableEx {

	public static void main(String[] args) {
		System.out.println("*** 묵시적 형변환 ***");
		byte bNum = 10;
		int iNum = bNum; /* 자료의 크기만 바뀐다. */

		System.out.println(bNum);
		System.out.println(iNum);

		int iNum2 = 20;
		float fNum = iNum2; /* 20.0 : '가수부'가 추가된다. */

		System.out.println(iNum);
		System.out.println(fNum);

		double dNum;
		dNum = fNum + iNum; /* 20.0 + 10 */
		System.out.println(dNum); /* 30.0 */

		System.out.println();

		double a= 1/3; /* int / int = int => 결과 0.3333333을 int로 바꾸니 => double 0.0 */
		System.out.println(a);


		System.out.println("*** 명시적 형변환 ***");
		double dNum1 = 1.2;
		float fNum2 = 0.9F;

		int iNum3 = (int)dNum1 + (int)fNum2; /* 1 + 0 */
		int iNum4 = (int) (dNum1 + fNum2); /* 1.2 + 0.9 */
		System.out.println(iNum3); /* 1 */
		System.out.println(iNum4); /* 2 */
	}
}
