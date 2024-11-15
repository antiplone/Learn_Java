package ch04;

//AI서비스_웹과정반 @8일차
public class _05_StudentMain {

	public static void main(String[] args) {
		_05_Student studentLee = new _05_Student();
		studentLee.setName("이지원");
		System.out.println("Serial: "	+ _05_Student.getSerialNum());
		System.out.println("이름: "		+ studentLee.getName());
		System.out.println("학번: "		+ studentLee.getStudentID());

		_05_Student studentSon = new _05_Student();
		studentSon.setName("손수경");
		System.out.println("Serial: "	+ _05_Student.getSerialNum());
		System.out.println("이름: "		+ studentSon.getName());
		System.out.println("학번: "		+ studentSon.getStudentID());
	}
}
