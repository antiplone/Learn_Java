package ch03;

//AI서비스_웹과정반 @6일차
/**!
 * 클래스 : 객체에 대한 설계도, 디자인
 * 		- 멤버변수(속성) + 멤버메서드(기능, 동작)
 * 객체 : 클래스를 바탕으로 만들어진 힙(Heap)메모리 공간
 */
public class _02_Book {
	/**~
	 * 접근지정자
	 * public :		외부에서 접근을 하도록 허용한다.
	 * private :	외부에서 접근을 막아버린다.
	 */
	/*5) 멤버변수로 값이 들어온다. */
	private int bookNo;			/* 번호		참조변수1, 참조변수2 */
	private String bookTitle;	/* 제목		java입문, JSP */
	private String author;		/* 저자		박은종, 최범균 */
	private int price;			/* 가격		25000, 35000 */

	/* 멤버메서드(기능, 동작) */
	public void setBookNo(int bookNo/*3) 매개변수로 값 전달받는다; */) { /* setter */
		this.bookNo = bookNo;/*4) 멤버변수에 대입 = 매개변수 */
	}

	public void setBookTitle(String bookTitle) { /* setter */
		this.bookTitle = bookTitle;
	}

	public void setAuthor(String author) { /* setter */
		this.author = author;
	}

	public void setPrice(int price) { /* setter */
		this.price = price;
	}


	public void showInfo() {
		System.out.println("=== 책의 내용 =========");
		System.out.println("책번호:\t"	+	this.bookNo);
		System.out.println("제목:\t"		+	this.bookTitle);
		System.out.println("저자:\t"		+	this.author);
		System.out.println("가격:\t"		+	this.price);
	}
}
