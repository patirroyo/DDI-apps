package com.example.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

//@Data // con esto se hacen los getter y los setter
@Getter
@Entity
public class Examen {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer dividendo;
	private Integer divisor;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	public Examen() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDividendo() {
		return dividendo;
	}

	public void setDividendo(Integer dividendo) {
		this.dividendo = dividendo;
	}

	public Integer getDivisor() {
		return divisor;
	}

	public void setDivisor(Integer divisor) {
		this.divisor = divisor;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Examen(Integer id, Integer dividendo, Integer divisor, Date fechaNacimiento) {
		super();
		this.id = id;
		this.dividendo = dividendo;
		this.divisor = divisor;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", dividendo=" + dividendo + ", divisor=" + divisor + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	


}
