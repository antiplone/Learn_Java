package ch09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//AI서비스_웹과정반 @13일차
public class _01_Analyzer {
	
	private File target;


	public _01_Analyzer(File target) throws _01_ModifierException {
		this.target = target;

		try (Scanner sc = new Scanner(target)) {
			while(sc.hasNext()) {
				String syn = sc.next();
				checkSyntax(syn);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void checkSyntax(String syn) throws _01_ModifierException {
		switch (syn) {
			case "public":
				System.out.println("public 접근제어자 구문처리...");
				break;
			case "private":
				System.out.println("private 접근제어자 구문처리...");
				break;
			default:
				throw new _01_ModifierException("올바른 구문이 아닙니다.");
		}
	}
}
