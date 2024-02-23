package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "book_price")
	private double bookPrice;
	
	// Default constructor
	public Book() {
	}
	
	// Parameterized constructor
	public Book(String bookTitle, double bookPrice) {
		super();
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}
	
	// Getters
	public int getBookId() {
		return bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public double getBookPrice() {
		return bookPrice;
	}
	
	// Setters
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	@Override
	public String toString() {
		return "Book: {\n" 
				+ "\tID: " + bookId + "\n" 
				+ "\tTitle: " + bookTitle + "\n" 
				+ "\tPrice: " + bookPrice + "\n"
				+ "\t}";
	}
}
