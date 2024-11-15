package ch08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//AI서비스_웹과정반 과제@12일차
/* [플젝]
 * 1. id, pwd 5건을 hashtable에 저장(hashMap에 저장) - put
 * 2. 콘솔로부터 id, password를 입력받는다.(로그인을 위해)
 *    1과 2를 비교해서
 * 3. 아이디가 없으면 "입력하신 아이디가 존재하지 않습니다." 출력
 *    아이디가 있으면 비밀번호와 비교해서 일치시 "로그인 성공" 출력
 *                                불일치시 "비밀번호가 불일치" 출력
 * 4. id입력시 Q나 q를 입력시 종료  :  System.exit(0) // 정상종료, break, return;
 * 문자열 비교 =>  입력값.equals(비교값)  
 * 
 *  key      value    
 *    id       password
 * "park"   "park1234"
 * "kim"    "kim1234"
 * "lee"    "lee1234"
 * "son"    "son1234"
 * "choi"   "choi1234"
 */
public class _04_LoginHashMapEx {

	private static Map<String, String> hashtable;

	public static void main(String[] args) {
		Map<String, String> hashtable = new HashMap<String, String>();
		_04_LoginHashMapEx.hashtable = hashtable;
		hashtable.put("park", "park1234");
		hashtable.put("kim", "kim1234");
		hashtable.put("lee", "lee1234");
		hashtable.put("son", "son1234");
		hashtable.put("choi", "choi1234");

		Scanner sc = new Scanner(System.in);
		/* begin(Scanner) */
		String id;
		boolean validID;
		do {
			cmdHelp();
			System.out.print("아이디 입력: ");
			id = sc.next();
			validID = checkID(sc, id); /* stream을 다중으로 안쓰려고 'sc'를 넘김 */

			System.out.println();

		} while (!validID);
		/* end(Scanner) */
		sc.close();
	}

	/**
	 * 아이디가 맞는지 검사합니다. [46번째 줄]
	 * 
	 * @param sc 입력을 이어서받기위해 'Scanner'를 넘김
	 * @param id 아이디를 비교하기위한 입력값을 전달받습니다.
	 * @return 검사여부를 돌려받습니다.
	 */
	public static boolean checkID(Scanner sc, String id) {
		sessionOut(id);

		if (hashtable.containsKey(id)) {
			String pwd;
			boolean validPass;
			do {
				cmdHelp();
				System.out.print("패스워드 입력: ");
				pwd = sc.next();
				validPass = checkPass(pwd);
			} while (!validPass);

			return true;
		}

		System.out.println("입력하신 아이디가 존재하지 않습니다.");
		return false;
	}

	/**
	 * 비밀번호가 맞는지 검사합니다. [72번째 줄]
	 * 
	 * @param pwd 비밀번호를 비교하기위한 입력값을 전달받습니다.
	 * @return 검사여부를 돌려받습니다.
	 */
	public static boolean checkPass(String pwd) {
		sessionOut(pwd);

		if (hashtable.containsValue(pwd)) {
			System.out.println("로그인 성공");
			return true;
		}

		System.out.println("비밀번호가 맞지않습니다.");
		return false;
	}

	/**
	 * 어떤입력을 해야하는지 알려줍니다. [43번째, 69번째 줄]
	 */
	public static void cmdHelp() {
		System.out.println("['Q'나 'q'를 입력시 종료됩니다.]");
	}

	/**
	 * 'Q'나 'q'가 'cmd'에 입력이 되면, 종료가됩니다. [63번째, 89번째 줄]
	 * 
	 * @param cmd 종료여부를 검사하기위해 입력받습니다.
	 */
	public static void sessionOut(String cmd) {
		if (cmd.equals("Q") || cmd.equals("q")) {
			System.out.println("세션을 종료합니다...");
			System.exit(0);
		}
	}
}
