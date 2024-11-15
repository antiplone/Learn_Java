package ch06;

//AI서비스_웹과정반 @9일차
public class _03_VIPCustomer extends _03_Customer {
	/* ** 멤버 ******
	 * 변수
	 */
	private int agentID;		/* VIP 고객상담원ID	9999 */
	private double saleRatio;	/* 할인율				.01 */


	public _03_VIPCustomer() {
		super(); /* 부모디폴트 생성자 호출, 생략시 컴파일러가 호출 */
		System.out.println("<<_03_VIPCustomer 자식생성자 >>");
//		super(); /* 초기화가 우선이기때문에 제일 먼저 호출이 되어야한다. */
	}

	/* 매개변수 생성자 */
	public _03_VIPCustomer(String id, String name, String grade, int agentID, double saleRatio) {
		super(id, name, grade); /* 부모의 매개변수 생성자 호출 */
//		super.id = "C1001"; /* 부모의 멤버에 접근하려면, 접근제어를 protected이상으로 바꿔줘야된다. */
//		this.id = "C1001"; /* 하지만, 부모의 생성자로 값을 전달하는게 일반적인 방법이다. */
		this.agentID = agentID;
		this.saleRatio = saleRatio;
	}


	/* get·setter */
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}


	/* 부모메서드를 재사용하겠다. */
	@Override /* 오버라이딩:다시정의한다. */
	public void printInfo() {
		super.printInfo();
		System.out.println("VIP고객상담원ID:\t" + agentID);
		System.out.println("고객등급:\t\t" + saleRatio);
	}
}
