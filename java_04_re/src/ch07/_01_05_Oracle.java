package ch07;

public class _01_05_Oracle extends _01_05_ITCorp implements _01_05_Dev, _01_05_Lang {

	private String lang;


	public _01_05_Oracle(String lang, _01_05_Corporation[] acquisitions) {
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
		System.out.println(lang + "기반으로 클라우드 서비스를 하고있습니다.");
	}

	@Override
	public void dev() {
		System.out.println(lang + "을(를) 개발중이고, 기반으로 운영체제를 개발하고 있습니다.");
	}
}
