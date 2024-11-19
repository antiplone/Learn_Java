package ch10;

//AI서비스_웹과정반 @14일차
/* p193  
* [면접] 싱글톤패턴
* - 인스턴스를 단 하나만 생성하는 디자인 패턴
* - static을 응용하여 프로그램 전반에서 사용하는 동일한 인스턴스를 하나만 생성하는 방식
* - 접근할 클래스에 여러 메서드가 있을 때, 외부 클래스가 해당 메서드에 접근할 때마다 
*   객체를 생성할 필요없이 getInstance()를 통해 참조변수만 리턴받아 접근한다.
*   열번, 백번을 호출해도 항상 같은 주소의 인스턴스가 반횐된다.
*  
* 싱글톤패턴 생성
* - 1단계. 디폴트생성자를 private으로 만들기
* - 2단계. 클래스 내부에 static으로 유일한 인스턴스 생성하기
* - 3단계. 외부에서 참조할 수 있는 public 메서드 만들기
* 
* 호출
* - 접근클래스명 참조변수 = 접근클래스명.getInstance();
* 예) _08_Company com1 = _08_Company.getInstance();  // 클래스명.메서드명
*/
public class _01_Company {

	public String worker;	// 홍길동

	/* - 2단계. 클래스 내부에 static으로 유일한 인스턴스 생성하기 */
	private static _01_Company singleton = new _01_Company();
	/* - 1단계. 디폴트생성자를 private으로 만들기
	 * 싱글톤으로 쓸때는 객체생성을 막는다.
	 */
	private _01_Company() { System.out.println("_01_Company 객체생성"); }
	/* - 3단계. 외부에서 참조할 수 있는 public 메서드 만들기 */
	public static _01_Company getInstance() {
		/* ~ 추가내용 : 다중처리시 처리법
		 * 스레드의 synchronized(동기화)를 추가시 lock처리 => 성능저하
		 * synchronized를 추가안하면 동시에 접근할 수 있으므로 충돌발생해서 객체생성이 안될수 있으므로 if문 추가
		 * public static synchronized _01_Company getInstance() {
		 * 그래서 null체크를 하는이유
		 */
		if (singleton == null)
			singleton = new _01_Company();

		return singleton;
	}

	public void gotoWork(String worker) {
		System.out.println(worker + " 출근했다.");
	}
	
	public void work(String worker) {
		System.out.println(worker + " 일한다.");
	}

	public void gotoLunch(String worker) {
		System.out.println(worker + " 점심먹는다.");
	}
	
	public void gotoHome(String worker) {
		System.out.println(worker + " 퇴근한다.");
	}
}
