package com.qa.readingList.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.readingList.domain.Book;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	// Create
	@Test
	public void createTest() throws Exception {
		Book entry = new Book("The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Book result = new Book(2L, "The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/book/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	// getAll
	@Test
	public void getAllTest() throws Exception {
		Book book = new Book(1L, "Coding for Dummies", "Nikhil Abraham", "Educational", "To Be Read", "ISBN: 9781119293323");
		List<Book> output = new ArrayList<>();
		output.add(book);
		String outputAsJSON = mapper.writeValueAsString(output);
		
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
		
		mvc.perform(get("/book/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	
	// Update
	@Test
	public void updateTest() throws Exception {
		Book entry = new Book("The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		Book result = new Book(1L, "The Book Thief", "Markus Zusak", "Historical Fiction", "To Be Read", "ISBN: 9781784162122");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/book/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(resultAsJSON));
	}
}
