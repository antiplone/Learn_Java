package ch06;

//AI서비스_웹과정반 @9일차
public class _03_Customer {
	/* ** 멤버 ******
	 * 변수
	 */
	private String id;			/* 고객ID	C1001	C1002 */
	private String name;		/* 고객명		김태희	이진상 */
	private String grade;		/* 고객등급	VIP		BLACK */


	public _03_Customer() {
		System.out.println("<<_03_Customer 부모생성자 >>");
	}

	public _03_Customer(String id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}


	/* get·setter */
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

	public void printInfo() {
		System.out.println("고객ID:\t\t" + id);
		System.out.println("고객명:\t\t" + name);
		System.out.println("고객등급:\t\t" + grade);
	}
}
