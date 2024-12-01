package jdbc;

/**
 * <pre>
 * [회원의 정보를 관리하기위한 DTO]
 * 
 * <br>
 * @category DTO
 * </pre>
 */
public class _02_MemberDTO {

	private String id;
	private String password;
	private String gender;
	private String email;
	private String address;


	/**
	 * @return 해당회원의 ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 해당회원의 ID설정
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 해당회원의 비밀번호
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 해당회원의 비밀번호설정
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 해당회원의 성별
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender 해당회원의 성별설정
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return 해당회원의 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email 해당회원의 이메일설정
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return 해당회원의 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 해당회원의 주소설정
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * <pre>
	 * [문자열 형식]
	 * ID: ~
	 * 비밀번호: ~
	 * 성별: ~
	 * E-mail: ~
	 * 주소: ~
	 * </pre>
	 */
	@Override
	public String toString() {
		String str = "";
		str += "ID:\t" + id + '\n';
		str += "비밀번호:\t" + password + '\n';
		str += "성별:\t" + gender + '\n';
		str += "E-mail:\t" + email + '\n';
		str += "주소:\t" + address + '\n';

		return str;
	}
}
