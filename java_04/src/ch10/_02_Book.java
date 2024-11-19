package ch10;

//AI서비스_웹과정반 @14일차
public class _02_Book/* extends Object */ {

	private int bookNo;			/* 번호		참조변수1, 참조변수2 */
	private String bookTitle;	/* 제목		java입문, JSP */
	private String author;		/* 저자		박은종, 최범균 */
	private int price;			/* 가격		25000, 35000 */


	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	@Override	/* 부모(Object) 메서드 재정의 */
	public String toString() {
		String str = "";
		str += "=== 책의 내용 =========\n";
		str += "책번호:\t"	+	this.bookNo + "\n";
		str += "제목:\t"		+	this.bookTitle + "\n";
		str += "저자:\t"		+	this.author + "\n";
		str += "가격:\t"		+	this.price + "\n";

		System.out.println(super.toString()); /* 이전 부모(Object)메서드 출력 */
		return str;
//		return super.toString(); /* 이렇게 보내면, 주소값 출력 */
	}
}
