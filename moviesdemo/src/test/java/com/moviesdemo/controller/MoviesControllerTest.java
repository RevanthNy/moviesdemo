package com.moviesdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesdemo.model.Movie;
import com.moviesdemo.repository.MoviesRepository;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;





@EntityScan({"com.moviesdemo.model"})
@EnableJpaRepositories("com.moviesdemo.repository")
@TestPropertySource("classpath:application.properties")

@SpringBootTest
@SpringBootConfiguration
@WebMvcTest(MoviesControllerTest.class)
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
	
	
//	@Test
//	@Transactional
//	public void testAddNewMovieOrShow() throws Exception{		
//		
//		logger.info("entered into adding a movie or show method test ");			
//		String jsonString ="{\"id\":\"2006\",\"title\":\"rabhasa\",\"synopsis\":\"very good movie of ntr recently\",\"releasedYear\":\"2014\",\"mediaType\":\"movie\"}";
//		logger.info(jsonString);
//		MvcResult result = mockMvc.perform(get("http://localhost:8080/demo/add").content(jsonString).
//				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
////		String response = result.getResponse().getContentAsString();
////		logger.info(response);
//	}
	
	@Test
	@Transactional
	public void testGetMovieById() throws Exception{
//		MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/demo/movie/{id}",2002))
//         .andExpect(status().isOk()).andReturn();
//		 Assert.assertEquals("{\"id\":\"2002\",\"title\":\"athadu\",\"synopsis\":\"professional killer story\",\"releasedYear\":\"2007\",\"mediaType\":\"movie\"}\"}", 
//				 mvcResult.getResponse().getContentAsString());
		 
		 mockMvc.perform(get("http://localhost:8080/demo/movie/{id}", 2002))
         .andExpect(status().isOk());
	}
	
	
	
}
