package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BreweryRowMapper implements RowMapper<Brewery> {

	@Override // lo que hace esto es mapear la estructura de la tabla para que luego podamos
				// trabajar con ella
	public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brewery breweryNew = new Brewery();
		breweryNew.setId(rs.getInt("id"));
		breweryNew.setNombre(rs.getString("nombre"));
		return breweryNew;
	}


}
