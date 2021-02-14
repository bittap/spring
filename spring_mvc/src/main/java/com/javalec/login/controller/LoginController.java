package com.javalec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.login.logic.LoginLogic;
import com.javalec.login.vo.LoginVO;
import com.javalec.util.Constant;

@Controller
@RequestMapping(value = "/login/")
public class LoginController {
	private final String ROOTPATH = "/login/";
	private final String LOGINPATH = ROOTPATH + "login";
	private final String LOGINACTIONPATH = ROOTPATH + "login_action";
	private final String LOGOUTPATH = ROOTPATH + "logout";
	private JdbcTemplate jTemplate = null;
	
	//@Autowired
	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
		Constant.template = this.jTemplate;
	}
	
	@RequestMapping(value = "login.do")
	public String login() {
		return LOGINPATH;
	}
	
	@RequestMapping(value = "loginAction.do")
	public ModelAndView loginAction(LoginVO loginVO,HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginLogic loginLogic = new LoginLogic(loginVO);
		String result = loginLogic.login();
		System.out.println("result = "+result);
		if(result == "03")
		{
			session.setAttribute("id", (String)req.getParameter("id"));
			session.setAttribute("password", (String)req.getParameter("password"));
		}
		
		ModelAndView mav = new ModelAndView(LOGINACTIONPATH);
		mav.addObject("result", result);
		
		return mav;
	}
	
	@RequestMapping(value = "logout.do")
	public String login(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.removeAttribute("password");
		return LOGOUTPATH;
	}
}
