package examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import examen.model.DragonBall;

@RestController
@RequestMapping(value = "/api/DB")
public class DragonBallRestController {
	List<DragonBall> balls = new ArrayList<DragonBall>();

	public DragonBallRestController() {
		for (int i = 1; i <= 7; i++) {
			DragonBall ball = new DragonBall();
			ball.setNumber(i);
			if (i % 2 == 0)
				ball.setOwned(true);
			balls.add(ball);
		}
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<DragonBall>> getAll() {
		return new ResponseEntity<>(balls, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getMine")
	public ResponseEntity<List<DragonBall>> getMine() {

		List<DragonBall> mineBalls = new ArrayList<DragonBall>();
		
		for (DragonBall ball : balls) {
			if (ball.owned == true)
				mineBalls.add(ball);
		}
		if (mineBalls.isEmpty()) 
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		
		return new ResponseEntity<>(mineBalls, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/getBall/{StarNumber}")
	public ResponseEntity<DragonBall> getBall(@PathVariable int StarNumber) {
		if (StarNumber <= 0 || StarNumber > balls.size())
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

		DragonBall ball = balls.get(StarNumber - 1);


		return new ResponseEntity<>(ball, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/invokeShenron")
	public ResponseEntity<String> invokeShenron() {
		int numberOwnedBalls = 0;
		for (DragonBall ball : balls) {
			if(ball.owned)
				numberOwnedBalls++;
		}
		if (numberOwnedBalls == balls.size())
			return new ResponseEntity<>("Vaya huevos mas gordos tienes, Jesus", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("Te has pasado del 15%, Montero", HttpStatus.I_AM_A_TEAPOT);
	}


}