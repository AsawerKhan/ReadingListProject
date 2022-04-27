package com.qa.readingList.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	// Private Properties
	
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
	
	
	
	

}
