package ch03;

import java.util.Scanner;

//AI서비스_웹과정반 @6일차
public class _01_03_ClassMain {

	public static void main(String[] args) {
		/**! 멤버변수·메서드, setter, 접근지정자(public, private) */
		/* Scanner와 조건문(if, switch)과 반복문(do·while, for)을 이용한 클래스의 정보출력 */
		/* 코드를 개발환경에 작성하기전에 생각해본 세부사항 *************
		 * 	class Student {
		 * 		private boolean attendance;
		 * 		private char eduStage; // 'E':Elementary(초등), 'M':Middle(중등), 'H':High(고등), 'Q':Exit(종료), 'another':retyping(재입력)
		 * 		private String dream;
		 * 		private char sincere; // 상, 중, 하
		 * 		private int moodsMeter; // ?/10:MAX_METER
		 * 	
		 * 		public void setEduStage(char edustage) { this.eduStage = eduStage; }
		 * 		public void setDream(String dream) { this.dream = dream; }
		 * 		public void setSincere(char sincere) { this.sincere = sincere; }
		 * 		public void setMoodsMeter(int moodsMeter) { this.moodsMeter = moodsMeter; }
		 * 
		 * 		public void showInfo() { //sysout... }
		 * 	}
		 * 
		 * 하지만, 이대로 되지는 않았다...
		 */
		_01_03_Student whoIs = new _01_03_Student();
		/*====== 현재학생의 저장해놓을 정보를 입력 */
		whoIs.setAttendance(false);
		whoIs.setDream("과학자");
		whoIs.setSincere('상');
		whoIs.setMoodsMeter(7);


		Scanner sc = new Scanner(System.in);
		String cmd = "?"; // 'Q':Exit(종료), 'another':retyping(재입력)
		String eduStage = "?";

		System.out.println("=== 현교육을 받고있는 학생의 정보를 알고싶습니다. ===========");

		do {
			System.out.println("어떤교육을 받고있나요?");
			System.out.println("ex) E:초등, M:중등, H:고등");
			System.out.print("입력: ");
			cmd = sc.next();
			System.out.println(cmd);

			switch (cmd) {
				case "e":
				case "E":
					eduStage = "초등학생";
					whoIs.setEduStage(eduStage);
					System.out.println(eduStage + "이네요.");
					whoIs.showInfo();
					break;
				case "m":
				case "M":
					eduStage = "중학생";
					whoIs.setEduStage(eduStage);
					System.out.println(eduStage + "이네요.");
					whoIs.showInfo();
					break;
				case "h":
				case "H":
					eduStage = "고등학생";
					whoIs.setEduStage(eduStage);
					System.out.println(eduStage + "이네요.");
					whoIs.showInfo();
					break;
				default:
					System.out.println("입력이 잘못되었습니다: " + cmd);
					break;
			}
		}
		while (
			!(cmd.contains("e") || cmd.contains("E") ||
			  cmd.contains("m") || cmd.contains("M") ||
			  cmd.contains("h") || cmd.contains("H"))
		);
		/* 
		 * 문자열은 '=='로 비교가 안된다... String도 클래스이기때문에...
		 * 'cmd'라는 변수도 사실은 참조변수라 주소값을 갖고있다...
		 * 그러니, 당연히 cmd == "e"이런식의 비교가 안된다...
		 * 편하게 "..."이렇게 쓰다보니... 기본형이라고 생각했다...
		 */

		sc.close();
	}
}
