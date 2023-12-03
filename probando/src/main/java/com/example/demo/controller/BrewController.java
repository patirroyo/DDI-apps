package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.model.Beer;
import com.example.demo.model.Brewery;
import com.example.demo.service.BeerService;
import com.example.demo.service.BreweryService;

@Controller
public class BrewController {
	@Autowired // usa esta interfaz
	DBConnection db;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BeerService beerService;

	@Autowired
	BreweryService breweryService;

	// localhost:8080/
	@RequestMapping("/")
	public String index(Model model) {



		// devuelve a la página index
		return "index";
	}

	@RequestMapping("/insertCerveza")
	public String insertCervezaForm(Model model) {

		List<Brewery> lista = breweryService.todasCervecerias();
		model.addAttribute("cervecerias", lista);
		model.addAttribute("beer", new Beer());

		// devuelve a la página index
		return "insertCervezaForm";
	}

	@RequestMapping("/insertBeer")
	public String insertarCerveza(Beer beer, Model model) {

		List<Beer> lista = beerService.insertCerveza(beer);
		

		model.addAttribute("cervezas", lista);

		return "listarCervezas";
	}

	@RequestMapping("/insertCerveceria")
	public String insertCerveceriaForm(Model model) {

		model.addAttribute("brewery", new Brewery());

		// devuelve a la página index
		return "insertCerveceriaForm";
	}

	@RequestMapping("/insertBrewery")
	public String insertarCerveceria(Brewery brewery, Model model) {

		List<Brewery> lista = breweryService.insertCerveceria(brewery);

		model.addAttribute("cervecerias", lista);

		return "listarCervecerias";
	}

	@RequestMapping("/listarBeers")
	public String ListarBeers(Model model) {

		List<Beer> lista = beerService.todasCervezas();

		model.addAttribute("cervezas", lista);

		return "listarCervezas";
	}

	@RequestMapping("/listarBreweries")
	public String ListarBreweries(Model model) {

		List<Brewery> lista = breweryService.todasCervecerias();

		model.addAttribute("cervecerias", lista);

		return "listarCervecerias";
	}



	@RequestMapping("/updateBeer/{id}") // le paso un path variable en este caso nombre
	public String actualizarCerveza(@PathVariable Integer id, Model model) {

		List<Brewery> lista = breweryService.todasCervecerias();
		model.addAttribute("cervecerias", lista);
		Beer beer = beerService.updateCervezas(id);

		model.addAttribute("beer", beer);

		return "insertCervezaForm";
	}


	@RequestMapping("/deleteBeer/{id}") // le paso un path variable en este caso nombre
	public String borrarCerveza(@PathVariable Integer id, Model model) {
		List<Beer> lista = beerService.deleteCerveza(id);

		model.addAttribute("cervezas", lista);
		return "listarCervezas";
	}

	@RequestMapping("/updateBrewery/{id}") // le paso un path variable en este caso nombre
	public String actualizarCerveceria(@PathVariable Integer id, Model model) {


		Brewery brewery = breweryService.updateCerveceria(id);

		model.addAttribute("brewery", brewery);

		return "insertCerveceriaForm";
	}

	@RequestMapping("/deleteBrewery/{id}") // le paso un path variable en este caso nombre
	public String borrarCerveceria(@PathVariable Integer id, Model model) {
		

		List<Brewery> lista = breweryService.deleteCervecería(id);

		model.addAttribute("cervecerias", lista);
		return "listarCervecerias";
	}


	public Beer findById(long id) {
		Beer birra = beerService.searchBeerById(id);
		return birra;
	}

}
