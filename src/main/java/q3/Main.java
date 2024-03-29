package q3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bookDAO bk = new bookDAOimpl();
		int id;
		String title;
		double price;
		
		// Create books table
		bk.createTable();
		
		while (true) {
			System.out.println("\n*********** Book Management CRUD Menu ***********");
			System.out.println("1. Create book");
			System.out.println("2. Read book");
			System.out.println("3. Read all books");
			System.out.println("4. Update book");
			System.out.println("5. Delete book");
			System.out.println("6. Exit");
			System.out.println("************************************");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("How many books do you want to create?");
				int numBooks = sc.nextInt();
				sc.nextLine();
				// Create books
				for (int i = 0; i < numBooks; i++) {
					System.out.println("Creating book " + (i + 1) + "...");
					System.out.print("Enter book ID: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter book title: ");
					title = sc.nextLine();
					System.out.print("Enter book price: ");
					price = sc.nextDouble();
					sc.nextLine();
					bk.create(id, title, price);
				}
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("Reading a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.read(id);
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Reading all books...");
				bk.readAll();
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("Updating a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new book title: ");
				title = sc.nextLine();
				System.out.print("Enter new book price: ");
				price = sc.nextDouble();
				sc.nextLine();
				bk.update(id, title, price);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("Deleting a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.delete(id);
				System.out.println();
				break;
			case 6:
				System.out.println();
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println();
				System.out.println("\n" + "Invalid choice. Please try again.");
				System.out.println();
				break;
			}
		}
	}
}
