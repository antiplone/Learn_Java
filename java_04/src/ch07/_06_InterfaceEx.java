package ch07;

public class _06_InterfaceEx {

	public static void main(String[] args) {
		I06 a06 = (I06)new A06(); /* B06을 상속을 받았다. */
//		I06 a06 = InstanceManager.getInstance(); /* I06을 상속을 받았다. */
		I06 a061 = InstanceManager.getInstance(); /* I06을 상속을 받았다. */
		System.out.println(a06);
		System.out.println(a061);
		a06.methodB();
	}
}

class A06 extends B06 {

	public void methodA() {
		/* 다형성 적용 methodB() 호출 */
		I06 i06 = new B06();
		i06.methodB();
	}
}

/* 부모I */
interface I06 {

	public void methodB();
}

/* 자식Cls */
class B06 implements I06 {

	@Override
	public void methodB() {
		System.out.println("B06 클래스 - methodB()");
	}
}

class InstanceManager {
	/**[디자인패턴(Design pattern]<br><br>
	 * 팩토리 메서드(factory method)
	 * - 객체를 생성하는 정적 팩토리메서드이다.
	 *    이것은 디자인 패턴의 하나로서 객체를 생성하는 부분을 자식클래스에게 위임하는 패턴이다.
	 *    즉 new 연산자를 호출하여 객체를 생성하는 코드를 자식클래스에게 위임하는 패턴이다.
	 *    사용하는 이유는 하나의 클래스가 변경되었을 경우에 다른 클래스의 변경을 최소화하기 위함이다.
	 *    
	 *    팩토리 메서드 이름으로 많이 사용하는 것은 getInstance()이다.
	 *    인터페이스에서 팩토리 메서드를 제공할 때 정적메서드를 사용하게 된다.
	 *    static이므로 클래스명.정적메서드로 접근
	 */
	public static I06 getInstance() {
		return new B06(); /* => 다형성 적용 */
	}
}
