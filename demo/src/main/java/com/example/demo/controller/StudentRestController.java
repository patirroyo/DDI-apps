package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController // para crear el RestController copiamos el controller y cambiamos esta etiqueta
@RequestMapping("/api") // todas la peticiones irán a /api
public class StudentRestController {


	@Autowired
	StudentService service;

	// localhost:8080/insertStudent
	// @RequestMapping(value = "/insertStudent", method = POST)
	@PostMapping("/insertStudent")
	public ResponseEntity<List<Student>> insertarEstudiante(@RequestBody Student student) {// quitamos el
																										// model y
																							// cambiamos el retorno
																			// para devolver el objeto


		List<Student> lista = service.insertStudent(student);
		if (lista.isEmpty())
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Student>>(lista, HttpStatus.CREATED);
	}


	// localhost:8080/updateStudent/alberto
	@RequestMapping("/updateStudent/{id}") // le paso un path variable en este caso nombre
	public Student actualizarEstudiante(@PathVariable Integer id) {

		Student stud = service.updateStudentList(id);


		return stud;
	}


	@RequestMapping("/deleteStudent/{id}") // le paso un path variable en este caso nombre
	public List<Student> borrarEstudiante(@PathVariable Integer id) {
		List<Student> lista = service.deleteStudent(id);

		return lista;
	}


	// http://localhost:8080/searchStudent?search=gorka
	@RequestMapping("/searchStudent")
	public List<Student> buscarEstudiantes(@RequestParam("search") String userInput) {
		List<Student> lista = service.searchStudent(userInput);

		return lista;
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> lista = service.findAll();
		return lista;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}

}
