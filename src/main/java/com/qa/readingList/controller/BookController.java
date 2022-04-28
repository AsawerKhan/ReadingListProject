package com.qa.readingList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baespring.domain.User;
import com.qa.readingList.domain.Book;
import com.qa.readingList.service.BookService;



@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {
	
	private BookService service;

	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	// Get ALL
	@GetMapping("/getAll") // localhost:8080/book/getAll
	public ResponseEntity<List<Book>> getAll() {
		return new ResponseEntity<List<Book>>(service.getAll(), HttpStatus.OK);
	}
	
	// Get by ID
	@GetMapping("/getById/{id}") // localhost:8080/book/getById/id
	public ResponseEntity<Book> getById(@PathVariable long id) {
		return new ResponseEntity<Book>(service.getById(id), HttpStatus.OK);
	}
	
	// Get by Book Name
	@GetMapping("/getByBookName/{bookName}") // localhost:8080/book/getByBookName/bookName
	public ResponseEntity<Book> getByBookName(@PathVariable String bookName) {
		return new ResponseEntity<Book>(service.getByBookName(bookName), HttpStatus.OK);
	}
	
	// Get by Author
	@GetMapping("/getByAuthor/{author}") // localhost:8080/book/getByAuthor/author
	public ResponseEntity<Book> getByAuthor(@PathVariable String author) {
		return new ResponseEntity<Book>(service.getByAuthor(author), HttpStatus.OK);
	}
	
	// Get by Genre
	@GetMapping("/getByGenre/{genre}") // localhost:8080/book/getByGenre/genre
	public ResponseEntity<Book> getByGenre(@PathVariable String genre) {
		return new ResponseEntity<Book>(service.getByGenre(genre), HttpStatus.OK);
	}
	
	// Get by Reading Status
	@GetMapping("/getReadingStatus/{readingStatus}") // localhost:8080/book/getByReadingStatus/readingStatus
	public ResponseEntity<Book> getByReadingStatus(@PathVariable String readingStatus) {
		return new ResponseEntity<Book>(service.getByReadingStatus(readingStatus), HttpStatus.OK);
	}
	
	// Get by ISBN
	@GetMapping("/getByISBN/{isbn}") // localhost:8080/book/getByISBN/isbn
	public ResponseEntity<Book> getByISBN(@PathVariable String isbn) {
		return new ResponseEntity<Book>(service.getByISBN(isbn), HttpStatus.OK);
	}
	
	// Create (Post)
	
	// Update (Put)
	
	// Delete

}
