package com.javalec.login.logic;

import java.util.List;

import com.javalec.login.dao.LoginDAO;
import com.javalec.login.vo.LoginVO;


public class LoginLogic {
	
	private LoginDAO dao = null;
	private LoginVO loginVO;
	
	public LoginLogic(LoginVO loginVO) {
		this.loginVO = loginVO;
		dao = new LoginDAO(loginVO);
	}
	
	
	/**
	  * @Method Name : login
	  * @�ۼ��� : 2019. 12. 18.
	  * @�ۼ��� : jmp17
	  * @�����̷� : 
	  * @Method ���� :
	  * @return // 01 => ���̵� ���� x, 02 => ��й�ȣ ��ġ x, 03 => ����
	*/
	public String login() {
		return dao.login();
	}
	
	
	
	
}
