package com.vidly.movies.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.dao.entities.GenreDAO;
import com.vidly.dao.repository.GenreRepository;

@RestController
public class GenreController {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@RequestMapping(path = "/genres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GenreDAO> getAllGenres() {
		List<GenreDAO> allGenres = genreRepository.findAll();
		return allGenres;
	}
	
	@RequestMapping(path = "/genres/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenreDAO getGenre(@PathVariable String id) {
		GenreDAO genre = genreRepository.findById(id).orElse(null);
		return genre;
	}
	
}
