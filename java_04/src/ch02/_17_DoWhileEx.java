package ch02;

//AI서비스_웹과정반 @5일차
public class _17_DoWhileEx {
	public static void main(String[] args) {
		/*
		 * [ do-while ]
		 * => {} 안의 문장을 무조건 한번 수행한 후에 조건식이 참이면 반복, 거짓이면 빠져나간다.
		 * 
		 * do {
		 *     수행문1;
		 *     ...
		 * } while(조건식);    
		 * 수행문2;
		 */
		int num = 1;
		int sum = 0;
		
		do {
			sum += num;
			num++;
		} while(num <= 10);

		System.out.println("1부터 10까지의 합은 " + sum + "입니다.");

		/*
		 * 메뉴를 선택하는 방식에서 사용함.
		 * ex)
		 * 1. 로그인
		 * 2. 회원가입
		 * 3. 회원탈퇴
		 * 4. 종료
		 */
		String menu = "로그인";
		boolean state = true;
		do {
			switch (menu) {
				case "로그인":
					System.out.println("로그인 되었습니다.");
					menu = "종료";
					break;
				case "회원가입":
					System.out.println("가입완료");
					menu = "종료";
					break;
				case "회원탈퇴":
					System.out.println("회원탈퇴함...");
					menu = "종료";
					break;
				case "종료":
					System.out.println("종료되었습니다.");
					state = false;
					break;
			}
		} while(state);
	}
}
