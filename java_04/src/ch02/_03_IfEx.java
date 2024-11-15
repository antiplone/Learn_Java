package ch02;

//AI서비스_웹과정반 @3일차
public class _03_IfEx {

	public static void main(String[] args) {
		/**! score가 60점 이상이면 합격, 40점 이상이면 불합격(40~59), 40점 미만이면 과락(39~0) */
		int score = 130;
		String result = "";

		if (score >= 60) { /* 합격 점수 */
			result = "합격!";
		}
		else if (score < 40) { /* 과락... */
			result = "과락...";
		}
		else { /* 40~59 */
			result = "불합격...!"; /* 불합격 */
		}

		System.out.println(score + "점 : " + result);

		System.out.println("<<< 3항연산자 >>>");
		/* 결과 = 조건식 ? 참 : 거짓; */
		String resulted1 = (score < 40) ? "과락..." : "불합격";
		String resulted2 = (score >= 60) ? "합격!" : resulted1;
		System.out.println(resulted2);

		System.out.println("--- 잘못된 점수 체크 ---");
		if (score > 100 || score < 0) /* 여집합 조건 */
			System.out.println("잘못된 점수(0~100)");
		else {
			if (score >= 60) { /* 합격 점수 */
				result = "합격!";
			}
			else if (score < 40) { /* 과락... */
				result = "과락...";
			}
			else { /* 40~59 */
				result = "불합격...!"; /* 불합격 */
			}

			System.out.println(score + "점 : " + result);
		}

//		if (score >= 0 && score <= 100) { /* 교집합 조건 */
//			if (score >= 60) { /* 합격 점수 */
//				result = "합격!";
//			}
//			else if (score < 40) { /* 과락... */
//				result = "과락...";
//			}
//			else { /* 40~59 */
//				result = "불합격...!"; /* 불합격 */
//			}
//			
//			System.out.println(score + "점 : " + result);
//		}
//		else System.out.println("잘못된 점수(0~100)");

	}
}
