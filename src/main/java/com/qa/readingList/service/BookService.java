package com.qa.readingList.service;

import org.springframework.stereotype.Service;

import com.qa.readingList.repo.BookRepo;

@Service
public class BookService {
	
	private BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}
	
	

}
