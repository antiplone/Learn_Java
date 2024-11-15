package ch05;

//AI서비스_웹과정반 @8일차
public class _01_04_ArrayEx {

	public static void main(String[] args) {
		/**! [다중]배열, 향상된for문(for..each) */
		final int BOOK_JAVA = 0;
		final int BOOK_PYTHON = 1;

		String[][] store = {
				{"Java 입문", "Java Bible"},
				{"Python 기초", "Python with TensorFlow", "Cooking Python"}
		};

		System.out.print("Java책들: ");
		for (String is : store[BOOK_JAVA]) {
			System.out.print(is + ", ");
		}

		System.out.println();
		System.out.println("------------------------");

		System.out.print("Python책들: ");
		for (String is : store[BOOK_PYTHON]) {
			System.out.print(is + ", ");
		}
		
		System.out.println();
		System.out.println("------------------------");
		
		for (int i = 0; i < store.length; i++) {
			System.out.print("{ ");

			for (int j = 0; j < store[i].length; j++) {
				System.out.print(store[i][j] + ", ");
			}

			System.out.print("}");
			System.out.println();
		}
	}
}
