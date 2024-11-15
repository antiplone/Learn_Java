package ch06;

//AI서비스_웹과정반 @9일차
public class _01_03_Book extends _01_03_Product {

	private int pages;
	private String author;
	private String publisher;


	public _01_03_Book(String name, int price, int pages, String author, String publisher) {
		super(name, price);
		this.pages = pages;
		this.author = author;
		this.publisher = publisher;
	}


	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	/** [read-only] */
	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public void details() {
		super.details();
		System.out.println("쪽수:\t" + pages);
		System.out.println("저자:\t" + author);
		System.out.println("출판사:\t" + publisher);
	}
}
