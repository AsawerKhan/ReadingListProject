package com.qa.readingList.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.readingList.domain.Book;
import com.qa.readingList.repo.BookRepo;

@SpringBootTest
public class BookServiceUnitTest {

	@Autowired
	private BookService service;
	
	@MockBean
	private BookRepo repo;
	
	// getAll
	@Test
	public void getAllTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	// getByID
	@Test
	public void getByIdTest() {
		Optional<Book> OptionalOutput = Optional.of(new Book(1L,"Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323"));
		Book output = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);
		
		assertEquals(output, this.service.getById(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
	// Create
	@Test
	public void createTest() {
		Book input = new Book("Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		Book output = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	// Update
	@Test
	public void updateTest() {
		Book input = new Book("Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		Optional<Book> existing = Optional.of(new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323"));
		Book output = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.update(1L, input));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}
	
	// Delete
	@Test
	public void deleteTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
}
