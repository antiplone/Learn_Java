package test;

//AI서비스_웹과정반 @9일차
public class _01_CustomerMain {

	public static void main(String[] args) {
		/**! getter로 출력 */
		System.out.println("<<< 객체생성(디폴트생성자) + setter >>>");
		_01_Customer kim = new _01_Customer();

		kim.setCustomerID("C001");
		kim.setCustomerName("김태희");
		kim.setBonusPoint(10);
		kim.setBonusRate(.05);

//		System.out.println("고객아이디:\t" + kim.getCustomerID());
//		System.out.println("고객명:\t\t" + kim.getCustomerName());
//		System.out.println("보너스포인트:\t" + kim.getBonusPoint());
//		System.out.println("포인트 적립비율:\t" + kim.getBonusRate());
		kim.printInfo();

		System.out.println('\n' + "<<< 객체생성(매개변수 생성자) >>>");
		_01_Customer rain = new _01_Customer("C002", "비(정지훈)", 5, .03);

//		System.out.println("고객아이디:\t" + rain.getCustomerID());
//		System.out.println("고객명:\t\t" + rain.getCustomerName());
//		System.out.println("보너스포인트:\t" + rain.getBonusPoint());
//		System.out.println("포인트 적립비율:\t" + rain.getBonusRate());
		rain.printInfo();
	}
}
