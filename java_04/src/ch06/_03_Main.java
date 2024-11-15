package ch06;

//AI서비스_웹과정반 @9일차
public class _03_Main {

	public static void main(String[] args) {
		System.out.println("[ 방법1. setter로 멤버변수에 값전달 ]");
//		_03_VIPCustomer vip = new _03_VIPCustomer("C1001", "김태희", "VIP", 9999, .01);
		_03_VIPCustomer vip = new _03_VIPCustomer();
		vip.setID("C1001");
		vip.setName("김태희");
		vip.setGrade("VIP");
		vip.setAgentID(9999);
		vip.setSaleRatio(.01);

		vip.printInfo(); /* 자식메서드가 호출 */

		System.out.println("------------------");

		System.out.println("[ 방법2. 매개변수 생성자로 멤버변수에 값전달 ]");
		_03_BlackCustomer black = new _03_BlackCustomer("C1002", "이진상", "BLACK", 1000);
//		black.setID("C1002");
//		black.setName("이진상");
//		black.setGrade("BLACK");

		black.printInfo();
	}
}
