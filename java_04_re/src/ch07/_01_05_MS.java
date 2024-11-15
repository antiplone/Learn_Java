package ch07;

public class _01_05_MS extends _01_05_ITCorp implements _01_05_Dev, _01_05_Lang {

	private String lang;

	public _01_05_MS(String lang, _01_05_Corporation[] acquisitions) {
		this.lang = lang;
		setAcquisitions(acquisitions);
	}


	@Override
	public String getLang() {
		return lang;
	}
	@Override
	public void setLang(String lang) {
		this.lang = lang;
	}


	@Override
	public void service() {
		System.out.println(lang + "기반으로 운영체제, 하드웨어, 클라우드, AI 서비스를 하고있습니다.");
	}

	@Override
	public void dev() {
		System.out.println(lang + "을(를) 개발중이고, 기반으로 운영체제와 AI를 개발하고 있습니다.");
	}
}
