package jdbc;

public interface _02_MemberDAO {

	/**
	 * 로그인을 시도합니다.
	 * 
	 * @param id 시도할 ID
	 * @param password ID의 비밀번호
	 */
	_02_MemberDTO login(String id, String password); /* 로그인되었습니다. */
	/**
	 * 회원가입을 시도합니다.
	 * 
	 * @param dto 회원가입에 사용할 정보
	 * @return 처리여부
	 */
	int memberInsert(_02_MemberDTO dto);
	/**
	 * 회원정보 수정을 시도합니다.
	 * 
	 * @param dto 수정할 정보
	 * @return 처리여부
	 */
	int memberUpdate(_02_MemberDTO dto);
	/**
	 * 회원탈퇴를 시도합니다.
	 * 
	 * @param id 가입된 ID
	 * @return 처리여부
	 */
	int memberDelete(String id);
	/**
	 * 가입된 회원을 조회합니다.
	 * 
	 * @param id 조회할 회원ID
	 * @return 조회된 회원정보(없으면, null)
	 */
	_02_MemberDTO memberSelect(String id);
}
