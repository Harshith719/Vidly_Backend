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
import com.vidly.domain.Movie;
import com.vidly.service.MovieService;
import com.vidly.util.IdGenerator;

@RestController
public class MoviesController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDAO> getMovies() {
		return movieService.getMovies();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieDAO getMovieById(@PathVariable String id) {
		MovieDAO movie = movieService.getMoviesById(id);
		return movie;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/movies" , produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieDAO addMovie(@RequestBody Movie movie ) {
		MovieDAO savedMovie = movieService.addMovie(movie);
		return savedMovie;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieDAO updateMovie(@RequestBody Movie movie, @PathVariable String id) {
		MovieDAO updatedMovie = movieService.updateMovie(movie);
		return updatedMovie;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/movies/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletedMovie(@PathVariable String id) {
		return movieService.deleteMovie(id);
	}
}
