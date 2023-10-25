package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {
	// localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante(Student student, Model model) {
		System.out.println("name:" + student.getNombre());

		return "fin";
	}
}
