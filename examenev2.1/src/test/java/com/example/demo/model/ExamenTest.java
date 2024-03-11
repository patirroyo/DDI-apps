package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExamenTest {


	Examen examen;

	@Test
	void testExamen() {
		
		assertFalse(examen == null);
	}
	
	@Test
	void testGetId() {	
		assertEquals(null, examen.getId());
		Examen examen2 = new Examen(1, null, null, null);
		assertEquals(1, examen2.getId());
	}
	
	@Test
	void testSetId() {
		examen.setId(1);
		assertNotNull(examen.getId());
		assertEquals(1, examen.getId());
		
	}
	
	@Test 
	void testSetIdNull() {
        examen.setId(null);
        assertNull(examen.getId());
	}
	

	@Test
	void testGetDividendo() {
		examen.getDividendo();
		assertEquals(null, examen.getDividendo());
		Examen examen2 = new Examen(1, 1, null, null);
		assertEquals(1, examen2.getDividendo());
	}
	

	@Test
	void testSetDividendo() {
		examen.setDividendo(1);
		assertNotNull(examen.getDividendo());
		assertEquals(1, examen.getDividendo());
	}

	@Test
	void testGetDivisor() {
		examen.getDivisor();
		assertEquals(null, examen.getDivisor());
		Examen examen2 = new Examen(1, 1, 1, null);
		assertEquals(1, examen2.getDivisor());
	}

	@Test
	void testSetDivisor() {
		examen.setDivisor(1);
		assertNotNull(examen.getDivisor());
		assertEquals(1, examen.getDivisor());
	}
	
	void testSetDivisiorZero() {
		examen.setDivisor(0);
		assertNotNull(examen.getDivisor());
		assertEquals(0, examen.getDivisor());
	}

	@Test
	void testGetFechaNacimiento() {
		examen.getFechaNacimiento();
		assertEquals(null, examen.getFechaNacimiento());
		Examen examen2 = new Examen(1, 1, 1, new Date());
		assertNotNull(examen2.getFechaNacimiento());
	}

	@Test
	void testSetFechaNacimiento() {
		examen.setFechaNacimiento(new Date());
		assertNotNull(examen.getFechaNacimiento());
		examen.setFechaNacimiento(null);
		assertNull(examen.getFechaNacimiento());
		Date fecha = new Date();
		fecha.UTC(1988, 5, 4, 0, 0, 0);
		examen.setFechaNacimiento(fecha);
		assertEquals(fecha, examen.getFechaNacimiento());
	
	}

	@Test
	void testExamenIntegerIntegerIntegerDate() {
		Examen examen2 = new Examen(1, 1, 1, new Date());
		assertNotNull(examen2);
	
	}

	@Test
	void testToString() {
		Examen examen2 = new Examen(1, 1, 1, new Date());
		assertNotNull(examen2.toString());
		assertEquals("Examen [id=1, dividendo=1, divisor=1, fechaNacimiento=" + examen2.getFechaNacimiento() + "]", examen2.toString());
	}

	@Test
	void testEqualsObject() {
		Examen examen2 = new Examen(1, 1, 1, new Date());
		Examen examen3 = new Examen(1, 1, 1, new Date());
		assertFalse(examen2.equals(examen3));
		assertTrue(examen2.equals(examen2));
	
	}
	
	@Test
	void testHashCode() {
		Examen examen2 = new Examen(1, 1, 1, new Date());
		Examen examen3 = new Examen(1, 1, 1, new Date());
		assertNotEquals(examen2.hashCode(), examen3.hashCode());
		assertEquals(examen2.hashCode(), examen2.hashCode());
	}
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		examen = new Examen();
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
}
