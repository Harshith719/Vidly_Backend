package com.vidly.movies.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.dao.entities.MovieDAO;
import com.vidly.dao.repository.MovieRepository;

@RestController
public class MoviesController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDAO> getMovies() {
		List<MovieDAO> allMovies = movieRepository.findAll();
		return allMovies;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieDAO getMovieById(@PathVariable String id) {
		MovieDAO movie = movieRepository.findById(id).orElse(null);
		return movie;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/movies" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String addMovie(@RequestBody MovieDAO movie ) {
		MovieDAO savedMovie = movieRepository.save(movie);
		 String id = savedMovie.getId();
		 return id;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateMovie(@RequestBody MovieDAO movie, @PathVariable String id) {
		movie.setId(id);
		MovieDAO savedMovie = movieRepository.save(movie);
		return savedMovie.getId();
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletedMovie(@PathVariable String id) {
		if(movieRepository.findById(id).orElse(null) == null) {
			return "movie doesn't exist in DB";
		}
		movieRepository.deleteById(id);
		return "movie deleted Successfully";
	}
}
