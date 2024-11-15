package ch03;

//AI서비스_웹과정반 @6일차
public class _02_BookMain {

	public static void main(String[] args) {
		/**!
		 * 객체(Instance) 생성 ? 생각안나면, 새로울때마다 'new'를 생각
		 * 클래스명 참조변수 = new 클래스명(); // 참조변수에 클래스의 주소값이 들어있다.
		 * 		참조변수.멤버변수 = 값;
		 * 		참조변수.멤버메서드();
		 */
		_02_Book javaBasic = new _02_Book();
//		javaBasic.bookNo = 1;
		javaBasic.setBookNo(1);
//		javaBasic.bookTitle = "Java입문";
		javaBasic.setBookTitle("Java입문");
//		javaBasic.author = "박은종";
		javaBasic.setAuthor("박은종");
		javaBasic.setPrice(25000);

//		System.out.println("책(javaBasic)의 번호: "		+	javaBasic.bookNo);
//		System.out.println("책(javaBasic)의 제목: "		+	javaBasic.bookTitle);
//		System.out.println("책(javaBasic)의 저자: "		+	javaBasic.author);
		javaBasic.showInfo();

		System.out.println();

		_02_Book jsp = new _02_Book();
//		jsp.bookNo = 2;
		jsp.setBookNo(2);
//		jsp.bookTitle = "JSP";
		jsp.setBookTitle("JSP");
//		jsp.author = "최범균";
		jsp.setAuthor("최범균");
		jsp.setPrice(35000);

		jsp.showInfo();
	}
}
