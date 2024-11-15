package ch03;

//AI서비스_웹과정반 @7일차
public class _04_HouseMain {

	public static void main(String[] args) {
		_04_House prugio = new _04_House();
//		prugio.address = "용산구 천호동 11-10번지";
		prugio.setAddress("용산구 천호동 11-10번지");
//		prugio.price = 48000000;
		prugio.setPrice(48000000);
//		prugio.kind = "아파트";
		prugio.setKind("아파트");
//		prugio.size = 21;
		prugio.setSize(21);

		prugio.printInfo('?'); /* 평:평수, 면:면적, 아무값:둘다 */
	}
}
