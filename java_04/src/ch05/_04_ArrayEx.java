package ch05;

//AI서비스_웹과정반 @8일차
public class _04_ArrayEx {

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3},	/* 0행 */
				{4, 5, 6}	/* 1행 */
		};

		for (int i = 0; i < 2; i++) {

			System.out.print("{ ");
			for (int j = 0; j < 3; j++) {
//				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("},");
		}

		System.out.println("------------------");

		for (int i = 0; i < arr.length; i++) {

			System.out.print("{ ");
			for (int j = 0; j < arr[i].length; j++) {
//				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("},");
		}

		System.out.println("------------------");

		String[][] str = {
				/*0열  1열  2열*/
				{"A", "B", "C"},	/* 0행 */
				{"D", "E", "F"},	/* 1행 */
				{"G", "H", "I"}		/* 2행 */
		};

		for (int i = 0; i < str.length; i++) {
			
			System.out.print("{ ");
			for (int j = 0; j < str[i].length; j++) {
//				System.out.println("str[" + i + "][" + j + "] = " + str[i][j]);
				System.out.print(str[i][j] + " ");
			}
			System.out.println("},");
		}
	}
}
