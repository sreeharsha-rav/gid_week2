package q4;

public interface bookDAO {
	public void createBook(String bookTitle, double bookPrice);
	public void readBook(int bookId);
	public void readAllBooks();
	public void updateBook(int bookId, String bookTitle, double bookPrice);
	public void deleteBook(int bookId);
}
