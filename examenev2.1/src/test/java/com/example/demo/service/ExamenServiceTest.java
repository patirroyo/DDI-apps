package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;

class ExamenServiceTest {
	
	ExamenService examenService;


	@Test
	void testAgeChecker() {
		Date fechaNacimiento = new Date(1990, 1, 1);
		Date now = new Date(2024, 2,12);
		assertEquals(34, examenService.ageChecker(fechaNacimiento, now));
		
	}
	@Test
	void testAgeNegative() {
		Date fechaNacimiento = new Date(2024, 1, 1);
		Date now = new Date(1990, 2, 12);
		assert(examenService.ageChecker(fechaNacimiento, now) < 0);
	}
	
	@Test
	void testNoAge() {
		Date fechaNacimiento = null;
		Date now = new Date(2024, 1, 1);
		assertThrows( NullPointerException.class, 
				() -> {
					 examenService.ageChecker(fechaNacimiento, now);
				}, "Fecha nula"
			);
	}

	@Test
	void testDivisionChecker() {
		assertEquals(2, examenService.divisionChecker(4, 2));
	}
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		examenService = new ExamenService();
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
}
