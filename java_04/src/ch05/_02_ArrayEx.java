package ch05;

//AI서비스_웹과정반 @8일차
public class _02_ArrayEx {

	public static void main(String[] args) {
		String[] drink = new String[5];
		drink[0] = "에이드";
		drink[1] = "아메리카노";
		drink[2] = "라떼";
		drink[3] = "선식";
		drink[4] = "에너지드링크";

		for (int i = 0; i < drink.length; i++) {
			System.out.println("drink[" + i + "] = " + drink[i]);
		}

		System.out.println("-----------------");

		/* 고칼로리 */
		String[] food = {"치느님", "햄버거", "피자", "짜장면", "떡볶이"};
		for (int i = 0; i < food.length; i++) {
			System.out.println("food[" + i + "] = " + food[i]);
		}
	}
}
