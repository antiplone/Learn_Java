package ch06;

//AI서비스_웹과정반 @10일차
public class _04_Creature extends _04_Living {

	private String traits;


	public _04_Creature() {/* default */}
	public _04_Creature(String name, String live, _04_Living[] stapleFood) {
		super(name, live);
		setStapleFood(stapleFood);
	}


	public String getTraits() {
		return traits;
	}
	public void setTraits(String traits) {
		this.traits = traits;
	}
}
