package ch01;

//AI서비스_웹과정반 @2일차
/* *
 * 인코딩(Encoding): 문자에 해당하는 정수값(아스키:ASCII코드값) 출력
 * 디코딩(Decoding): 정수값(아스키코드값)에 해당하는 문자 출력
 * 
 * 인코딩 A -> 65		디코딩 65 -> A
 * B: 66
 * C: 67
 * Z: 90
 * a: 97
 * b: 98
 * z: 122
 */
public class _05_VariableEx {

	public static void main(String[] args) {
		char ch1 = 'A';
		System.out.println(ch1); /* A */
		System.out.println((int)ch1); /* 65 */

		char ch2 = 66;
		System.out.println(ch2); /* B */

		int ch3 = 67;
		System.out.println(ch3); /* 67 */
		System.out.println((char)ch3); /* C */

		char ch4 = 'Z';
		System.out.println(ch4); /* Z */
		System.out.println((int)ch4); /* 90 */

		long ch5 = 128; /* 값이 없다. */
		System.out.println((char)ch5); /* ??? */
	}
}
