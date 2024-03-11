package examen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import examen.model.Round;

@RestController
@RequestMapping(value = "/api/JKP")
public class JanKenPonRestController {

	List<Integer> resultados = new ArrayList<Integer>();
	private final Map<String, String> jugadasGanadoras;
	List<Round> rounds = new ArrayList<Round>();
	int roundNumber = 1;
	Round currentRound = new Round();

	public JanKenPonRestController() {
		jugadasGanadoras = new HashMap<>();
		// Configura las jugadas ganadoras
		jugadasGanadoras.put("piedra", "papel");
		jugadasGanadoras.put("papel", "tijeras");
		jugadasGanadoras.put("tijeras", "piedra");
	}

	@PostMapping(value = "/play")
	public ResponseEntity<String> play(@RequestParam String playJ1, @RequestParam String playJ2) {
		currentRound.setRoundNumber(roundNumber);
		roundNumber ++;
		currentRound.setPlayP1(playJ1);
		currentRound.setPlayJ2(playJ2);
				
		// Verifica las jugadas
		if (playJ1.equals(playJ2)) {
			currentRound.setResult("draw");
			resultados.add(0);
			return new ResponseEntity<>("Empate", HttpStatus.OK);
		} else if (jugadasGanadoras.get(playJ1).equals(playJ2)) {
			currentRound.setResult("player2");
			resultados.add(2);
			return new ResponseEntity<>("Ha ganado el jugador 2", HttpStatus.ACCEPTED);
		} else {
			currentRound.setResult("player1");
			resultados.add(1);
			return new ResponseEntity<>("Ha ganado el jugador 1", HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping(value = "/playerHistory")
	public ResponseEntity<List<String>> playerHistory(@RequestParam int playerNumber) {
		if (playerNumber != 1 && playerNumber != 2)
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		
		List<String> results = new ArrayList<String>();
		for (Integer ganador : resultados) {
			switch(ganador) {
			case 0:
				results.add("empate");
				break;
			case 1, 2:
				if (playerNumber == ganador)
					results.add("victoria");
				else
					results.add("derrota");
				break;
			default:
				results.add("error");
			}
		}
		
		return new ResponseEntity<>(results, HttpStatus.ACCEPTED);
	}

}
