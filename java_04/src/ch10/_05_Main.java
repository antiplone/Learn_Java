package ch10;

import java.util.ArrayList;

//AI서비스_웹과정반 @14일차
public class _05_Main {

	public static void main(String[] args) {
		/* 매개변수 생성자를 통한 값 전달 */
		_05_EnumEx cat = new _05_EnumEx(Animal.CAT, "야옹이");
		_05_EnumEx dog = new _05_EnumEx(Animal.DOG, "댕댕이");
		_05_EnumEx fish = new _05_EnumEx(Animal.FISH, "물고기");

		/* 리스트에 담는다. */
		ArrayList<_05_EnumEx> animals = new ArrayList<>();
		animals.add(cat);
		animals.add(dog);
		animals.add(fish);

		/* 향상된 for문(for-each)문으로 출력 */
		for (_05_EnumEx animal : animals) {
//			System.out.println(animal.getKind() + " : " + animal.getName());
			System.out.println(animal); /* .toString()재정의 출력 */
		}
	}
}
