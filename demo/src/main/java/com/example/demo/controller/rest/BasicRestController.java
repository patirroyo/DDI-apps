package com.example.demo.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/")
public class BasicRestController {

	@PostMapping
	@RequestMapping(value = "/post")
	public Message post(@RequestBody Message message) {
		return message;
	}

	@GetMapping
	@RequestMapping(value = "/get")
	public ResponseEntity<Message> get(@RequestParam String id) {
		Message message = new Message(Integer.valueOf(id));
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@DeleteMapping
	@RequestMapping(value = "/delete/{id}/")
	public Message delete(@PathVariable Integer id) {
		return new Message(id);
	}
	
	
}
