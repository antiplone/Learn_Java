package jdbc;

import java.util.Scanner;

public class _02_MemberService {

	static _02_MemberDAO dao;
	static _02_MemberDTO dto;
	static Scanner sc;


	public static void main(String[] args) {

		sc = new Scanner(System.in);
		dao = _02_MemberDAOImpl.getInstance();
		dto = new _02_MemberDTO();
		int cmd = 0;
		do {

			cmdHelp();
			cmd = sc.nextInt();
			sc.nextLine();
			switch (cmd) {
				case 1:
					memberInsert();
					break;
				case 2:
					login();
					break;
				case 3:
					memberUpdate();
					break;
				case 4:
					memberDelete();
					break;
				case 5:
					memberSelect();
					break;

				default:
					System.out.println("시스템을 종료합니다.");
			}

			System.out.println("--------------------------------");
		} while (cmd > 0 && cmd < 6);

		sc.close();
	}


	public static void cmdHelp() {
		System.out.println("====================================================");
		System.out.println("1.회원가입 2.로그인 3.정보수정 4.회원탈퇴 5.정보조회 0.종료");
		System.out.println("====================================================");
		System.out.print("입력: ");
	}

	public static void dtoInit() {
		dto.setId("");
		dto.setPassword("");
		dto.setGender("");
		dto.setEmail("");
		dto.setAddress("");
	}

	public static void memberInsert() {
		System.out.println("<<< 회원가입 >>>");

		System.out.print("ID? ");
		dto.setId(sc.next());

		System.out.println("비밀번호? ");
		dto.setPassword(sc.next());

		System.out.println("성별? ");
		dto.setGender(sc.next());

		System.out.println("이메일? ");
		dto.setEmail(sc.next());

		System.out.println("주소? ");
		dto.setAddress(sc.next());

		/* Success row_num count */
		boolean checkSignIn = (dao.memberInsert(dto) == 1); /* 나중에 ternary Exception */

		if (checkSignIn)
			System.out.println("회원가입 성공");
		else System.out.println("회원가입실패...");

		dtoInit();
	}

	public static void login() {
		System.out.println("<<< 로그인 >>>");

		System.out.print("ID? ");
		String id = sc.next();

		System.out.println("비밀번호? ");		
		String pwd = sc.next();

		_02_MemberDTO mem = dao.login(id, pwd);
		if (mem != null)
			dto = mem;
	}

	public static void memberUpdate() {
		System.out.println("<<< 정보수정 >>>");

		System.out.println("비밀번호? ");
		dto.setPassword(sc.next());
//		dto("여성");
//		dto("h7788@daum.net");
//		dto("강남구 타워팰리스");

		if (dao.memberUpdate(dto) > 0) {
			System.out.println("회원수정 성공");
			dto.setPassword(dto.getPassword());
		}
		else {
			System.out.println("회원수정 실패...");
		}
	}

	public static void memberDelete() {
		System.out.println("<<< 회원탈퇴 >>>");

		switch (dao.memberDelete(dto.getId())) {
			case 0:
				System.out.println("회원삭제 실패...");
				break;
			case 1:
				System.out.println("회원삭제 성공");
				break;
		}

		dtoInit();
	}

	public static void memberSelect() {
		System.out.println("<<< 정보조회 >>>");

		dto = dao.memberSelect(dto.getId());
		if (dto != null)
			System.out.println(dto.toString());
		else {
			System.out.println("조회를 실패했습니다.");
		}

		dtoInit();
	}
}
