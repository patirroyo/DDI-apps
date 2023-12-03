package com.example.demo.repository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Beer;
import com.example.demo.model.BeerRowMapper;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Beer beer) {
		Integer year = getYear(beer);
		if (year < 2000) {
			jdbcTemplate.update("insert into beer(nombre, fechaLanzamiento, brewery_id, is_old) values(?,?,?, 1);",
					beer.getNombre(), beer.getFechaLanzamiento(), beer.getBrewery_id());
		set_age(beer);
	} else {
		jdbcTemplate.update("insert into beer(nombre, fechaLanzamiento, brewery_id, is_old) values(?,?,?, 0);",
				beer.getNombre(), beer.getFechaLanzamiento(), beer.getBrewery_id());
		set_age(beer);
	}

	}

	public void update(Beer beer) {
		jdbcTemplate.update("UPDATE beer SET nombre = ?, fechaLanzamiento = ?, brewery_id = ? WHERE id=?;",
				beer.getNombre(), beer.getFechaLanzamiento(), beer.getBrewery_id(), beer.getId());
		set_age(beer);
	}

	public void delete(Integer id) {
		jdbcTemplate.update("DELETE FROM beer WHERE id=?", new Object[] { id });
	}

	public List<Beer> findAll() {
		return jdbcTemplate.query("SELECT b.id as id, "
				+ "b.nombre as nombre, "
				+ "b.fechaLanzamiento as fechaLanzamiento, " + "b.brewery_id as brewery_id, "
				+ "b.is_old as is_old, " + "br.id as br_id, "
				+ "br.nombre as br_nombre "
				+ "FROM beer AS b "
				+ "INNER JOIN brewery AS br "
				+ "ON b.brewery_id = br.id", new BeerRowMapper());
	}

	public Beer findById(long id) {
		return jdbcTemplate.queryForObject("select * from beer where id=?",
				new BeanPropertyRowMapper<Beer>(Beer.class), new Object[] { id });
	}

	private Integer getYear(Beer beer) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		Integer year = Integer.parseInt(df.format(beer.getFechaLanzamiento()));
		return year;
	}

	private void set_age(Beer beer) {
		Integer year = getYear(beer);
		if (year < 2000) {
			jdbcTemplate.update("UPDATE beer SET is_old = 1 WHERE id=?;", beer.getId());
		} else {
			jdbcTemplate.update("UPDATE beer SET is_old = 0 WHERE id=?;", beer.getId());
		}
	}

}
