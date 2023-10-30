package com.example.demo.controller.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "h2")
@Component
public class H2Connection implements DBConnection {
	public void helloFromH2() {
		System.out.print("Hola desde el controlador de H2");

	}

	@Override
	public void helloFromWhateverDatabase() {
		// TODO Auto-generated method stub
		helloFromH2();
	}
}
