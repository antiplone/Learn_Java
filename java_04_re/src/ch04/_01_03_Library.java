package ch04;

import java.util.Scanner;

//AI서비스_웹과정반 @7일차
/*
 * Curator는 나중에 추가로 개발해보자
 */
public class _01_03_Library { /* 일단은 'new'로 바로 생성... 나중에 다른방법으로 바꾸자 */
	public final double PLANE = 3.3058;
	public final char SPERATOR = '_';

	/* 멤버변수 */
	private String name = "중앙도서관";
	private String address = "서초구 반포동 산 60-1";
	private int size = 15;
	private String sortShort = "";
	private _01_03_Book javaBasic = new _01_03_Book();
	private _01_03_Book jsp = new _01_03_Book();
	private _01_03_Book pythonBasic = new _01_03_Book();
	private String arrangSeat;

	private static _01_03_Library Singleton = new _01_03_Library();
	private _01_03_Library() {}
	public static _01_03_Library getInstance() {
		return Singleton;
	}

	/**
	 * 클래스가 두개일 경우 메인이 있는 클래스를
	 * public으로두고 메인클래스의 이름으로 파일명 지정,
	 * 나머지는 public을 지운다.
	 */
	public static void main(String[] args) {
		/**! 멤버변수·메서드, get·setter */
		Scanner sc = new Scanner(System.in);

		_01_03_Library library = _01_03_Library.getInstance();
		System.out.println("=== << " + library.name + "에 오신것을 환영합니다. >> ===");

		/* 책들을 설정 */
		library.javaBasic.init("Java 입문", "박은종", 150);
		library.javaBasic.setCategory("Java");
		library.javaBasic.setNum(4);
		library.javaBasic.setPrice(25000);
		System.out.println("javaBasic.shortTitle: " + library.javaBasic.getShortTitle());

		library.jsp.init("JSP", "최범균", 150);
		library.jsp.setCategory("JSP");
		library.jsp.setNum(6);
		library.jsp.setPrice(35000);
		System.out.println("jsp.shortTitle: " + library.jsp.getShortTitle());

		library.pythonBasic.init("Python 기초", "???", 180);
		library.pythonBasic.setCategory("Python");
		library.pythonBasic.setNum(5);
		library.pythonBasic.setPrice(31000);
		System.out.println("pythonBasic.shortTitle: " + library.pythonBasic.getShortTitle());

		library.sortShort = library.jsp.getShortTitle() + library.SPERATOR
				+ library.javaBasic.getShortTitle() + library.SPERATOR
				+ library.pythonBasic.getShortTitle();

		int cmd = 0;
		do {
			cmd = sc.nextInt();

			switch (cmd) {
			case 1:
				library.showInfo();
				break;

			case 2:
				System.out.println("구현예정...");
				break;

			case 3:
				library.takeStock();
				break;
				
			default:
				break;
			}
		} while (cmd > 0 && cmd <= 3);

		System.out.println("변경된 면적:" + library.calcPlane(22));

		sc.close();
	}


	/**
	 * 평을 면적으로 계산해준다.
	 * 단, 0보다 작거나 같으면 현재 도서관에 면적을 계산
	 * 
	 * @param size 계산할 평수
	 * @return 계산된 평수
	 */
	private double calcPlane(int size) {
		if (size <= 0) {
			return this.size * PLANE;
		}
		else this.size = size; 

		return size * PLANE;
	}

	private void printStock(String str) { /* Book oveL?? sep?? */

		if (str.contains(javaBasic.getShortTitle())) {

			System.out.print(javaBasic.getBookTitle() + ": ");
			System.out.println(javaBasic.getNum() + "권");

			for (int i = 0; i < javaBasic.getNum(); i++) {
				this.arrangSeat += "|" + javaBasic.getShortTitle() + "|";
			
			}

			this.arrangSeat += "\n";
		}
		else if (str.contains(jsp.getShortTitle())) {

			System.out.print(jsp.getBookTitle() + ": ");
			System.out.println(jsp.getNum() + "권");

			for (int i = 0; i < jsp.getNum(); i++) {
				this.arrangSeat += "|" + jsp.getShortTitle() + "|";
			}

			this.arrangSeat += "\n";
		}
		else if (str.contains(pythonBasic.getShortTitle())) {

			System.out.print(pythonBasic.getBookTitle() + ": ");
			System.out.println(pythonBasic.getNum() + "권");

			for (int i = 0; i < pythonBasic.getNum(); i++) {
				this.arrangSeat += "|" + pythonBasic.getShortTitle() + "|";
			}

			this.arrangSeat += "\n";
		}
	}

	public void showInfo() {
		System.out.println("주소: " + this.address);
		System.out.println("평수: " + this.size);
		System.out.println("면적: " + calcPlane(0));
	}

	/* 재고파악 */
	public void takeStock() {

		if (!this.sortShort.isBlank()) {

			this.arrangSeat = "";

			int beginIndex = 0;
			for (int i = 0; i < sortShort.length(); i++) {/* 사실상 다중for문 */

				if (sortShort.charAt(i) == SPERATOR) {

					String str = sortShort.substring(beginIndex, i);
					printStock(str);
					beginIndex = i + 1;
				}
				else {
					if (i == sortShort.length() - 1) {
						String str = sortShort.substring(beginIndex, i + 1);
						printStock(str);
					}
				}
			}

			System.out.println("<< 정렬된 책 >>");
			System.out.println(this.arrangSeat);
		}
		else System.out.println("[ERROR] 정렬기준이 비어있습니다.");
	}

	/* 검색... 못한게 아쉽다... */
}
