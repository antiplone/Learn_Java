package ch06;

//AI서비스_웹과정반 @9일차
public class _02_Main {

	public static void main(String[] args) {
		System.out.println("<<< _02_FireCar 객체생성 + setter로 값전달 >>>");
		_02_FireCar fire = new _02_FireCar();
		fire.setKind("소방차");
		fire.setSpeed(80);
		fire.setColor("red");

		fire.printIfo();
		fire.water();

		System.out.println("-----------------");

		System.out.println("<<< _02_PoliceCar 객체생성 + setter로 값전달 >>>");
		_02_PoliceCar police = new _02_PoliceCar();
		police.setKind("경찰차");
		police.setSpeed(100);
		police.setColor("white");

		police.printIfo();
		police.siren();
	}
}
