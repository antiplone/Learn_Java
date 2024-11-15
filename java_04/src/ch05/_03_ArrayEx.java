package ch05;

//AI서비스_웹과정반 @8일차
public class _03_ArrayEx {

	public static void main(String[] args) {
		/* 향상된 for문(for each) */
		String[] foodArr = {"치느님", "햄버거", "피자", "짜장면", "떡볶이"};
		int i = 0;
		for (String foody : foodArr) {
			System.out.println("---" + foody);
			System.out.println("foodArr[" + i + "] = " + foody);
			i++;
		}
	}
}
