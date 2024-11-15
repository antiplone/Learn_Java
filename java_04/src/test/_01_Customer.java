package test;

//AI서비스_웹과정반 @9일차
public class _01_Customer {
	/* 멤버변수 */
	private String customerID;		/* 고객아이디			C001	C002 */
	private String customerName;	/* 고객명				김태희	비 */
	private int bonusPoint;			/* 보너스포인트		10		5 */
	private double bonusRate;		/* 포인트 적립비율		.05		.03 */


	/*~ 생성자
	 * 
	 * default
	 * 매개변수(arguments, parameters)
	 */
	public /* void쓰면 죽어 */ _01_Customer() {/* default */}
	public _01_Customer(String customerID, String customerName, int bonusPoint, double bonusRate) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.bonusPoint = bonusPoint;
		this.bonusRate = bonusRate;
	}


	/* 멤버메서드 get·setter */

	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRate() {
		return bonusRate;
	}
	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}


	public void printInfo() {
		System.out.println("고객아이디:\t" + customerID);
		System.out.println("고객명:\t\t" + customerName);
		System.out.println("보너스포인트:\t" + bonusPoint);
		System.out.println("포인트 적립비율:\t" + bonusRate);
	}
}
