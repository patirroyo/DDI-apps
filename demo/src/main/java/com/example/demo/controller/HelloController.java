package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	// localhost:8080/hola
	@RequestMapping("/hola")
	public String hello(Model model) {
		model.addAttribute("mensaje", "hola desde thymeleaf");
		return "hola";
	}

	// localhost:8080/hola
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("mensaje", "hola desde thymeleaf");
		return "hola";
	}

}
