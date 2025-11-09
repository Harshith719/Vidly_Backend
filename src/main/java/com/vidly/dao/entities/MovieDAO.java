package com.vidly.dao.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class MovieDAO {

	@Id
	@Column(name = "_id", nullable = false)
	private String id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "publishdate")
	private LocalDateTime publishDate;

	@Column(name = "numberinstock")
	private Integer numberInStock;

	@Column(name = "genre_id")
	private String genre_id;

	@Column(name = "dailyrentalrate", scale = 1)
	private BigDecimal dailyRentalRate;

}
