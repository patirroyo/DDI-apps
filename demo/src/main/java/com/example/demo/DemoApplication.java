package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.StudentController;



@SpringBootApplication
/*public class DemoApplication {


	 * public static void main(String[] args) {
	 * SpringApplication.run(DemoApplication.class, args); }
	 */
public class DemoApplication implements CommandLineRunner
	{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	StudentController repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}
}

