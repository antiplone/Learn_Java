package ch02;

//AI서비스_웹과정반 @5일차
public class _12_ForEx {
	/*
     * 반복문 : 조건이 참인동안 반복(while문, for문)
     * 
     * for(초기값; 조건식; 증감식) {  // 반복횟수
     *     수행문1;
     *     수행문2;...
     * }
     */

    /* [ 1~10까지의 합 ]
     * num=1, sum=1;
     * num=2, sum=3..
     * num=10, sum=55
     * 1~10까지의 합 : 55 => 1번 출력
     */

	public static void main(String[] args) {
		System.out.println("[ 1~10까지의 합 ]");

		final int MAX_NUM = 10;
		int sum = 0;
		for (int i = 1; i <= MAX_NUM; i++) {
			sum += i;
			System.out.println("num = " + i + ", sum = " + sum);
		}
		System.out.println("1~10까지의 합 : " + sum);
	}
}
