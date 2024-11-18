package ch09;

//AI서비스_웹과정반 @13일차
public class _06_IDFormatTest {

	private String userID;


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) throws _06_IDFormatException {
		if (userID == null) {
			throw new _06_IDFormatException("아이디는 null일 수 없습니다.");
		}
		else if (userID.length() < 8 || userID.length() > 20) {
			throw new _06_IDFormatException("아이디는 8자 이상 20자 이하로 쓰세요");
		}

		this.userID = userID;
	}
}
