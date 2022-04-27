package com.qa.readingList.domain;

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
	
	@Column(name = "bookName", nullable = false)
	private String bookName;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String genre;
	
	@Column(name = "readingStatus", nullable = false)
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
	
	
	
	

}
