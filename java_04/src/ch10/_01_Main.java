package ch10;

//AI서비스_웹과정반 @14일차
public class _01_Main {

	public static void main(String[] args) {

		String hongs = "홍길동";
		String kims = "김태희";
		_01_Company hong = _01_Company.getInstance();
		_01_Company kim = _01_Company.getInstance();

		hong.gotoWork("홍길동");
		kim.gotoWork(kims);
		hong.work(hongs);
		kim.work(kims);
		hong.gotoLunch(hongs);
		kim.gotoLunch(kims);
		hong.gotoHome(hongs);
		kim.gotoHome(kims);

		System.out.println();
		equalInstance(hong, kim);

//		_01_Company thisOne = _01_Company.getInstance();
//		_01_Company anotherOne = _01_Company.getInstance();
//		_01_Company somewhere = _01_Company.getInstance();
//
//		System.out.println(thisOne);
//		System.out.println(anotherOne);
//		System.out.println(somewhere);
//
//		equalInstance(thisOne, anotherOne);
	}


	public static void equalInstance(_01_Company comp1, _01_Company comp2) {
		if (comp1 == comp2)
			System.out.println("참조중인 두개의 객체가 같습니다.");

		System.out.println("*comp1: " + comp1); /* 객체(인스턴스)가 뭔지 출력 */
		System.out.println("&comp1: " + Integer.toHexString(comp1.hashCode()));
		System.out.println("*comp2: " + comp2); /* 객체(인스턴스)가 뭔지 출력 */
		System.out.println("&comp2: " + Integer.toHexString(comp2.hashCode()));
		/* .hashCode()
		 * JVM(자바 가상머신)에서 임의적으로 객체(인스턴스)를 구별하기위해 넣는 고유코드
		 */
	}
}
