package ch04;

//AI서비스_웹과정반 @8일차
public class _04_CarMain {

	public static void main(String[] args) {
		/* 객체생성 */
		_04_Car car = new/* On the heap */ _04_Car() /* return mem_addr */;

		/* setter로 값 전달 */
		car.setBrand("KIA");
		car.setModel("스토닉");
		car.setPrice(21650000);
		car.setMadeIn("Korea");

		/* getter로 출력 */
		System.out.println(car.getBrand() + "\t\t<--  car.getBrand()");
		System.out.println(car.getModel() + "\t\t<--  car.getModel()");
		System.out.println(car.getPrice() + "\t<--  car.getPrice()");
		System.out.println(car.getMadeIn() + "\t\t<--  car.getMadeIn()");

		System.out.println("--------------------------");
		System.out.println("<<< 매개변수 생성자 >>>");

		_04_Car car2 = new _04_Car("Genesis", "GV80", 69300000, "Korea");

		System.out.println(car2.getBrand() + "\t\t<--  car2.getBrand()");
		System.out.println(car2.getModel() + "\t\t<--  car2.getModel()");
		System.out.println(car2.getPrice() + "\t<--  car2.getPrice()");
		System.out.println(car2.getMadeIn() + "\t\t<--  car2.getMadeIn()()");
	}
}
