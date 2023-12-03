package com.example.demo.model;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;

@Data // con esto se hacen los getter y los setter
@Getter
public class Beer {
	private Integer id;
	private String nombre;
	private Date fechaLanzamiento;
	private Boolean is_old;
	private Integer brewery_id;
	private Brewery brewery;

}
