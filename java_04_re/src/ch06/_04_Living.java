package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Living {

	private String name;
	private String live;
	private _04_Living[] stapleFood /* 지금은 일단, 소화기관처럼 쓰고 수정하자... ㅠㅠ */;


	public _04_Living() {/* default */}
	public _04_Living(String name, String live) {
		this.name = name;
		this.live = live;
	}


	public void eat() {
		System.out.println("살아있는건, 살기위한 공급이 필요하니까...");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}

	public _04_Living[] getStapleFood() {
		return stapleFood;
	}
	public void setStapleFood(_04_Living[] stapleFood) {
		this.stapleFood = stapleFood;
	}
}
