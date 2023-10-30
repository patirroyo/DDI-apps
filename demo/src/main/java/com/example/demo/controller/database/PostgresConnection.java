package com.example.demo.controller.database;

import org.springframework.stereotype.Component;

@Component
public class PostgresConnection implements DBConnection {
	public void helloFormPostgres() {
		System.out.print("Hola desde el controlador de Postgres");

	}

	@Override
	public void helloFromWhateverDatabase() {
		// TODO Auto-generated method stub
		helloFormPostgres();
	}
}
