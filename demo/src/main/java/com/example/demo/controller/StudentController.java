package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.model.Student;
import com.example.demo.model.StudentRowMapper;

@Controller
public class StudentController {
	@Autowired // usa esta interfaz
	// @Qualifier(value = "postgres") // me conectas el que tenga este valor
	// automáticamente
	DBConnection db;

	@Autowired
	JdbcTemplate jdbcTemplate;

	// localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante(Student student, Model model) {
		System.out.println("name:" + student.getNombre());
		// TODO comprobar si el estudiante existe, si no existe hacer insert, si existe
		// un update

		if (student.getId() == null) {
			jdbcTemplate.update("insert into students(nombre, apellido) values(?, ?);", student.getNombre(),
					student.getApellido());
		} 
		else {
			// si existe un update
			jdbcTemplate.update("UPDATE students SET nombre = ?, apellido = ? WHERE id=?;",
					student.getNombre(),
					student.getApellido(), student.getId());
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		
		model.addAttribute("estudiantes", lista);
		return "fin";
	}

	// localhost:8080/updateStudent/alberto
	@RequestMapping("/updateStudent/{id}") // le paso un path variable en este caso nombre
	public String actualizarEstudiante(@PathVariable Integer id, Model model) {
		Student stud = jdbcTemplate.queryForObject("SELECT * FROM STUDENTS WHERE id=?", new StudentRowMapper(),
				new Object[] { id }
				);

				System.out.println(stud.getNombre() + " " + stud.getApellido());
				model.addAttribute("student", stud);
				return "index";
	}

	@RequestMapping("/deleteStudent/{id}") // le paso un path variable en este caso nombre
	public String borrarEstudiante(@PathVariable Integer id, Model model) {
		jdbcTemplate.update("DELETE FROM STUDENTS WHERE id=?", new Object[] { id });

		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());

		model.addAttribute("estudiantes", lista);
		return "fin";
	}

	// http://localhost:8080/searchStudent?search=gorka
	@RequestMapping("/searchStudent")
	public String buscarEstudiantes(@RequestParam("search") String userInput, Model model) {
		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ? OR apellido = ?",
				new StudentRowMapper(), userInput, userInput);
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}

		model.addAttribute("estudiantes", lista);
		return "fin";
	}

	@SuppressWarnings("deprecation")
	public Student findById(long id) {
		return jdbcTemplate.queryForObject("select * from STUDENTS where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Student>(Student.class));
	}
}
