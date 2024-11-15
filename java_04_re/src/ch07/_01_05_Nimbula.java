package ch07;

public class _01_05_Nimbula extends _01_05_ITCorp implements _01_05_Dev {

	@Override
	public void service() {
		System.out.println("클라우드 서비스중인 회사입니다.");
	}

	@Override
	public void dev() {
		System.out.println("클라우드 운영체제를 개발하고있는 회사입니다.");
	}
}
