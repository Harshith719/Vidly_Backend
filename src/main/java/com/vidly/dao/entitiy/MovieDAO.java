package com.vidly.dao.entitiy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class MovieDAO {

	@Id
	@Column(name = "_id", nullable = false)
	private String _id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "publishdate")
	private LocalDateTime publishDate;

	@Column(name = "numberinstock")
	private Integer numberInStock;
	
	@Column(name = "dailyrentalrate", scale = 1)
	private BigDecimal dailyRentalRate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "genre_id")
	private GenreDAO genre;
}
