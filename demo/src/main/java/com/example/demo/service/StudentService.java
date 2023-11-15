package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentRowMapper;
import com.example.demo.repository.StudentRepository;

@Service // component, repository esas tres anotaciones hacen que solo se cree un objeto
			// de esta clase y se vaya usando conforme hace falta
public class StudentService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	StudentRepository studentRepo;

	public List<Student> insertStudent(Student student) {
		System.out.println("name:" + student.getNombre());
		if (student.getId() == null) {
			studentRepo.insert(student);
		} else {
			// si existe un update
			studentRepo.update(student);
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Student> lista = studentRepo.findAll();
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}


	public Student updateStudent(Integer id) {
		Student stud = jdbcTemplate.queryForObject("SELECT * FROM STUDENTS WHERE id=?", new StudentRowMapper(),
				new Object[] { id });

		System.out.println(stud.getNombre() + " " + stud.getApellido());
		return stud;
	}

	public List<Student> deleteStudent(Integer id) {
		jdbcTemplate.update("DELETE FROM STUDENTS WHERE id=?", new Object[] { id });

		List<Student> lista = studentRepo.findAll();
		return lista;
	}

	public List<Student> searchStudent(String userInput) {
		List<Student> lista = jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ? OR apellido = ?",
				new StudentRowMapper(), userInput, userInput);
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}

	public Student searchStudentById(long id) {
		return jdbcTemplate.queryForObject("select * from STUDENTS where id=?",
				new BeanPropertyRowMapper<Student>(Student.class), new Object[] { id });
	}
}
