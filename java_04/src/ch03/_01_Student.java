package ch03;

//AI서비스_웹과정반 @6일차
/**!
 * 클래스 : 객체에 대한 설계도, 디자인
 * 		- 멤버변수(속성) + 멤버메서드(기능, 동작)
 * ClassType name = '?new ClassType()'; // '?~': 'new'하는순간 메모리 내부의 주소(ex: 어디동 어디번지 어디건물)에 객체가 만들어진다.
 * 'name'은 주소값(어디동·번지·건물)이 들어있다.
 * 접근법은 name.멤버변수(property, attribute)·메서드(method, function)
 * 'new'를 하면 'name'은 heap메모리에 올라간다
 * 객체 : 클래스를 바탕으로 만들어진 힙(Heap)메모리 공간
 */
public class _01_Student/* _01_Student라는 클래스가 메모리에 들어있어야 호출가능 */ {
	/**~ 멤버변수(속성) */
	String studentID;	/*ex* 학번 S001 */
	String name;		/*ex* 이름 아이유 */
	String email;		/*ex* 이메일 iu@naver.com */
	String address;		/*ex* 주소 맨하튼 */

	/**~ 멤버메서드(기능, 동작) */
	public void printInfo() {
		/**! 멤버변수 정보 출력 */
		System.out.println("학번: " + studentID);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
		System.out.println("주소: " + address);
	}
}
