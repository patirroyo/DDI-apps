package com.example.demo.service;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ExamenService {

	public Long ageChecker(Date fechaNacimiento, Date now) {

		Long years = ChronoUnit.YEARS.between(
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()),
				now.toInstant().atZone(ZoneId.systemDefault())
				);

		return years;
	}

	public Integer divisionChecker(Integer dividendo, Integer divisor) {
		return dividendo / divisor;
	}

}
