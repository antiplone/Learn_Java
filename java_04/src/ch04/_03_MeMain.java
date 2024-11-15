package ch04;

public class _03_MeMain {

	public static void main(String[] args) {
		_03_Me itsMe = new _03_Me();

		itsMe.setName("전영대");
		itsMe.setAge(34);
		itsMe.setGender("M");
		itsMe.setHobby("스트리밍 서비스 이용");

		System.out.println(itsMe.getName()		+ "\t\t<--  itsMe.getName()");
		System.out.println(itsMe.getAge()		+ "\t\t<--  itsMe.getAge()");
		System.out.println(itsMe.getGender()	+ "\t\t<--  itsMe.getGender()");
		System.out.println(itsMe.getHobby()		+ "\t<--  itsMe.getHobby()");
	}
}
