package com.vidly.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Movie {
	private String _id;
	private String title;
	private String genreId;
	private Integer numberInStock;
	private BigDecimal dailyRentalRate;
}
