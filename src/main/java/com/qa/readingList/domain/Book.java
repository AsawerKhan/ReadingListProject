package com.qa.readingList.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	// Private properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String bookName;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private String readingStatus;
	
	@Column(nullable = true, unique = true)
	private String isbn;
	
	
	
	
	// Default constructor
	
	public Book() {}
	
	
	
	// Constructor for creating and inserting
	
	public Book(String bookName, String author, String genre, String readingStatus, String isbn) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.readingStatus = readingStatus;
		this.isbn = isbn;
	}



	// Constructor for reading, selecting and testing
	
	public Book(long id, String bookName, String author, String genre, String readingStatus, String isbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.readingStatus = readingStatus;
		this.isbn = isbn;
	}


	// Getters and setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReadingStatus() {
		return readingStatus;
	}
	public void setReadingStatus(String readingStatus) {
		this.readingStatus = readingStatus;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	// toString
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", genre=" + genre
				+ ", readingStatus=" + readingStatus + ", isbn=" + isbn + "]";
	}


	// hashCodes and equals
		// hashCodes
	
	@Override
	public int hashCode() {
		return Objects.hash(author, bookName, genre, id, isbn, readingStatus);
	}


		// equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookName, other.bookName)
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(isbn, other.isbn)
				&& Objects.equals(readingStatus, other.readingStatus);
	}
}
