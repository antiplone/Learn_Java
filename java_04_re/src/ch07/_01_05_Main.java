package ch07;

public class _01_05_Main {

	public static void main(String[] args) {
//		_01_Corporation corp = new _01_Corporation() {/* 무기명으로 관련 객체 생성가능 */
//			
//			@Override
//			public void dev() {
//				// TODO Auto-generated method stub
//				
//			}
//		};

		_01_05_Corporation[] acquisitions = { new _01_05_Nimbula() };
		_01_05_ITCorp corp = new _01_05_Oracle("Java", acquisitions);
		_01_05_Dev devCorp = (_01_05_Dev)corp;

		devCorp.dev();
		corp.service();
		corp.listAcquisitions();

//		acquisitions = { new _01_05_GitHub() };
		corp = new _01_05_MS("C#", acquisitions);
		devCorp = (_01_05_Dev)corp;

		devCorp.dev();
		corp.service();
		corp.listAcquisitions();

		corp = new _01_05_Apple("Swift");
		devCorp = (_01_05_Dev)corp;

		devCorp.dev();
		corp.service();
		corp.listAcquisitions();
	}
}
