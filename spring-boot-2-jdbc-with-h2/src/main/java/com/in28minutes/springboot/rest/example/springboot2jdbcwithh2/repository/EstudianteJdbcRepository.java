package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.model.Estudiante;

@Controller
public class EstudianteJdbcRepository {

	@Autowired
	JdbcTemplate JdbcTemplate;

	class EstudianteRowMapper implements RowMapper<Estudiante> {
		@Override
		public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
			Estudiante estudiante = new Estudiante();
			estudiante.setId(rs.getLong("id"));
			estudiante.setNombre(rs.getString("nombre"));
			estudiante.setMail(rs.getString("mail"));
			return estudiante;
		}
	}

	public Estudiante findById(long id) {
		return JdbcTemplate.queryForObject("select * from estudiante where id=?",
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class), new Object[] { id });
	}

	public List<Estudiante> findAll() {
		return JdbcTemplate.query("SELECT * FROM estudiante", new EstudianteRowMapper());
	}

	public int deleteById(long id) {
		return JdbcTemplate.update("delete from estudiante where id=?", new Object[] { id });
	}

	public int insert(Estudiante estudiante) {
		return JdbcTemplate.update("insert into estudiante (id, nombre, mail) " + "values(?,  ?, ?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getMail() });
	}

	public int update(Estudiante estudiante) {
		return JdbcTemplate.update("update estudiante " + " set nombre = ?, mail = ? " + " where id = ?",
				new Object[] { estudiante.getNombre(), estudiante.getMail(), estudiante.getId() });
	}
}
