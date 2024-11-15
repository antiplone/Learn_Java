package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Human extends _04_Living {

	public _04_Human(String name, String live) {
		super(name, live);
	}


	@Override
	public void eat() {
		super.eat();
	}

	public void fight(_04_Creature target) {
		System.out.println(target.getName() + "와 싸우기 시작합니다.");
	}
}
