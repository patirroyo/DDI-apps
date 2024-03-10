package com.example.demo.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MasterMind;

@RestController
@RequestMapping(value = "/api/")
public class MasterMindRestController {
	public MasterMind masterMind = new MasterMind();


	@GetMapping
	@RequestMapping(value = "/generateKey")
	public ResponseEntity<MasterMind> create(@RequestBody MasterMind masterMind) {
		masterMind.setGeneratedKey("12345");


		return new ResponseEntity<>(masterMind, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(value = "/changeTries")
	public ResponseEntity<MasterMind> changeTries(@RequestParam int tries) {

		masterMind.setTries(tries);

		return new ResponseEntity<>(masterMind, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(value = "/answerSize/{size}/")
	public ResponseEntity<MasterMind> changeSize(@PathVariable int size) {

		masterMind.setSize(size);

		return new ResponseEntity<>(masterMind, HttpStatus.OK);
	}
	@GetMapping
	@RequestMapping(value = "/checkAnswer")
	public ResponseEntity<MasterMind> checkAnswer(@RequestBody MasterMind masterMind) {
		return new ResponseEntity<>(masterMind, HttpStatus.ACCEPTED);
	}
	
	
}
