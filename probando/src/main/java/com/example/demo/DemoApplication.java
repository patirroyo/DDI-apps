package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.BrewController;



@SpringBootApplication
/*public class DemoApplication {


	 * public static void main(String[] args) {
	 * SpringApplication.run(DemoApplication.class, args); }
	 */
public class DemoApplication implements CommandLineRunner
	{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	BrewController repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("birra id 1 -> {}", repository.findById(1));
	}
}

