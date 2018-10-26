package com.moviesdemo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moviesdemo.model.Movie;

public interface MoviesRepository extends CrudRepository<Movie, Integer> {
	
	Page<Movie> findByTitleIgnoreCaseContaining(@Param("title")String title,Pageable  pageable);
	
	Optional<Movie> findByIdAndMediaType(@Param("id")Integer id,@Param("mediaType")String mediaType);
	
}
