package com.javalec.login.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.javalec.login.vo.LoginVO;
import com.javalec.util.Constant;


public class LoginDAO {

	Logger logger = Logger.getLogger(this.getClass().toString());
	LoginVO loginVO = null;
	private JdbcTemplate jdbcTemplate = Constant.template;
	
	public LoginDAO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public String login() {
		String sql = "select count(*) from member where id = '"+loginVO.getId()+"'";
		
		if(jdbcTemplate.queryForObject(sql, java.lang.Integer.class) < 1)
		{
			return "01";
		}
		else
		{
			String sql2 = "select count(*) from member where id = '"+loginVO.getId()+"' and password = '"+loginVO.getPassword()+"'";
			// 비번 불일치
			if(jdbcTemplate.queryForObject(sql2, java.lang.Integer.class) < 1) return "02";
			// 성공
			else return "03";
		}
	}

}
