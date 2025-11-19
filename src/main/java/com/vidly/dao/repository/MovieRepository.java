package com.vidly.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.dao.entities.MovieDAO;

public interface MovieRepository extends JpaRepository<MovieDAO, String> {
	
	public List<MovieDAO> findAllByOrderByPublishDateDesc();
}
