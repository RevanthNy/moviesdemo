package com.moviesdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviesdemo.controller.MoviesController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesdemoApplicationTests {
	
	@Autowired
    private MoviesController moviesController;


	@Test
	public void contextLoads() {
		 assertThat(moviesController).isNotNull();
	}

}
