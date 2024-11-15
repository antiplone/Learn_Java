package ch06;

//AI서비스_웹과정반 @9일차
public class _02_Car {
	/* ** 멤버 ******
	 * 변수
	 */
	private String kind;	/* 종류		소방차	경찰차 */
	private int speed;		/* 스피드		80		100 */
	private String color;	/* 색깔		red		white */


	/* 생성자 */
	public _02_Car(/* default */) {
		System.out.println("<<< _02_Car 부모클래스 >>>");
	}


	/* get·setter */
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	/* 메서드 */
	public void printIfo() {
		System.out.println("종류:\t" + kind); /* getKind() */
		System.out.println("속도:\t" + speed); /* getSpeed() */
		System.out.println("색깔:\t" + color); /* getColor() */
	}
}
