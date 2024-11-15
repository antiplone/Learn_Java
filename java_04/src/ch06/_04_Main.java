package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Main {

	public static void main(String[] args) {
		System.out.println("<<< 객체를 바꿔보면서, 다형성으로 출력 >>>");
		_04_Animal animal;
		animal = new _04_Human();
//		animal = new _04_Tiger();
//		animal = new _04_Eagle();
//		animal = new _04_Fish();
		animal.move();
		_04_Human castHuman = (_04_Human)animal;
		castHuman.readBook();

		System.out.println();

		_04_Human human = new _04_Human();
		_04_Tiger tiger = new _04_Tiger();
		_04_Eagle eagle = new _04_Eagle();
		_04_Fish fish = new _04_Fish();

		System.out.println("<<< 다형성 적용 >>>");
		human.move();
		human.readBook();
		System.out.println();

		tiger.move();
		tiger.hunting();
		System.out.println();

		eagle.move();
		eagle.flying();
		System.out.println();

		fish.move();
		fish.eating();
		System.out.println();

		System.out.println("<<< 매개변수를 통한 다형성 적용 >>>");
		animalMove(human); /* call by reference <> call by value */
		animalMove(tiger);
		animalMove(eagle);
		animalMove(fish);
	}

	/**
	 * 동물이 움직이게 하는 static 함수
	 * @param animal 다형성을 보여주기 위해, 매개변수의 자식의 객체를 받는다.
	 */
	public static void animalMove(_04_Animal animal) {
		/* 자식의 메서드가 실행된다. 안에는 자식의 구조로 만들어진 객체가 들어있기때문 */
		animal.move();

		/* animal이라는 참조변수안의 주소값에 들어있는 객체(인스턴스)의 구조를 물어보는것  */
		if (animal instanceof _04_Human)
			((_04_Human)animal).readBook(); /* Down casting */

		else if (animal instanceof _04_Tiger)
			((_04_Tiger)animal).hunting(); /* Down casting */

		else if (animal instanceof _04_Eagle)
			((_04_Eagle)animal).flying(); /* Down casting */

		else if (animal instanceof _04_Fish)
			((_04_Fish)animal).eating(); /* Down casting */

		System.out.println();
	}
}
