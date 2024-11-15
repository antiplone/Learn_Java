package ch02;

//AI서비스_웹과정반 @4일차
public class _07_WhileEx {

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
//		
//		[ 무한루프 ]
//		while(true) {
//			break;  => 해당 반복문을 빠져나간다.
//		}
//		
//		출력 =>	HappyDay1^^   HappyDay2^^  HappyDay3^^  HappyDay4^^  HappyDay5^^
//				반복문 종료^^

		int count = 1;
		String strFront = "HappyDay";
		String strRear = "^^";
		while (count <= 5) {
			System.out.print(strFront + count + strRear + '\t');
			count++;
		}
		
		System.out.println();
		System.out.println("반목문 종료" + strRear);
	}
}
