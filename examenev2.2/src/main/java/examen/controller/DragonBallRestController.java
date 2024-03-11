package examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import examen.model.DragonBall;

@RestController
@RequestMapping(value = "/dragonball")
public class DragonBallRestController {
	List<DragonBall> balls = new ArrayList<DragonBall>();
	List<DragonBall> ownedBalls = new ArrayList<DragonBall>();
	String[] lugares = { "Lechago", "Calamocha", "Zaragoza", "Letux", "Aínsa", "Broto", "Fiscal" };

	public DragonBallRestController() {
		start();
	}

	private void start() {
		balls.clear();
		for (int i = 1; i <= 7; i++) {
			DragonBall ball = new DragonBall();
			ball.setStardots(i);
			ball.setUbicacion(lugares[i - 1]);
			ball.setFound(false);
			balls.add(ball);
		}
		// ownedBalls.clear();
	}

	@GetMapping(value = "/radar")
	public ResponseEntity<List<DragonBall>> getAll() {
		List<DragonBall> lista = new ArrayList<DragonBall>();
		for (DragonBall ball : balls)
			if (!ball.isFound())
				lista.add(ball);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/owned")
	public ResponseEntity<List<DragonBall>> getMine() {
		List<DragonBall> lista = new ArrayList<DragonBall>();
		for (DragonBall ball : balls)
			if (ball.isFound())
				lista.add(ball);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/get")
	public ResponseEntity<DragonBall> getBall(@RequestParam int ball) {
		if (ball <= 0 || ball > 7)
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

		DragonBall newOwnedBall = null;
		
		for (DragonBall owned : balls) {
			if (owned.stardots == ball) {
				owned.setFound(true);
				owned.setUbicacion("En casica");
				newOwnedBall = owned;
				break;
			}
		}

//		for (int i = 0; i < balls.size(); i++) {
//			newOwnedBall = balls.get(i);
//			if (newOwnedBall.stardots == ball) {
//				DragonBall owned = newOwnedBall;
//				owned.setFound(true);
//				owned.setUbicacion("En casica");
//				ownedBalls.add(owned);
//				balls.remove(newOwnedBall);
//				break;
//			} else {
//				for (DragonBall owned : ownedBalls) {
//					if (owned.stardots == ball)
//						newOwnedBall = owned;
//				}
//			}
//		}
		if (newOwnedBall == null) {
//			newOwnedBall = new DragonBall();
//			newOwnedBall.setFound(true);
//			newOwnedBall.setUbicacion("En casica");
//			newOwnedBall.setStardots(ball);
//			if (!ownedBalls.contains(newOwnedBall))
//				ownedBalls.add(newOwnedBall);
//			if(balls.contains(newOwnedBall))
//				balls.remove(newOwnedBall);
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
	}


		return new ResponseEntity<>(newOwnedBall, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/invokeDragon")
	public ResponseEntity<List<DragonBall>> invokeShenron() {
		if (ownedBalls.size() == 7) 
			System.out.println("Vaya huevos más gordos tienes, Montero");
		start();
		return new ResponseEntity<>(ownedBalls, HttpStatus.I_AM_A_TEAPOT);
		
	}



}