package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data // con esto se hacen los getter y los setter
@Getter
public class Brewery {
	private Integer id;
	private String nombre;

}
