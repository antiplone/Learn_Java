package ch10;

//AI서비스_웹과정반 @14일차
public class _02_BookMain {

	public static void main(String[] args) {
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
		System.out.println(javaBasic.toString());
		System.out.println(javaBasic); /* 생략시 Object.toString() 호출 */

		System.out.println();

		_02_Book jsp = new _02_Book();
//		jsp.bookNo = 2;
		jsp.setBookNo(2);
//		jsp.bookTitle = "JSP";
		jsp.setBookTitle("JSP");
//		jsp.author = "최범균";
		jsp.setAuthor("최범균");
		jsp.setPrice(35000);

		System.out.println(jsp.toString());
	}
}
