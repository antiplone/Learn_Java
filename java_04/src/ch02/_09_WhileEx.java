package ch02;

//AI서비스_웹과정반 @4일차
public class _09_WhileEx {

	public static void main(String[] args) {
//		=== 2단 ===
//		2 * 1 = 2
//		...
//		2 * 9 = 18
//		==========
		int dan = 2;
		int i = 1;
		while (i <= 9) {
			System.out.println(dan + " x " + i + " = " + (dan * i++));
			// i++;
		}
	}
}
