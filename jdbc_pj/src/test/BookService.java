package test;

public class BookService {

	public static void main(String[] args) {
		/**! 다형성, 싱글톤 */
		BookDAO dao = BookDAOImpl.getInstance();
		BookDTO dto = new BookDTO();
		dto.setBookNo(1);
		dto.setBookTitle("1Q84");
		dto.setBookAuthor("무라카미 하루키");
		dto.setBookPrice(35000);

		if (dao.bookInsert(dto) == 1) {
			System.out.println("데이터 추가 성공");
		}
		else {
			System.out.println("데이터 추가 실패!");
		}
	}
}
