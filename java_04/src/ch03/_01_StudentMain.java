package ch03;

//AI서비스_웹과정반 @6일차
public class _01_StudentMain {

	public static void main(String[] args) {
		/**!
		 * 객체 생성 ? 생각안나면, 새로울때마다 'new'를 생각
		 * 클래스명 참조변수 = new 클래스명(); // 참조변수에 클래스의 주소값이 들어있다.
		 * * 클래스명:_01_Student student = new 클래스명:_01_Student();
		 * 		참조변수('student').멤버변수('studentID' or 'name' or 'email');
		 * 		참조변수('student').멤버메서드('printInfo')();
		 */
		_01_Student iu = new _01_Student();
		iu.studentID = "S001";
		iu.name = "아이유";
		iu.email = "iu@navercom";
		iu.address = "맨하튼";

		System.out.println("=== 멤버변수에 접근해서 출력 ============");
		System.out.println("학생(iu)의 학번: "		+	iu.studentID);
		System.out.println("학생(iu)의 이름: "		+	iu.name);
		System.out.println("학생(iu)의 이메일: "	+	iu.email);
		System.out.println("학생(iu)의 주소: "		+	iu.address);

		System.out.println("=== 멤버메서드에 접근해서 출력 ============");
		iu.printInfo();

		System.out.println("=== 나의정보를 출력 ============");
		_01_Student ydJeon = new _01_Student();
		ydJeon.studentID = "1710022066212";
		ydJeon.name = "전영대";
		ydJeon.email = "antipl1@naver.com";
		ydJeon.address = "마음편히 지낼수있는곳...";

//		System.out.println("학생(ydJeon)의 학번: "		+	ydJeon.studentID);
//		System.out.println("학생(ydJeon)의 이름: "		+	ydJeon.name);
//		System.out.println("학생(ydJeon)의 이메일: "	+	ydJeon.email);
//		System.out.println("학생(ydJeon)의 주소: "		+	ydJeon.address);
		ydJeon.printInfo();
	}
}
