package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.demo.model.Student;

@SpringBootTest
class StudentRepositoryTest2 {
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	StudentRepository repo;

	@Test
	void testInsert() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		
		
	}

	@Test
	void testUpdate() {

		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		student.setNombre("Fernando2");
		student.setApellido("Del Pino2");
		assertDoesNotThrow(() -> repo.update(student));
		Student student2 = repo.findAll().get(0);
		assertEquals("Fernando2", student2.getNombre());
		assertEquals("Del Pino2", student2.getApellido());
		
	}

	@Test
	void testDelete() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		assertDoesNotThrow(() -> repo.delete(5));
		assertTrue(repo.findAll().isEmpty());
	}

	@Test
	void testFindAll() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		assertFalse(repo.findAll().isEmpty());
		
	}

	@Test
	void testFindById() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		Student student2 = repo.findById(5);
		assertEquals(student, student2);
	
	}

	@Test
	void testSearchByNombreOrApellido() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
		assertFalse(repo.searchByNombreOrApellido("Fernando").isEmpty());
		assertFalse(repo.searchByNombreOrApellido("Del Pino").isEmpty());
		assertTrue(repo.searchByNombreOrApellido("Fernando2").isEmpty());
		assertTrue(repo.searchByNombreOrApellido("Del Pino2").isEmpty());
	
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		JdbcTestUtils.deleteFromTables(template, "students");//cada vez que hacemos un test, limpiamos la base de datos
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
}
