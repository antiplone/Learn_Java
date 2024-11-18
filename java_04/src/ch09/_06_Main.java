package ch09;

//AI서비스_웹과정반 @13일차
public class _06_Main {

	public static void main(String[] args) {
		_06_IDFormatTest test = new _06_IDFormatTest();

		String userID = null;
		try {
			test.setUserID(userID);
		}
		catch (_06_IDFormatException e ) {
			System.out.println(e.getMessage());
		}

		userID = "1234567";
		try {
			test.setUserID(userID);
		}
		catch (_06_IDFormatException e ) {
			System.out.println(e.getMessage());
		}
	}
}
