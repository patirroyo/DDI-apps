package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BeerRowMapper implements RowMapper<Beer> {

	@Override // lo que hace esto es mapear la estructura de la tabla para que luego podamos
				// trabajar con ella
	public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brewery brewery = new Brewery();
		brewery.setId(rs.getInt("br_id"));
		brewery.setNombre(rs.getString("br_nombre"));
		

		Beer beer = new Beer();
		beer.setId(rs.getInt("id"));
		beer.setNombre(rs.getString("nombre"));
		beer.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
		beer.setIs_old(rs.getBoolean("is_old"));
		beer.setBrewery_id(rs.getInt("brewery_id"));
		beer.setBrewery(brewery);
		return beer;
	}


}
