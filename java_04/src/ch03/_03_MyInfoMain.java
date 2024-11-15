package ch03;

//AI서비스_웹과정반 @6일차
public class _03_MyInfoMain {

	public static void main(String[] args) {
		_03_MyInfo myInfo = new _03_MyInfo();

		myInfo.setName("전영대");
		myInfo.setBirthday("91년 3월 31일");
		myInfo.setMoney(Integer.MIN_VALUE);
		myInfo.setAddress("서울시 양천구");

		myInfo.printInfo();
	}
}
