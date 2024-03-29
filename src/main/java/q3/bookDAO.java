package q3;

public interface bookDAO {
	public void createTable();
	public void create(int bookId, String bookTitle, double bookPrice);
	public void read(int bookId);
	public void readAll();
	public void update(int bookId, String bookTitle, double bookPrice);
	public void delete(int bookId);
}
