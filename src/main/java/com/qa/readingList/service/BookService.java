package com.qa.readingList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baespring.domain.User;
import com.qa.readingList.domain.Book;
import com.qa.readingList.repo.BookRepo;

@Service
public class BookService {
	
	private BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}
	
	// Get ALL
	public List<Book> getAll(){
		return repo.findAll();
	}
	
	// Get by ID
	public Book getById(long id) {
		return repo.findById(id).get(); // .get will either get the User if exists or throw NoSuchElementException
	}
	
	// Get by Book Name
	public Book getByBookName(String bookName) {
		return repo.findByBookName(bookName);
	}
	
	// Get by Author
	public Book getByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	
	// Get by Genre
	public Book getByGenre(String genre) {
		return repo.findByGenre(genre);
	}
	
	// Get by Reading Status
	public Book getByReadingStatus(String readingStatus) {
		return repo.findByReadingStatus(readingStatus);
	}
	
	// Get by ISBN
	public Book getByIsbn(String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	// Create a Book (Post)
	public Book create(Book book) {
		return repo.saveAndFlush(book);
	}
	
	// Update a Book (Put)
	public Book update(long id, Book book) {
		Book existing = repo.findById(id).get();
		existing.setBookName(book.getBookName());
		existing.setAuthor(book.getAuthor());
		existing.setGenre(book.getGenre());
		existing.setReadingStatus(book.getReadingStatus());
		existing.setIsbn(book.getIsbn());
		return repo.saveAndFlush(existing);
	}
	
	// Delete a Book
	
	
	

}
