package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Dragon extends _04_Creature {

	public _04_Dragon(/* default */) {
		_04_Living[] foods = {
//			new _04_Goblin(),
			new _04_Human("베이비 존슨", "멀고도 먼 섬나라"),
			new _04_Human("배스킨", "아주 조그마한 마을"),
			new _04_Human("라빈스", "아주 조그마한 마을"),
			new _04_Human("앨리스", "이상한나라"),
		};

		setStapleFood(foods);
	}

	public _04_Dragon(String name, String live, _04_Living[] stapleFood) {
		super(name, live, stapleFood);
	}


	@Override
	public void eat() {
		for (_04_Living l : getStapleFood()) {
			System.out.println(l.getLive() + "출신의 " + l.getName() + "를 먹었습니다.");
		}
	}

	public void fire() {
		System.out.println("화염을 뿜어냅니다.");
	}
}
