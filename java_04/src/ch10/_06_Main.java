package ch10;

public class _06_Main {

	public static void main(String[] args) {
		_06_SpreadArgs sargs = new _06_SpreadArgs();
		sargs.callArgs("칰", "피");
		sargs.callArgs2("칰", "피", "연어스테이크", "파스타");
		sargs.callArgs3("점수", 70, 80, 50, 100);
//		sargs.callArgsCustom(0, 11.3, "");
	}
}
