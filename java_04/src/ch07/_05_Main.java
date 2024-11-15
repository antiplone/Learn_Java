package ch07;

public class _05_Main {

	public static void main(String[] args) {
		int va1 = 10, va2 = 20;
		_05_PDA pda = new _05_SmartPhone();
		_05_SmartPhone sphone = (_05_SmartPhone)pda;

		System.out.println((new _05_PDA()).calculate(va1, va2));
		System.out.println(pda.calculate(va2, va1));
		pda.play();
		sphone.receiveSMS();
		pda.stop();
		sphone.sendSMS();
	}
}
