package ch07;

public class _05_SmartPhone extends _05_PDA implements _05_Mobile {

	@Override
	public void sendSMS() {
		System.out.println("친구에게 문자를 보냈습니다.");
	}

	@Override
	public void receiveSMS() {
		System.out.println("친구에게 문자를 받았습니다.");
	}

	@Override
	public int calculate(int x, int y) {
		return (x * y);
	}
}
