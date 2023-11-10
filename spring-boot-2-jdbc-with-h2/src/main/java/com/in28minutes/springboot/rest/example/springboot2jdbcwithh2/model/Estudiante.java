package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Estudiante {
	private long id;
	private String nombre;
	private String mail;

	public Estudiante() {
		super();
	}

	public Estudiante(long id, String nombre, String mail) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
	}

	public Estudiante(String nombre, String mail) {
		super();
		this.nombre = nombre;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return String.format("estudiante [id=%s, nombre=%s, email=%s]", id, nombre, mail);
	}
}