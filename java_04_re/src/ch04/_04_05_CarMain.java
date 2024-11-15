package ch04;

//AI서비스_웹과정반 @8일차
public class _04_05_CarMain {

	public static void main(String[] args) {
		/**! 생성자(default, 매개변수)·메서드 오버로딩(Overloading), static(클래스 변수(공유)·메서드) */
		_04_05_Car premier = new _04_05_Car(
			"Trail Blazer",
			_04_05_Car.COLOR_BLACK,
			27990000
		);
		_04_05_Car rs = new _04_05_Car("Trail Blazer", _04_05_Car.COLOR_WHITE);

		rs.setPrice(30990000);

		premier.showDetails();
		rs.showDetails();
	}
}
