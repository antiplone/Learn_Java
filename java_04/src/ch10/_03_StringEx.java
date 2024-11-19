package ch10;

//AI서비스_웹과정반 @14일차
public class _03_StringEx {

	public static void main(String[] args) {
		String str = "A Barking dog";
		String s1, s2, s3, s4, s5;

		/* 문자열 길이 : length() */
		System.out.println("문자열 길이 : " + str.length());

		/* 문자열 결합 : concat("연결할 문자열") */
		s1 = str.concat(" never Bites!!");
		System.out.println("s1 : " + s1);

		/* 문자열 교환 : replace(oldChar, newChar") */
		s2 = s1.replace("B", "b");
		s2 = s2.replace("dog", "cat");
		System.out.println("s2 : " + s2);

		/* 부분 문자열 : substring(beginIndex, endIndex) => beginIndex >= 추출값 <= endIndex
		 * beginIndex는 0부터 시작 / endinex = endIndex - 1
		 */
		s3 = s2.substring(5, 9);
		System.out.println("s4 :" + s3);

		/* 대문자로 변환 : toUpperCase() */
		s4 = s2.toUpperCase();
		System.out.println("s4 :" + s4);

		s5 = s2.toLowerCase();
		System.out.println("s45:" + s5);

		/* split("쪼갤 문자")
		 * 입력받는 정규표현식 또는 특정문자를 기준으로
		 * 문자열을 나누어 배열에 저장한다.
		 */
		String hpStr = "010-1234-5678";
		String[] hp = hpStr.split("-");
		for (String hstr : hp) {
			System.out.println("hpStr.split : " + hstr);
		}

		System.out.println("------------------------");
		String city = "서울, 제주도, 부산, 광주, 대전";
		String[] cityList = city.split(", ");
		for (int i = 0; i < cityList.length; i++) {
			System.out.println("[" + i + "] " + cityList[i]);
		}

		for (String cstr : city.split(", ")) {
			System.out.println(cstr);
		}

		/* trim() : 양쪽공백제거 */
		String strTrim = "     Hi!!  WHY??    ";
		System.out.println(strTrim);
		System.out.println(strTrim.trim());
	}
}
