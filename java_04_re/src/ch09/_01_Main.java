package ch09;

import java.io.File;

//AI서비스_웹과정반 @13일차
public class _01_Main {
	/*
	 * 개발환경일때랑 실행환경일때랑 구분해서 경로 지정 다르게 했던것 같다...
	 */
	//..\\File.syn
	final static String PATH = "D:\\DEV\\workspace\\java_04_re\\src\\ch09\\File.syn";

	public static void main(String[] args) {
		try {
			_01_Analyzer analy = new _01_Analyzer(new File(PATH));
		}
		catch (_01_ModifierException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		finally {
			System.out.println("자원을 관리했습니다...");
		}
	}
}
