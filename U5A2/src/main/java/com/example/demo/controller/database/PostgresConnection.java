package com.example.demo.controller.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "postgres")
@Component()
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
