package ch08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//AI서비스_웹과정반 @12일차
public class _02_ArrayListEx {

	public static void main(String[] args) {
		/*
		 * 8. 검색 : list.indexOf(검색할 값);    // 중요
		 *         => 리스트에서 검색할 값과 똑같은 값을 갖는 첫번째 데이터를 찾아서 그 위치의 인덱스를 리턴한다.
		 *
		 *         list.lastIndexOf(검색할 값)
		 *             => 리스트에서 검색할 값과 똑같은 값을 갖는 마지막번째 데이터를 찾아서 그 위치의 인덱스를 리턴한다.         
		 *
		 *         검색할 값과 일치한 데이터가 없으면 -1을 리턴한다.
		 */
//		String kdHong = "HONGKILDONG";
//		for (int i = 0; i < hong.length; i++) {
//			list.add(Character.toString(kdHong.charAt(i)));
//		}

//		String[] hong = {
//			"H", "O", "N", "G", "K", "I", "L", "D", "O", "N", "G"
//		};
//		List<String> list = new ArrayList<String>(List.of(hong));
		List<String> list = new ArrayList<String>();
		list.add("H");
		list.add("O");
		list.add("N");
		list.add("G");
		list.add("K");
		list.add("I");
		list.add("L");
		list.add("D");
		list.add("O");
		list.add("N");
		list.add("G");

		System.out.println("G문자의 인덱스 : " + list.indexOf("G")); /* G문자의 인덱스 : 3 */
		System.out.println("N문자의 인덱스 : " + list.indexOf("N")); /* N문자의 인덱스 : 2 */

		System.out.println("G문자의 마지막인덱스 : " + list.lastIndexOf("G")); /* G문자의 인덱스 : 10 */
		System.out.println("N문자의 마지막인덱스 : " + list.lastIndexOf("N")); /* N문자의 인덱스 : 9 */
		System.out.println("Z문자의 마지막인덱스 : " + list.lastIndexOf("Z")); /* Z문자의 인덱스 : -1 */

		/* 전체 리스트 출력 => 향상된 for문 */
		for (String str : list) {
			System.out.print(str + " ");
		} /* H O N G K I L D O N G */
		System.out.println("\n");
		/* 7. 삭제 : list.remove(삭제할 위치 index); */
		System.out.println("<< 7. 삭제 : list.remove(삭제할 위치 index); >>");
		list.remove(4);
		for (String str : list) {
			System.out.print(str + " ");
		} /* H O N G I L D O N G */
		System.out.println("\n");
		
		/* 9. 전체 삭제 : list.clear(); */
		System.out.println("<< 9. 전체 삭제 : list.clear(); >>");
		list.clear();
		for (String str : list) {
			System.out.println(str + " ");
		}

		System.out.println("\n-----------------------------------");
	}
}
