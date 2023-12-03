package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Brewery;
import com.example.demo.model.BreweryRowMapper;

@Repository
public class BreweryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Brewery brewery) {

		jdbcTemplate.update("insert into BREWERY(nombre) values(?);", brewery.getNombre());
	}

	public void update(Brewery brewery) {
		jdbcTemplate.update("UPDATE BREWERY SET nombre = ? WHERE id=?;", brewery.getNombre(), brewery.getId());
	}

	public void delete(Integer id) {
		jdbcTemplate.update("DELETE FROM BEER WHERE brewery_id=?", new Object[] { id });
		jdbcTemplate.update("DELETE FROM BREWERY WHERE id=?", new Object[] { id });
	}

	public List<Brewery> findAll() {
		return jdbcTemplate.query("SELECT * FROM BREWERY", new BreweryRowMapper());
	}

	public Brewery findById(long id) {
		return jdbcTemplate.queryForObject("select * from BREWERY where id=?",
				new BeanPropertyRowMapper<Brewery>(Brewery.class), new Object[] { id });
	}


}
