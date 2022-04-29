package com.qa.readingList.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.readingList.domain.Book;

@Repository
public interface BookRepo extends JpaRepository <Book, Long> {
	
	// Custom queries
	Book findByBookName(String bookName);
	Book findByAuthor(String author);
	Book findByGenre(String genre);
	Book findByReadingStatus(String readingStatus);
	Book findByIsbn(String isbn);
	
}
