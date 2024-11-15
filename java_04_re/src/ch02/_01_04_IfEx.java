package ch02;

//AI서비스_웹과정반 @3일차
public class _01_04_IfEx {

	public static void main(String[] args) {
		/**! if·else if·else문 */
		/* if-else구조일때는 if는 참, else는 거짓인 경우 */
		int num = 13;
		boolean condition = (num > 7);
		String result = "";
		if (condition) { /* true조건 */
			result = "결과 : 참입니다.";
		}
		else { /* false조건 */
			result = "결과 : 거짓입니다.";
		}

		System.out.println(result);

		/* if-else if구조일때는 if와 else if는 여러가지의 조건이고, else는 그외에 해당 */
		int height = 120;
		String bloodType = "O", specs = "";

		boolean condBlood = (bloodType == "A" || bloodType == "B" ||
					bloodType == "AB" || bloodType == "O");
		/**~ 혈액형이 올바른지 확인합니다. */
		if (condBlood) {
			/**~ 키가 어느정도인지 재봅니다. */
			if (height > 300) {
				System.out.println("혈액형 : " + bloodType);
				specs = "키가 엄청 크시네요...";
			}
			else if (height <= 300 && height > 240) {
				specs = "혈액형 : " + bloodType + ", ";
				specs += "키가 300~240사이 이시네요";
			}
			else if (height <= 240 && height > 180) {
				specs = "혈액형 : " + bloodType + ", ";
				specs += "키가 240~180사이 이시네요";
			}
			else if (height <= 180 && height >= 120) {
				specs = "혈액형 : " + bloodType + ", ";
				specs += "키가 180~120사이 이시네요";
			}
			else specs = "키가 많이 작으시네요...";
			System.out.println(specs);
		}
		else {
			System.out.println("올바른 혈액형이 아닙니다.");
			System.out.println("ex) 혈액형(A, B, AB, O");
		}
	}
}
