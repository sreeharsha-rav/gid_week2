package q4;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.ArrayList;

public class bookDAOimpl implements bookDAO {
	@Override
	public void createBook(String bookTitle, double bookPrice) {
		try {
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			System.out.println("\nCreating book with title: " + bookTitle + " and price: " + bookPrice + ".........." + "\n");
			Book bk = new Book(bookTitle, bookPrice);
			session.persist(bk);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readBook(int bookId) {
		try {
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			System.out.println("\nReading book with id: " + bookId + ".........." + "\n");
			Book bk = session.get(Book.class, bookId);
			// Check if the book exists
			if (bk == null) {
				System.out.println("\nBook not found!\n");
			} else {
				System.out.println("\nBook found!\n");
				System.out.println(bk);
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readAllBooks() {
		try {
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			System.out.println("\nReading all books" + ".........." + "\n");
			ArrayList<Book> books = (ArrayList<Book>) session.createQuery("from Book", Book.class).list();
			// Check if there are any books
			if (books.isEmpty()) {
				System.out.println("\nNo books found!\n");
			} else {
				System.out.println("\nBooks found!\n");
				for (Book bk : books) {
					System.out.println(bk);
				}
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBook(int bookId, String bookTitle, double bookPrice) {
		try {
			// Session to get the book
			Session session1 = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx1 = session1.getTransaction();
			tx1.begin();
			Book bk = session1.get(Book.class, bookId);
			// Check if the book exists
			if (bk == null) {
				System.out.println("\nBook not found!\n");
				// End of reading the book
				tx1.commit();
				session1.close();
			} else {
				System.out.println("\nBook found!\n");
				// End of reading the book
				tx1.commit();
				session1.close();
				// Session to update the book
				Session session2 = HibernateUtil.buildSessionFactory().openSession();
				Transaction tx2 = session2.getTransaction();
				tx2.begin();
				bk.setBookTitle(bookTitle);
				bk.setBookPrice(bookPrice);
				System.out.println("\nUpdating book with id: " + bookId + ".........." + "\n");
				session2.merge(bk);
				tx2.commit();
				session2.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteBook(int bookId) {
		try {
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			System.out.println("\nDeleting book with id: " + bookId + ".........." + "\n");
			Book bk = session.get(Book.class, bookId);
			// Check if the book exists
			if (bk == null) {
				System.out.println("\nBook not found!\n");
			} else {
				System.out.println("\nBook found!\n");
				session.remove(bk);
				System.out.println("\nBook deleted successfully!\n");
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
