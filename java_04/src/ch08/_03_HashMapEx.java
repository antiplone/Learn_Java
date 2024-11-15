package ch08;

import java.util.HashMap;
import java.util.Map;

//AI서비스_웹과정반 @12일차
/*  p406
 * 해싱(hashing) : 키를 이용해서 해시테이블로부터 데이터를 가져오는 과정
 * 
 * [면접] p439
 * HashMap
 * 1) 특징
 * - 데이터의 순서를 보장하지 않는다.
 * - key와 value 쌍으로 저장한다.
 * - key는 중복되면 안된다. 값은 중복되도 무관하다.
 * - key를 이용해서 value를 가져올 수 있다.
 * - List 계열과 달리 index가 없다.
 * - Map이라는 인터페이를 구현한 클래스이다.
 * 
 * 2) 선언
 * - HashMap<Key 클래스타입, value 클래스타입> map = new HashMap<Key 클래스타입, value 클래스타입>();
 * - Map<Key 클래스타입, value 클래스타입> map = new HashMap<Key 클래스타입, value 클래스타입>(); // 다형성 적용
 * 
 * 3) 메서드
 * - 데이터 추가 : put(key, value);
 * - 데이터 가져오기 : get(key)
 * - 데이터 삭제 : remove(key)
 * - 데이터가 비어있는지 여부 : isEmpty()
 * - 해당 키가 있는지 여부 : containsKey(key)
 * - 해당 값이 있는지 여부 : containsValue(value)
 * - 해당 갯수 : size()
 */
public class _03_HashMapEx {

	public static void main(String[] args) {
		/*
		 * 2) 선언
		 * - HashMap<Key 클래스타입, value 클래스타입> map = new HashMap<Key 클래스타입, value 클래스타입>();
		 * - Map<Key 클래스타입, value 클래스타입> map = new HashMap<Key 클래스타입, value 클래스타입>(); // 다형성 적용 
		 */
		Map<Integer, String> maps = new HashMap<Integer, String>();
		maps.put(1, "아이유");
		maps.put(2, "유재석");
		maps.put(3, "박명수");
		maps.put(4, "박나래");

		System.out.println("<<< 전체 데이터 출력 - for문 >>>");
		System.out.println("해당 갯수 : " + maps.size());
		for (int i = 1; i <= maps.size(); i++) {
			System.out.println(i + " " + maps.get(i));
		}

//		maps.forEach(
//		(t, u) -> {
//			System.out.println(t + " " + u);
//		});

		System.out.println("<<< 박나래 삭제후 전체 데이터 출력 >>>");
		maps.remove(4);
		for (int i = 1; i <= maps.size(); i++) {
			System.out.println(i + " " + maps.get(i));
		}

		System.out.println("<<< 데이터가 비어있는지 확인 : isEmpty() >>>");
		System.out.println(maps.isEmpty());

		System.out.println("<<< 해당 키가 있는지 여부 : containsKey(key) >>>");
		System.out.println(maps.containsKey(1));
		System.out.println(maps.containsKey(2));
		System.out.println(maps.containsKey(3));
		System.out.println(maps.containsKey(4));

		System.out.println("<<< 해당 값이 있는지 여부 : containsValue(value) >>>");
		System.out.println(maps.containsValue("아이유"));
		System.out.println(maps.containsValue("유재석"));
		System.out.println(maps.containsValue("박명수"));
		System.out.println(maps.containsValue("박나래"));

		System.out.println("<<< 해당 갯수 : maps.size() >>>");
		System.out.println("해당 갯수 : " + maps.size());
	}
}
