package com.qa.readingList.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.readingList.domain.Book;
import com.qa.readingList.service.BookService;

@WebMvcTest
public class BookControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private BookService service;
	
	// getAll
	@Test
	public void getAllTest() throws Exception {
		Book book = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		List<Book> output = new ArrayList<>();
		output.add(book);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/book/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	// getByID
	@Test
	public void getByIdTest() throws Exception {
		Book entry = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(1L)).thenReturn(entry);
		
		mvc.perform(get("/book/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	
	// Create
	@Test
	void createTest() throws Exception {
		Book entry = new Book("The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/book/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
	}
	
	// Update
	@Test
	public void updateTest() throws Exception {
		Book entry = new Book("The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/book/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	// Delete
	@Test
	public void deleteTest() throws Exception {
		Mockito.when(this.service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/book/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(this.service.delete(2L)).thenReturn(false);
	
		mvc.perform(delete("/book/delete/5")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isInternalServerError());
	}
}
