package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Main {

	public static void main(String[] args) {
		/**! 상속(다형성), 생성자·메서드 오버라이딩 */
		_01_03_Book[] programming = {
			new _01_03_Book("절대 JAVA", 28000, 656, "강환수", "인피니티북스"),
			new _01_03_Book("Do it! 자바 프로그래밍 입문", 22500, 596, "박은종", "이지스퍼블리싱"),
			new _01_03_Book("모두의 SQL", 16200, 296, "김도연", "길벗"),
			new _01_03_Book("파이썬(Python)", 20700, 596, "박병기", "아티오"),
			new _01_03_Book("스프링 부트 3.0", 25200, 324, "그렉 턴키스트", "에이콘출판"),
		};

		System.out.println("--- 준비된 책정보 -------------------");

		for (int i = 0; i < programming.length; i++)
			programming[i].details();

		System.out.println("----------------------------------");

		_01_03_Fan mini = new _01_03_Fan("핸드형 선풍기", 8000, 8, 3, 3);
		_01_03_Humidifier miniLED = new _01_03_Humidifier("LED가습기", 12000, 15, 500);

		mini.details();
		miniLED.details();
	}
}