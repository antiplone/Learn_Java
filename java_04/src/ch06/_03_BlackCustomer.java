package ch06;

//AI서비스_웹과정반 @9일차
public class _03_BlackCustomer extends _03_Customer {
	/* ** 멤버 ******
	 * 변수
	 */
	private int penalty;	/* 1000 */

	public _03_BlackCustomer() {
//		super(); /* 부모디폴트 생성자 호출, 생략시 컴파일러가 호출 */
		System.out.println("<<_03_BlackCustomer 자식생성자 >>");
	}

	public _03_BlackCustomer(String id, String name, String grade, int penalty) {
		super(id, name, grade);
		this.penalty = penalty;
	}


	/* get·setter */
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
}
