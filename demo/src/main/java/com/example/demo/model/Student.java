package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data // con esto se hacen los getter y los setter
@Getter
public class Student {
	private Integer id;
	private String nombre;
	private String apellido;

}
