package test;

public interface BookDAO {

	int bookInsert(BookDTO book);
	int bookUpdate(BookDTO book);
	int bookDelete(int bookNo);
	int bookSelect(int bookNo);
}
