package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_MemberDAOImpl implements _02_MemberDAO {

	String dbURL =	"jdbc:oracle:thin:@localhost:1521:xe"; /* 오라클사용함@hostName:PORT:SID(Serial) */
	String dbID =	"scott_04";
	String dbPWD =	"tiger";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	static _02_MemberDAOImpl singleton = new _02_MemberDAOImpl();
	private _02_MemberDAOImpl(/* default */) {}
	public synchronized static _02_MemberDAOImpl getInstance() {
		if (singleton == null)
			singleton = new _02_MemberDAOImpl();

		return singleton;
	}


	@Override
	public _02_MemberDTO login(String id, String password) {
		_02_MemberDTO mem = memberSelect(id);

		if (mem != null) {
			if (mem.getPassword().equals(password))
				System.out.println(mem.getId() + "을(를) 로그인하였습니다.");
			else System.out.println("비밀번호가 틀렸습니다.");
		}
		else System.out.println("존재하지않는 아이디입니다.");

		return mem;
	}

	@Override
	public int memberInsert(_02_MemberDTO dto) {
		if (dto.getId().isBlank()) {
			if (dto.getPassword().isBlank()) {
				
				if (dto.getGender().isBlank()) {

					if (dto.getEmail().isBlank()) {
						
						if (dto.getAddress().isBlank()) {
							return 0;
						}
					}
				}
			}
		}

		String query = "INSERT INTO jdbc_member_tbl(id, password, gender, email, address ) "
					+ "VALUES(?, ?, ?, ?, ?)";
		/* + "VALUES('test', 't1234', '여성', 'test@gmail.com', '맨하튼');" */

		int insertCnt = 0;
		try {

			conn = DriverManager.getConnection(dbURL, dbID, dbPWD);  // DB연결
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  dto.getId());
			pstmt.setString(2,  dto.getPassword());
			pstmt.setString(3,  dto.getGender());
			pstmt.setString(4,  dto.getEmail());
			pstmt.setString(5,  dto.getAddress());

			insertCnt = pstmt.executeUpdate(); /* DML(I, U, D) */
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				if (pstmt != null ) pstmt.close();
				if (conn != null ) conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return insertCnt;
	}

	@Override
	public int memberUpdate(_02_MemberDTO dto) {
		String query = "UPDATE jdbc_member_tbl "
					+ "SET password=?, gender=?, email=?, address=? "
					+ "WHERE id=?";

		int updateCnt = 0;
		try {

			conn = DriverManager.getConnection(dbURL, dbID, dbPWD);  // DB연결
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  dto.getPassword());
			pstmt.setString(2,  dto.getGender());
			pstmt.setString(3,  dto.getEmail());
			pstmt.setString(4,  dto.getAddress());
			pstmt.setString(5,  dto.getId());

			updateCnt = pstmt.executeUpdate(); /* DML(I, U, D) */
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				if (pstmt != null ) pstmt.close();
				if (conn != null ) conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateCnt;
	}

	@Override
	public int memberDelete(String id) {
		String query = "DELETE jdbc_member_tbl "
					+ "WHERE id=?";

		int deleteCnt = 0;
		try {

			conn = DriverManager.getConnection(dbURL, dbID, dbPWD);  // DB연결
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			deleteCnt = pstmt.executeUpdate(); /* DML(I, U, D) */
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				if (pstmt != null ) pstmt.close();
				if (conn != null ) conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deleteCnt; /* true */
	}

	@Override
	public _02_MemberDTO memberSelect(String id) {
		String query = "SELECT * FROM jdbc_member_tbl WHERE id=?";

		_02_MemberDTO dto = null;
		try {

			conn = DriverManager.getConnection(dbURL, dbID, dbPWD);  // DB연결
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new _02_MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				if (pstmt != null ) pstmt.close();
				if (conn != null ) conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* executeQuery */

		return dto;
	}
}
