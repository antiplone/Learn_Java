package ch10;

//AI서비스_웹과정반 @14일차
/* 
 * StringBuffer : 문자열을 추가하거나 변경할 때 주로 사용하는 자료형이다.
 * - 추가 : append()
 * - 삽입 : insert(시작위치, 문자열) : 특정 위치에 원하는 문자열을 삽입한다.
 * - subString(시작위치, 끝위치) : 시작위치에서 끝위치-1 까지의 문자열을 추출한다. 공백포함
 *                             인덱스는 0부터 시작하며, 끝위치보다 작아야 한다.
 * - toString() : 메서드를 이용해서 String형으로 변경한다.
 */
public class _04_StringBufferEx {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		/* 추가 : append() */
		sb.append("맛있게 ");
		sb.append("먹으면 ");
		sb.append("0칼로리!!");
		System.out.println("sb : " + sb);
		System.out.println("sb : " + sb.toString());
		String str = sb.toString();

		/* 삽입 : insert(시작위치, 문자열) : 특정 위치에 원하는 문자열으 삽입한다. */
		int beginIndex = str.indexOf("0");
		sb = sb.insert(beginIndex, "정말로, ");
		System.out.println(sb + " " + beginIndex);

		/* substring(시작위치, 끝위치) 시작위치는 0부터 시작, 끝위치 = 끝위치 - 1 */
		System.out.println(sb.substring(beginIndex)); /* 시작부터 끝까지 */
		System.out.println(sb.substring(beginIndex + 5, 17));
	}
}
