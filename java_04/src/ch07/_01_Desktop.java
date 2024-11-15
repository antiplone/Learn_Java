package ch07;

//AI서비스_웹과정반 @11일차
public /* 묵시적이면, concrete(구체적인) */ class _01_Desktop extends _01_Computer {

	@Override
	public void display() {
		System.out.println("_01_Desktop - display()");
	}

	@Override
	public void typing() {
		System.out.println("_01_Desktop - typing()");
	}
}
