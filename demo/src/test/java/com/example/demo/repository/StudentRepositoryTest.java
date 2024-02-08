package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.demo.model.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
	StudentRepository repo;
	
	@Test
	void testInsertShouldBeOk() {
		
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.save(student));// función anónima

	}
	@Test
	void testInsertTheSameStudentTwice() {
		Student student = new Student(5, "Fernando", "Del Pino");
		
		try {//esta es la vieja forma
				// repo.insert(student);
				// repo.insert(student);
			repo.save(student);
			repo.save(student);
			//aqui jamas debería llegar
			fail("este código no se debe ejecutar");
		}
		catch (Exception e) {
		}
		//manera actual
		assertThrows(DuplicateKeyException.class, 
				() -> {
					// repo.insert(student);
					// repo.insert(student);
					repo.save(student);
					repo.save(student);
				}, "Name too long"
			);
	}
	@Test
	void testInsertStudentNameTooLong() {
		Student student = new Student(5, "FernandoFernandoFernandoFernando"
				+ "FernandoFernandoFernandoFernandoFernandoFernandoFernando"
				+ "FernandoFernandoFernandoFernando", "Del Pino");
		assertThrows(DataIntegrityViolationException.class, 
				() -> {
					repo.save(student);
					// repo.insert(student);
				}, "Name too long"
			);

	}
//	public animmmous() {
//	return     repo.insert(student);
//	}
	@Test
	void testFindAll() {
		List<Student> lista = (List<Student>) repo.findAll();
		//assertEquals(2, lista.size());
		assertTrue(lista.isEmpty());
		
		repo.save(new Student(1, "Alberto", "Saz"));
		lista = (List<Student>) repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());

	}
	
	@Test
	void testDelete() {
		List<Student> lista = (List<Student>) repo.findAll();
		assertTrue(lista.isEmpty());
		
		repo.save(new Student(1, "Alberto", "Saz"));
		lista = (List<Student>) repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());
		
		repo.deleteById(1);
		lista = (List<Student>) repo.findAll();
		assertTrue(lista.isEmpty());
		
		
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		// repo = new StudentRepository();
		// assertNotNull(template);
		// repo.setJdbcTemplate(template);
		JdbcTestUtils.deleteFromTables(template, "Students");//cada vez que hacemos un test, limpiamos la base de datos
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}


}
