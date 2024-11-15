package ch04;

//AI서비스_웹과정반 @7~8일차
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
/*- 8일차에 지움 */
//	private int price;			/* 가격		25000, 35000 */
//	private int pageCount;		/* 쪽수		페이지수 150 */

	/*+ 8일차에 추가 */
	/*! 생성자 오버로드
	 * 생성자가 두개 이상 제공되는 경우를 말한다.
	 * 메서드나 생성자의 매개변수 갯수가 다르거나 타입이 다른 경우를 말하며, 리턴타입은 무관하다.
	 */
	public _02_Book() {/* default */}
	public _02_Book(int bookNo, String bookTitle, String author) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public _02_Book(int bookNo, String bookTitle) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
	}

	public void name(String ...args) {
		
	}


	public int getBookNo() { /* getter */
		return bookNo;
	}
	public void setBookNo(int bookNo) { /* setter */
		this.bookNo = bookNo;
	}

	public String getBookTitle() { /* getter */
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) { /* setter */
		this.bookTitle = bookTitle;
	}

	public String getAuthor() { /* getter */
		return author;
	}
	public void setAuthor(String author) { /* setter */
		this.author = author;
	}

/*- 8일차에 지움 */
//	public int getPrice() { /* getter */
//		return price;
//	}
//	public void setPrice(int price) { /* setter */
//		this.price = price;
//	}
//
//	public int getPageCount() { /* getter */
//		return pageCount;
//	}
//	public void setPageCount(int pageCount) { /* setter */
//		this.pageCount = pageCount;
//	}

/*- 8일차에 지움 */
//	public void showInfo() {
//		System.out.println("=== <<< 멤버변수 값 내용 >>> =========");
//		System.out.println("책번호: "		+ bookNo);
//		System.out.println("제목: "		+ bookTitle);
//		System.out.println("저자: "		+ author);
//		System.out.println("가격: "		+ price);
//		System.out.println("쪽수: "		+ pageCount);
//	}
//
//	public void getterInfo() {
//		System.out.println("=== <<< getter로 값 내용 >>> =========");
//		System.out.println(getBookNo()		+ "\t\t<--   getBookNo()");
//		System.out.println(getBookTitle()	+ "\t\t<--   getBookTitle()");
//		System.out.println(getAuthor()		+ "\t\t<--   getAuthor()");
//		System.out.println(getPrice()		+ "\t\t<--   getPrice()");
//		System.out.println(getPageCount()	+ "\t\t<--   getPageCount()");
//	}
}
