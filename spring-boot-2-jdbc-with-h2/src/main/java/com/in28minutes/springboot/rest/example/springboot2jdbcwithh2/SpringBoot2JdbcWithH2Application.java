package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.model.Estudiante;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.repository.EstudianteJdbcRepository;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

		private Logger logger = LoggerFactory.getLogger(getClass());

		@Autowired
		EstudianteJdbcRepository repository;

		public static void main(String[] args) {
			SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
		}

		@Override
	    public void run(String...args) throws Exception {
			logger.info("estudiante id 10001 -> {}", repository.findById(10001));
			logger.info("all users 1 --> {}", repository.findAll());
			logger.info("inserting -> {}",
					repository.insert(new Estudiante(10010, "Nacho Bielsa", "sitiene@amiguis.es")));

			logger.info("update 10001 -> {}",
					repository.update(new Estudiante(10001, "Alberto Saz", "dicequetiene@amiguis.es")));

			repository.deleteById(10002);

			logger.info("all users 2 -> {}", repository.findAll());
	    }
	}
