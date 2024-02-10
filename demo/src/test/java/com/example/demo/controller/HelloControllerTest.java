package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.demo.model.Student;


class HelloControllerTest {
	
	HelloController controller;
	
	@Test
	void testIndexPage() {
		// given
		Model model = new ExtendedModelMap();
		// when
		String redirection = controller.index(model);
		// then
		assertEquals("index", redirection);

		assertNotNull(model);
		assertNotNull(model.getAttribute("student"));

		assertTrue(model.getAttribute("student") instanceof Student);
		assertInstanceOf(Student.class, model.getAttribute("student"));
	}
	@Test
	void testHello() {
		//given
		Model model = new ExtendedModelMap();
		//when
		model.addAttribute("mensaje", "hola desde thymeleaf").toString();
		//then
		assertEquals("hola desde thymeleaf", model.getAttribute("mensaje"));
	}


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controller = new HelloController();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
