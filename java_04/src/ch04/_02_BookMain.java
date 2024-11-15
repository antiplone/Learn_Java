package ch04;

//AI서비스_웹과정반 @7~8일차
public class _02_BookMain {

	public static void main(String[] args) { /*[Entry point(function)] 첫 진입장소 */
		/**!
		 * 객체(Instance) 생성 ? 생각안나면, 새로울때마다 'new'를 생각
		 * 클래스명 참조변수 = new 클래스명(); // 참조변수에 클래스의 주소값이 들어있다.
		 * 		참조변수.멤버변수 = 값;
		 * 		참조변수.멤버메서드();
		 */
		/* 책한권 출력 */
		_02_Book thisOne = new _02_Book();

		thisOne.setBookNo(122); /* 9791163030195 */
		thisOne.setBookTitle("Do it! 자바 프로그래밍 입문");
		thisOne.setAuthor("박은종");

/*- 8일차에 지움 */
//		thisOne.setPrice(22500);
//		thisOne.setPageCount(596);
//		thisOne.showInfo();
//		thisOne.getterInfo();

		/**
		 * private : 클래스 내부
		 * default : 패키지 내부
		 * protected : 패키지, 상속 내부
		 * public : 외부 어디든
		 */

		/*@8일차
		 * 1. 객체생성
		 * 2. getter로 출력
		 */
		System.out.println("-------------------");
		System.out.println("<<< 매개변수 생성자 >>>");


		_02_Book secondBook = new _02_Book(2, "JSP", "최범균");

		System.out.println(secondBook.getBookNo()		+ "\t<-- secondBook.getBookNo()");
		System.out.println(secondBook.getBookTitle()	+ "\t<-- secondBook.getBookTitle()");
		System.out.println(secondBook.getAuthor()		+ "\t<-- secondBook.getAuthor()");

		System.out.println("-------------------");

		_02_Book thirdBook = new _02_Book(3, "Spring");

		System.out.println(thirdBook.getBookNo()		+ "\t<-- thirdBook.getBookNo()");
		System.out.println(thirdBook.getBookTitle()	+ "\t<-- thirdBook.getBookTitle()");
		System.out.println(thirdBook.getAuthor()		+ "\t<-- thirdBook.getAuthor()");
	}
}
