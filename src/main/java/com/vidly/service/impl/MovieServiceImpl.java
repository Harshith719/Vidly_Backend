package com.vidly.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidly.dao.entities.GenreDAO;
import com.vidly.dao.entities.MovieDAO;
import com.vidly.dao.repository.MovieRepository;
import com.vidly.domain.Movie;
import com.vidly.service.MovieService;
import com.vidly.util.IdGenerator;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieDAO> getMovies() {
		List<MovieDAO> allMovies = movieRepository.findAllByOrderByPublishDateDesc();
		return allMovies;
	}

	@Override
	public MovieDAO getMoviesById(String id) {
		MovieDAO movie = movieRepository.findById(id).orElse(null);
		return movie;
	}

	@Override
	public MovieDAO addMovie(Movie movie) {
		MovieDAO dao = new MovieDAO();
		BeanUtils.copyProperties(movie, dao);
		//set the id for the new movie
		dao.set_id(IdGenerator.generate());
		dao.setPublishDate(LocalDateTime.now());
		//set the genre id
		GenreDAO genre = new GenreDAO();
		genre.set_id(movie.getGenreId());
		dao.setGenre(genre);
		
		MovieDAO savedMovie = movieRepository.save(dao);
		return savedMovie;
	}

	@Override
	public MovieDAO updateMovie(Movie movie) {
		MovieDAO dao = getMoviesById(movie.get_id());
		LocalDateTime publishDate = dao.getPublishDate();
		BeanUtils.copyProperties(movie, dao);
		dao.setPublishDate(publishDate);
		
		MovieDAO savedMovie = movieRepository.save(dao);
		return savedMovie;
	}

	@Override
	public String deleteMovie(String _id) {
		movieRepository.deleteById(_id);
		return _id;
	}
}
