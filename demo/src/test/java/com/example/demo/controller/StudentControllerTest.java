package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

	StudentController controller;
	
	@Mock
	private StudentService service;
	
	@Test
	void testInsertarEstudiante() {
		//given
		Model model = new ExtendedModelMap();
		Student student = new Student();
		List<Student> listaPrecreada = createMockedList();
		when(service.insertStudent(student)).thenReturn(listaPrecreada);
		//when
		String finPage = controller.insertarEstudiante(student, model);
		//then
		assertEquals("fin", finPage);
		
		assertNotNull(model.getAttribute("estudiantes"));
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));
		
		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());
		System.out.println(model.getAttribute("estudiantes"));
	}

	private List<Student> createMockedList() {
		List<Student> listaPrecreada = new ArrayList<Student>();
		listaPrecreada.add(new Student(1, "ignacio", "bielsa"));
		listaPrecreada.add(new Student(2, "alejandro", "tesan"));
		return listaPrecreada;
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controller = new StudentController();
		controller.setService(service);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
