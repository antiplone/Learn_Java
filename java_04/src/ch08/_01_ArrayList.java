package ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//AI서비스_웹과정반 @12일차
/*
 * [ArrayList]
 * 
 * Collection 인터페이스
 * - List 인터페이스 : 클래스 종류는 ArrayList, Vector, LinkedList
 * - Set 인터페이스 : 클래스종류는 HashSet, TreeSet
 * - Map 인터페이스 : 클래스종류는 HashMap, HashTable, TreeMap
 * 
 *  <면접>
 *  1. 특징
 *  List 인터페이스 : 순서가 있는 자료관리, 중복허용한다.
 *                 index를 사용하여 요소에 접근한다.
 *                 리스트에 들어있는 요소들의 인덱스는 0부터 시작한다.
 *                 클래스종류는 ArrayList, Vector, LinkedList
 *                 
 *  Set 인터페이스 : 순서가 없는 자료관리, 중복허용 않는다.
 *                클래스종류는 HashSet, TreeSet
 * 
 * 2. 선언
 * 클래스명<데이터타입클래스> 참조변수 = new 클래스명<데이터타입클래스>();
 * ArrayList<String> list = new ArrayList<String>();
 * String[] arr = new String[5];  // 배열 : 정해진갯수만큼
 * 
 * 다형성 적용
 * List<String> list = new ArrayList<String>();
 * 
 * 3. 특징 : 데이터 순서가 있다. 중복허용된다.
 * 4. 추가 : list.add(값);  // 앞에서부터 순서대로 추가
 *         list.add(추가할 위치 index, 값);  // 지정한 인덱스에 값을 추가, 그 뒤의 값은 밀려난다.
 * 5. 값 가져오기 : list.get(가져올 index);   // list.size()만큼 반복        
 * 6. 교체 : list.set(교체할 위치 index, 값); // 지정한 인덱스의 값을 변경.. 그 뒤값은 그대로이다.
 * 7. 삭제 : list.remove(삭제할 위치 index);
 * 8. 검색 : list.indexOf(검색할 값);    // 중요
 *         => 리스트에서 검색할 값과 똑같은 값을 갖는 첫번째 데이터를 찾아서 그 위치의 인덱스를 리턴한다.
 *
 *         list.lastIndexOf(검색할 값)
 *             => 리스트에서 검색할 값과 똑같은 값을 갖는 마지막번째 데이터를 찾아서 그 위치의 인덱스를 리턴한다.         
 *
 *         검색할 값과 일치한 데이터가 없으면 -1을 리턴한다.
 *         
 * 9. 전체 삭제 : list.clear();
 * 10. 반복자 : Iterator<E> iterator : while(hasNext())  { next() }
 */
public class _01_ArrayList {

	public static void main(String[] args) {
		/* [선언]
		 * 클래스명<데이터타입'클래스'> 참조변수 = new 클래스명<데이터타입'클래스'>();
		 */
//		ArrayList<Object> list = new ArrayList</* [undef, class] */>();
//		ArrayList<String> list = new ArrayList();

		/* double(일반자료형) <> 첫글자(대): Wrapper(감싼) 클래스 */
		Double dd = 11d; /* deprecated(.ver > 9): new Double(0); */
		/* 예외(Integer:int, Character:char) */


		String[] engSeason = {
			"spring",
			"summer",
			"autumn",
			"winter",
		};
//		ArrayList<String> season = new ArrayList<String>(List.of(engSeason)/* (.ver >= 9) */);
//		ArrayList<String> season = new ArrayList<String>(Arrays.asList(engSeason));
		List<String> season = new ArrayList<String>(); /* 다형성 적용 */
		season.add("봄");
		season.add("여름");
		season.add("가을");
		season.add("겨울");

		System.out.println("[방법1. for문]");
		for (int i = 0; i < season.size(); i++)
			System.out.println(season.get(i) + "\t <--  list.get(" + i + ")");

		System.out.println("[방법2. 향상된 for문]");
		for (String str : season) {
			System.out.println("현재계절: " + str);
		}

		System.out.println("----------------------------");
		List<String> snacks = new ArrayList<String>();
		snacks.add(/*[인덱스], */"치킨");
		snacks.add("족발");
		snacks.add("어묵탕");
		snacks.add("물회");
		snacks.add("양꼬치");
		snacks.add("오코노미야끼");

		System.out.println("<<< 향상된 for문 >>>");
		for (String str : snacks) {
			System.out.println(str);
		}

		/* 10. 반복자 : Iterator<E> iterator : while(hasNext())  { next() } */
//		ArrayList<Object> list = new ArrayList</* [undef, class] */>();
//		ArrayList<String> list = new ArrayList();
//		Iterator</* undef, class */> itor = season.iterator();
		System.out.println("<<< Iterator를 이용한 문자열 출력 - season >>>");
		Iterator<String> itor = season.iterator();
//		Iterator<String> itorImpl = new Iterator<String>() {
//			private String[] data = {
//				"spring",
//				"summer",
//				"autumn",
//				"winter",
//			};
//			private int index = 0;
//
//			@Override
//			public String next() {
//				return data[index];
//			}
//
//			@Override
//			public boolean hasNext() {
//				if (index < data.length) {
//					index += 1;
//					return true;
//				}
//
//				return false;
//			}
//		};
		while(itor.hasNext()) { /* ArrayList의 값이 존재하는지 체크 */
			String str = itor.next(); /* 존재하는 값을 읽어서 변수에 대입 */
			System.out.println(str);
		}

		System.out.println("<<< Iterator를 이용한 문자열 출력 - snacks >>>");
		itor = snacks.iterator();
		while (itor.hasNext()) {
			String str = itor.next();
			System.out.println(str);
		}
	}
}
