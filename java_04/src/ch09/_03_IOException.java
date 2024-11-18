package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//AI서비스_웹과정반 @13일차
public class _03_IOException {

	public static void main(String[] args) throws IOException { /* 부모(JVM)에게 예외처리를 떠넘긴다. */
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
		}
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("메시지 : " + e.getMessage());
		}
		finally {
			if (fis != null)
				fis.close();
			System.out.println("finally 문장이므로 항상 수행됩니다.");
		}

		System.out.println("<<< 정상종료 >>>");
	}
}
