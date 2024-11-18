package ch09;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//AI서비스_웹과정반 @13일차
public class _01_IOException extends _01_OverrideThrows {

	public static void main(String[] args) {
		
	}

	@Override /* 	재정의'할' 메서드도 구현이 되어야 가능 */
	public void fileInput()/* throws IOException */
	{/* [Override throws] 인터페이스, 추상클래스도 가능
	  * 재정의'할' 메서드가 throws가 있어도,
	  * 재정의'된' 메서드에서는 throws를 굳이, 안해도 된다.
	  */
		FileInputStream fis = null;
		String txtPath = "a.txt";
		txtPath.charAt(0); /* throw IndexOutOfBoundsException */
		try {
			fis = new FileInputStream(txtPath);
		}
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("메시지 : " + e.getMessage());
		}
		finally {
			if (fis != null) {
				/*
				 * FileInputStream의 메서드 close는
				 * 예외를 떠넘긴 상태이기 때문에 예외처리(try-catch)를 해주던가
				 * 아니면, 한번더 상위로 떠넘기기위해
				 * 현재의 메서드에 throws처리를 해야한다.
				 */
//				fis.close();
			}
			System.out.println("<<< finally >>>");
		}

//		try (FileInputStream fi = new FileInputStream(txtPath)) {
//			
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println("<<< 정상종료 >>>");
	}
}
