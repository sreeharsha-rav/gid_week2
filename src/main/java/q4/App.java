package q4;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int choice = 0;
		int numBooks;
		int bookId;
		String bookTitle;
		double bookPrice;
		
		Scanner sc = new Scanner(System.in);
		bookDAOimpl bk_dao = new bookDAOimpl();
		
		// Menu
		while (true) {
			System.out.println("\n*********** Book Management CRUD Menu ***********");
			System.out.println("1. Create book");
			System.out.println("2. Read book");
			System.out.println("3. Read all books");
			System.out.println("4. Update book");
			System.out.println("5. Delete book");
			System.out.println("6. Exit");
			System.out.println("************************************\n");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("\nHow many books do you want to create?");
				numBooks = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < numBooks; i++) {
					System.out.println("Creating book " + (i + 1) + "...");
					System.out.println("Enter book title: ");
					bookTitle = sc.nextLine();
					System.out.println("Enter book price: ");
					bookPrice = sc.nextDouble();
					sc.nextLine();
					bk_dao.createBook(bookTitle, bookPrice);
				}
				break;
			case 2:
				System.out.println("\nEnter book id to read: ");
				bookId = sc.nextInt();
				sc.nextLine();
				bk_dao.readBook(bookId);
				break;
			case 3:
				bk_dao.readAllBooks();
				break;
			case 4:
				System.out.println("\nEnter book id to update: ");
				bookId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new book title: ");
				bookTitle = sc.nextLine();
				System.out.println("Enter new book price: ");
				bookPrice = sc.nextDouble();
				bk_dao.updateBook(bookId, bookTitle, bookPrice);
				break;
			case 5:
				System.out.println("\nEnter book id to delete: ");
				bookId = sc.nextInt();
				bk_dao.deleteBook(bookId);
				break;
			case 6:
				System.out.println("\nExiting...");
				System.out.println("************************************\n");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("\nInvalid choice. Enter again.\n");
				break;
			}
		}
	}
}
