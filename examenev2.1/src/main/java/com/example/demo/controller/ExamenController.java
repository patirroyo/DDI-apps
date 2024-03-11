package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

@Controller
public class ExamenController {
	
	@Autowired
	ExamenService service;
	@RequestMapping("/navigate")
	public String navigate(@RequestParam(name = "to") String route, Model model) {
		model.addAttribute("examen", new Examen());
		if("divisionChecker".equals(route)) {
			return "divisionChecker";
		}if ("ageChecker".equals(route)) {
			return "ageChecker";
		}
		return "error";
	}

	@GetMapping("/age")
	public String age(@ModelAttribute Examen examen, Model model) {
		System.out.println(examen);
		Long age = 0L;
		try {
			age = service.ageChecker(examen.getFechaNacimiento(),new Date())	;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

				
		if(age<18) {
			return "underAge";
		}else if (age > 18 && age < 67) {
			return "getAJobNow";
		}else if(age > 67) {
			return "retired";
		}
		return "error";
	}
	
	
	@PostMapping("/division")
	public String division(@ModelAttribute Examen examen, Model model) {
		System.out.println(examen);
		try {
			Integer result = service.divisionChecker(examen.getDividendo(),examen.getDivisor())	;
			model.addAttribute("msg", result);
		} catch (Exception e) {
			return "error";
		}
		return "resultOperation";
	}
	
	
	// localhost:8080/
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	public void setService(ExamenService service) {
		this.service = service;
	}

}
