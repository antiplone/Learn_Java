package ch02;

//AI서비스_웹과정반 @5일차
public class _11_ForEx {
	/*
     * 반복문 : 조건이 참인동안 반복(while문, for문)
     * 
     * for(초기값; 조건식; 증감식) {  // 반복횟수
     *     수행문1;
     *     수행문2;...
     * }
     */
    
	// 출력 => HappyDay1^^   HappyDay2^^  HappyDay3^^  HappyDay4^^  HappyDay5^^
	//        반복문 종료^^   

	public static void main(String[] args) {
		/**! 전역변수  */
//		int i;
		String strFront = "HappyDay";
		String strRear = "^^";
		for (/* 지역변수 */int i = 1; i <= 5; i++) {
			System.out.print(strFront + i + strRear + "\t");
		}

		System.out.println("\n" + "반복문 종료" + strRear);

		System.out.println("=============================");

		for (int i = 5; i >= 1; i--) {
			System.out.print(strFront + i + strRear + "\t");
		}
	}
}
