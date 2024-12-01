package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {

	String dbURL =	"jdbc:oracle:thin:@localhost:1521:xe";
	String dbID =	"scott_04";
	String dbPWD =	"tiger";

	ResultSet rs = null;


	/**! 싱글톤, 메서드 재정의*/

	private static BookDAOImpl singleton = new BookDAOImpl();
	private BookDAOImpl(/*default */) {
		
	}
	public static BookDAO getInstance() {
		if (singleton == null) {
			singleton = new BookDAOImpl();
		}

		return singleton;
	}

	public int dmlQuery(Object ...columns) {
		int rowChkCnt = 0;

		String query = "INSERT INTO jdbc_book_tbl (bookno, title, author, price)"
				+ "VALUES(?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPWD)) {
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				for (int i = 1; i <= columns.length; i++) {
//					pstmt.setInt(i, )
				}
//				pstmt.setSQLXML(rowChkCnt, null); /* 나중에 이걸 사용하자 */
//				pstmt.setInt(1,  book.getBookNo());
//				pstmt.setString(2,  book.getBookTitle());
//				pstmt.setString(3,  book.getBookAuthor());
//				pstmt.setInt(4,  book.getBookPrice());
				rowChkCnt = pstmt.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return rowChkCnt;
	}

	@Override
	public int bookInsert(BookDTO book) {
		return dmlQuery (
				book.getBookNo(),
				book.getBookTitle(),
				book.getBookAuthor(),
				book.getBookPrice()
		);
	}

	@Override
	public int bookUpdate(BookDTO book) {
		
		return 1;
	}

	@Override
	public int bookDelete(int bookNo) {
		
		return 1;
	}

	@Override
	public int bookSelect(int bookNo) {
		
		return 1;
	}
}
