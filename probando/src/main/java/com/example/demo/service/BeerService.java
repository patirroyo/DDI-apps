package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Beer;
import com.example.demo.repository.BeerRepository;

@Service // component, repository esas tres anotaciones hacen que solo se cree un objeto
			// de esta clase y se vaya usando conforme hace falta
public class BeerService {

	@Autowired
	BeerRepository beerRepo;

	public List<Beer> insertCerveza(Beer beer) {
		if (beer.getId() == null) {
			beerRepo.insert(beer);
		} else {
			// si existe un update
			beerRepo.update(beer);
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Beer> lista = beerRepo.findAll();

		return lista;
	}


	public Beer updateCervezas(Integer id) {
		Beer beer = beerRepo.findById(id);


		return beer;
	}

	public List<Beer> deleteCerveza(Integer id) {
		beerRepo.delete(id);

		List<Beer> lista = beerRepo.findAll();
		return lista;
	}

	public List<Beer> todasCervezas() {

		List<Beer> lista = beerRepo.findAll();

		return lista;
	}


	public Beer searchBeerById(long id) {
		return beerRepo.findById(id);
	}

}
