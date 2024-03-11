package examen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import examen.model.Result;
import examen.model.Round;

@RestController
@RequestMapping(value = "/jankenpon")
public class JanKenPonRestController {


	private final Map<String, String> jugadasGanadoras;
	List<Round> rounds = new ArrayList<Round>();
	int roundNumber = 1;
	Round currentRound;
	Result currentResult;
	List<Result> results = new ArrayList<Result>();

	public JanKenPonRestController() {
		jugadasGanadoras = new HashMap<>();
		// Configura las jugadas ganadoras
		jugadasGanadoras.put("piedra", "papel");
		jugadasGanadoras.put("papel", "tijeras");
		jugadasGanadoras.put("tijeras", "piedra");
	}

	@PostMapping(value = "/play")
	public ResponseEntity<Result> play(@RequestParam String jugador1, @RequestParam String jugador2) {
		currentResult = new Result();
		currentRound = new Round();

		currentRound.setRoundNumber(roundNumber);
		currentResult.setRonda(roundNumber);
		roundNumber ++;

		currentRound.setPlayP1(jugador1);
		currentRound.setPlayJ2(jugador2);
				
		// Verifica las jugadas
		if (jugador1.equals(jugador2)) {
			currentRound.setResult("draw");
			currentResult.setWinner("draw");
		} else if (jugadasGanadoras.get(jugador1).equals(jugador2)) {
			currentRound.setResult("j2");
			currentResult.setWinner("jugador2");
		} else {
			currentRound.setResult("j1");
			currentResult.setWinner("jugador1");
		}
		rounds.add(currentRound);
		return new ResponseEntity<Result>(currentResult, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/results/{player}")
	public ResponseEntity<List<Result>> playerHistory(@PathVariable String player) {
		if (player.contains("j1") && player.contains("j2"))
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		
		results.clear();

		for (Round round : rounds) {
			currentResult = new Result();
			if (round.getResult().equals(player)) {
				currentResult.setPlayer(player);
				currentResult.setRonda(round.getRoundNumber());
				currentResult.setWinner(player);
				results.add(currentResult);
			}
		}
		
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

}
