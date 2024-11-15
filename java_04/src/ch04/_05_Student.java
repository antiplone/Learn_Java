package ch04;

//AI서비스_웹과정반 @8일차
/*
 * static 변수 = 클래스 변수 = 공유변수
 * - 프로그램이 실행되어 메모리에 올라갔을 때 딱 한번 데이터영역 메모리 공간에 할당된다.
 * 객체를 생성하지 않고, 바로 클래스명으로 접근가능하다.
 * 인스턴스마다 생성되는 변수가 아니라 클래스에 속해 한번만 생성되는 변수이고,
 * 여러 인스턴스가 공유한다.
 * 인스턴스가 생성되지 않아도 사용할 수 있기 때문에 클래스명.static 변수, 클래스명.static 메서드 사용가능
 * - static 변수나 메서드는 static 메서드에서 호출가능
 *   static 메서드에서 인스턴스 변수나 메서드를 호출시 컴파일 오류가 난다.
 *   static 메서드는 프로그램 실행시 자동으로 메모리에 올라가나, 일반메서드는 객체를 생성해야 메모리에 올라간다. 
 */
public class _05_Student {

	static int serialNum = 1000;
	private int studentID;	/* 학번 */
	private String name;	/* 이름 */

	public _05_Student() { /* default */
		serialNum += 1;
		this.studentID = serialNum;
	}


	public int getStudentID() { /* getter */
		return studentID;
	}
	public void setStudentID(int studentID) { /* setter */
		this.studentID = studentID;
	}

	public String getName() { /* getter */
		return name;
	}
	public void setName(String name) { /* setter */
		this.name = name;
	}

	public static int getSerialNum() { /* static은 static끼리(멤버변수·메서드x) */
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		_05_Student.serialNum = serialNum;
	}
}
