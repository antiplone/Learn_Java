package ch06;

public class _01_Main {

	public static void main(String[] args) {
		/**! 부모·나의 메서드로 출력 */
		System.out.println("<<< Dog 객체생성 + setter로 멤버변수에 값전달");
		_01_Dog dog = new _01_Dog();
		dog.setKind("멍뭉이");
		dog.setLegs(4);
		dog.setWeight(10);

		dog.printInfo(); /* 부모것 */
		dog.bark(); /* 내것 */
		System.out.println();

		System.out.println("<<< Cat 객체생성 + setter로 멤버변수에 값전달");
		_01_Cat cat = new _01_Cat();
		cat.setKind("고양이");
		cat.setLegs(4);
		cat.setWeight(5);

		cat.printInfo(); /* 부모것 */
		cat.cry(); /* 내것 */
	}
}
