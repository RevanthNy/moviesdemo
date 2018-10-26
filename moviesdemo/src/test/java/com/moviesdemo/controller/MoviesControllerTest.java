package com.moviesdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesdemo.model.Movie;
import com.moviesdemo.repository.MoviesRepository;

import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;





@EntityScan({"com.moviesdemo.model"})
@EnableJpaRepositories("com.moviesdemo.repository")
@TestPropertySource("classpath:application.properties")

public class MoviesControllerTest {
	final static Logger logger = LoggerFactory.getLogger(MoviesControllerTest.class);
	private MockMvc mockMvc;
	
	@Autowired
	Movie movie = new Movie();
		
	@Autowired
	MoviesRepository moviesRepository;
		
	@Autowired
	HttpServletRequest request;
		
	@Autowired(required = true)
	ObjectMapper objectMapper;
	
	@Test
	@Transactional
	public void testAddNewMovieOrShow() throws Exception{		
		
		logger.info("entered into adding a movie or show method test ");			
		String jsonString ="{\"id\":\"2006\",\"title\":\"rabhasa\",\"synopsis\":\"very good movie of ntr recently\",\"releaseYear\":\"2014\",\"mediaType\":\"movie\"}";
		MvcResult result = mockMvc.perform(get("http://localhost:8080/demo/add").content(jsonString).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		logger.info(response);
	}
	

}
