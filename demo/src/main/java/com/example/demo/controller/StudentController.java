package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.model.Student;

@Controller
public class StudentController {
	@Autowired // usa esta interfaz
	DBConnection db;

	// localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante(Student student, Model model) {
		System.out.println("name:" + student.getNombre());
		db.helloFromWhateverDatabase();

		return "fin";
	}
}
