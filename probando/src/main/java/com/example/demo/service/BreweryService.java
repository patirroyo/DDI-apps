package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Brewery;
import com.example.demo.repository.BreweryRepository;

@Service // component, repository esas tres anotaciones hacen que solo se cree un objeto
			// de esta clase y se vaya usando conforme hace falta
public class BreweryService {

	@Autowired
	BreweryRepository breweryRepo;

	public List<Brewery> insertCerveceria(Brewery brewery) {
		if (brewery.getId() == null) {
			breweryRepo.insert(brewery);
		} else {
			// si existe un update
			breweryRepo.update(brewery);
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Brewery> lista = breweryRepo.findAll();

		return lista;
	}

	public List<Brewery> todasCervecerias() {

		List<Brewery> lista = breweryRepo.findAll();

		return lista;
	}

	public Brewery updateCerveceria(Integer id) {
		Brewery brewery = breweryRepo.findById(id);

		return brewery;
	}

	public List<Brewery> deleteCervecería(Integer id) {
		breweryRepo.delete(id);

		List<Brewery> lista = breweryRepo.findAll();
		return lista;
	}



	public Brewery searchBreweryById(long id) {
		return breweryRepo.findById(id);
	}

}
