package com.javalec.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.javalec.util.Constant;

public class ZipcodeDAO {
	
	JdbcTemplate jdbcTemplate;
	
	public ZipcodeDAO() {
		jdbcTemplate = Constant.template;
	}
}
