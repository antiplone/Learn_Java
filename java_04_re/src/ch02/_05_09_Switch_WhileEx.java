package ch02;

//AI서비스_웹과정반 @4일차
public class _05_09_Switch_WhileEx {

	public static void main(String[] args) {
		/**! 삼항연산자, switch·case문, 반복문(while) */
		/* 실행을 해보기위해 조작해야하는 변수 */
		String fruit = "사과"; /* 구매할 과일을 입력합니다. 품목: 사과, 포도, 자두, 수박 */
		int count = 1; /* 과일이 몇개인지 정합니다. */
		/*******************************************/

		/* 메세지 변수 */
		String countMsg = "개...\n";
		String errorCount = "구매갯수가 잘못되었습니다.";
		String errorFruit = "취급품목이 아닙니다.";
		/*******************************************/

		String result = ""; /* 결과를 출력을 위한 변수 */
		int calculate = 0; /* 과일을 세는 변수 */
		boolean condiExcept = count > 0; /* 과일을 셀 갯수가 0보다 커야지만 세도록 하기위한 조건. */
		while (calculate < count) { /*~ while문은 값이 참일때 반복을 한다. */
			calculate += 1; /* 하나를 세었습니다. */

			/* 상태값에 따른 처리 */
			switch (fruit) {
				/* 3개의 품목일때는 이렇게 출력 */
				/* 예외조건에 문제가 있으면, 문제가 있다고 출력 */
				case "사과":
				case "포도":
				case "자두":
					result += (condiExcept) ? (fruit + "가 " + calculate + countMsg) : errorCount;
					break;
				/* 수박일때는 이렇게 출력 */
				case "수박":
					result += (condiExcept) ? (fruit + "이 " + calculate + countMsg) : errorCount;
					break;
				/* 문제가 있을때 출력 */
				default:
					result = errorFruit;
			}
		}

		/* 최종적으로 문제가 없을때만 출력 */
		if (result != errorFruit && condiExcept)
			result += fruit + "은(는) 모두 " + count + "개 입니다.";

		System.out.println(result); /* 최종적으로 만들어진 문자열을 출력 */
	}
}
