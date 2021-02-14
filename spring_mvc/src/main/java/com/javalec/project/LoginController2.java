package com.javalec.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.vo.Login;
import com.javalec.vo.Student;

@Controller
public class LoginController2 {
	
	@RequestMapping(value = "/login")
	public String login(Login login) {
		
		System.out.println("login¡¯¿‘");
		
		if(login.getId().equals("bittap") && login.getPw().equals("1234"))
		{
			return "redirect:/login/login_ok";
		}
		else
		{
			return "redirect:/login/login_fail";
		}
	}
	
	@RequestMapping(value = "/login/login_ok")
	public String loginOk() {
		System.out.println("login_ok");
		return "/login/login_ok";
	}
	
	@RequestMapping(value = "/login/login_fail")
	public String loginFail() {
		System.out.println("login_fail");
		return "/login/login_fail";
	}
	

}
