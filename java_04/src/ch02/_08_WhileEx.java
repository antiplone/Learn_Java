package ch02;

//AI서비스_웹과정반 @4일차
public class _08_WhileEx {

	public static void main(String[] args) {
//		반복문 :	조건이 참인 동안 계속해서 반복수행(while문, for문)
//				1.초기값 -> 2.조건식 -> 3.증감식
//		      
//		[ while 문법 ]
//		1. 초기값;
//		while(조건식) { // 2. 조건식
//			수행문1;
//			증감식;  // 3. 증감식
//		}
//		수행문2;
		System.out.println("=== 1. 1~10까지 출력 ===");
		int i = 1;
		while (i <= 10) {
			if (i != 10)
				System.out.print(i + ", ");
			else System.out.print(i);
			i++;
		}


		System.out.println();
		System.out.println("=== 2. 1~10까지 합계 출력 ===");
		int j = 1;
		int sum1 = 0;
		while (j <= 10) {
			sum1 += j++;
//			j++;
		}
		System.out.println("sum1 : " + sum1);


		System.out.println("=== 3. 1~10까지 합계 과정 출력 ===");
		System.out.println("k  sum2");

		int k = 1;
		int sum2 = 0;
		while (k <= 10) {
			System.out.println(k + " + " + sum2 + " = " + (sum2 += k));
//			System.out.print(k + " + " + sum2 + " = ");
//			sum2 += k;
//			System.out.println(sum2);
			k++;
		}
	}
}
