package com.example.demo.controller.database;

import org.springframework.stereotype.Component;

@Component
public class MySQLConnection implements DBConnection {
	public void helloFromMySQL() {
		System.out.print("Hola desde el controlador de MySQL");

	}

	@Override
	public void helloFromWhateverDatabase() {
		// TODO Auto-generated method stub
		helloFromMySQL();
	}
}
