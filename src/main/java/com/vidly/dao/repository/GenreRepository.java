package com.vidly.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.dao.entities.GenreDAO;

public interface GenreRepository extends JpaRepository<GenreDAO, String> {

}
