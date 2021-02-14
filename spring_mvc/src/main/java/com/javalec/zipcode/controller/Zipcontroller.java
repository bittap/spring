package com.javalec.zipcode.controller;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.javalec.util.Constant;
import com.javalec.vo.BoardVO;
import com.javalec.zipcode.logic.ZipcodeLogic;
import com.javalec.zipcode.vo.ZipCodeVO;


@Controller
@RequestMapping(value="/zipcode/")
public class Zipcontroller {
	private JdbcTemplate jTemplate;
	private ZipcodeLogic zipcodeLogic = null;
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private final String ROOTURL = "/zipcode/";
	private final String LISTURL = ROOTURL+"list";
	private final String ACTIONURL = ROOTURL+"action";
	private final String MODIFYURL = ROOTURL+"detail";
	
	//@Autowired
	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
		Constant.template = this.jTemplate;
		logger.info("template ���� �Ϸ�");
	}
	
	@RequestMapping(value="list.do")
	public ModelAndView list(ModelAndView mav,BoardVO board) {
		logger.info("list ����");
		
		zipcodeLogic = new ZipcodeLogic();
		List<ZipCodeVO> list = zipcodeLogic.select(board);
		
		mav.setViewName(LISTURL);
		zipcodeLogic = new ZipcodeLogic();
		mav.addObject("list", list);
		mav.addObject("board", board);
		
		logger.info("list �Ϸ�");
		return mav;
	}
		
	@RequestMapping(value="delete.do")
	public ModelAndView delete(ModelAndView mav,BoardVO board,@RequestParam int num) {
		logger.info("delete ����");
		logger.info("num="+num);
		
		zipcodeLogic = new ZipcodeLogic();
		zipcodeLogic.delete(num);
		
		mav.setViewName(ACTIONURL);
		mav.addObject("msg", "���� �Ϸ� �Ǿ����ϴ�.");
		mav.addObject("board", board);
		
		logger.info("delete �Ϸ�");
		return mav;
	}
	
	@RequestMapping(value="modify.do")
	public ModelAndView modify(ModelAndView mav,BoardVO board,@RequestParam int num) {
		logger.info("modify ����");
		logger.info("num="+num);
		
		zipcodeLogic = new ZipcodeLogic();
		ZipCodeVO zipCodeVO = zipcodeLogic.detail(num);
		
		mav.setViewName(MODIFYURL);

		mav.addObject("zipcode", zipCodeVO);
		mav.addObject("path", "modify");
		
		logger.info("modify �Ϸ�");
		return mav;
	}
	
	
	

	
	
}
