package ch07;

public abstract class _01_05_Corporation {

	private _01_05_Corporation[] acquisitions = {};


	public _01_05_Corporation[] getAcquisitions() {
		return acquisitions;
	}
	public void setAcquisitions(_01_05_Corporation[] acquisitions) {
		this.acquisitions = acquisitions;
	}


	public final void listAcquisitions() {
		for (_01_05_Corporation corp : acquisitions) {
			if (corp instanceof _01_05_Nimbula) {
				String simple = corp.getClass().getSimpleName();
				System.out.println(simple + "을(를) 인수했습니다.");
			}
		}
	}
}
