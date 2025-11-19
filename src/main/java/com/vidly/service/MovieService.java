package com.vidly.service;

import java.util.List;

import com.vidly.dao.entities.MovieDAO;
import com.vidly.domain.Movie;

public interface MovieService {

	List<MovieDAO> getMovies();

	MovieDAO getMoviesById(String id);

	MovieDAO addMovie(Movie movie);

	MovieDAO updateMovie(Movie movie);

	String deleteMovie(String _id);

}