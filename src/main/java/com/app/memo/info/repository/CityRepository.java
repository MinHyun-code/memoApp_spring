package com.app.memo.info.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.memo.info.model.Sawon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CityRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Sawon> findList(){
		String sql = "select id,pw from emp";
		
		log.debug("query : {}", sql);
		
		RowMapper<Sawon> cityMapper = (rs, rowNum) -> {
			Sawon sawon = new Sawon();
			sawon.setId(rs.getString("id"));
			sawon.setPw(rs.getString("pw"));
			return sawon;
		};
		
		return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), cityMapper);
	}
}
