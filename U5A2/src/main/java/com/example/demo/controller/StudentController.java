package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired // usa esta interfaz
	// @Qualifier(value = "postgres") // me conectas el que tenga este valor
	// automáticamente
	DBConnection db;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StudentService service;

	// localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante(Student student, Model model) {


		List<Student> lista = service.insertStudent(student);
		
		model.addAttribute("estudiantes", lista);
		return "fin";
	}


	// localhost:8080/updateStudent/alberto
	@RequestMapping("/updateStudent/{id}") // le paso un path variable en este caso nombre
	public String actualizarEstudiante(@PathVariable Integer id, Model model) {

		Student stud = service.updateStudentList(id);

		model.addAttribute("student", stud);

		return "index";
	}


	@RequestMapping("/deleteStudent/{id}") // le paso un path variable en este caso nombre
	public String borrarEstudiante(@PathVariable Integer id, Model model) {
		List<Student> lista = service.deleteStudent(id);

		model.addAttribute("estudiantes", lista);
		return "fin";
	}


	// http://localhost:8080/searchStudent?search=gorka
	@RequestMapping("/searchStudent")
	public String buscarEstudiantes(@RequestParam("search") String userInput, Model model) {
		List<Student> lista = service.searchStudent(userInput);

		model.addAttribute("estudiantes", lista);
		return "fin";
	}

	public Student findById(long id) {
		Student stud = service.searchStudentById(id);
		return stud;
	}

}
