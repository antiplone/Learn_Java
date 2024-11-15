package ch04;

//AI서비스_웹과정반 @7일차
/* *
 * 나중에 부록도 만들어보자
 */
public class _01_03_Book {
	private String category;
	private int num;
	private String bookTitle;
	private String author;
	private int price;
	private int pages;
	private String shortTitle = "";

	private boolean checkInit;


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * [read-only]
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * [read-only]
	 */
	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * [read-only]
	 */
	public int getPages() {
		return pages;
	}
	
	/**
	 * [read-only]
	 */
	public String getShortTitle() {
		return shortTitle;
	}


	public void init(String bookTitle, String author, int pages) {
		if (!checkInit) {
			this.bookTitle = bookTitle;
			this.author = author;
			this.pages = pages;

			this.shortTitle += bookTitle.charAt(0);

			boolean checkSpace = false;
			for (int i = 0; i < bookTitle.length(); i++) {
				if (!checkSpace) {
					if (bookTitle.charAt(i) == ' ') {
						checkSpace = true;
					}
				}
				else {
					this.shortTitle += bookTitle.charAt(i);
					break;
				}
			}

			/* 영문제목의 책에서만 가능한 기능 !(띄어쓰기도 구분을 해야겠다.) */
//			this.shortTitle += Character.toUpperCase(bookTitle.charAt(0));
//	
//			for (int i = 1; i < bookTitle.length(); i++) {
//
//				if (Character.isUpperCase(bookTitle.charAt(i))) {
//					this.shortTitle += bookTitle.charAt(i);
//					break;
//				}
//			}


			checkInit = true;
		}
		else System.out.println("[ERROR] 이미 초기화가 되었습니다.");
	}
}
