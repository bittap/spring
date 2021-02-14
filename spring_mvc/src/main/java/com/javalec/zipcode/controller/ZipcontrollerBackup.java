package com.javalec.zipcode.controller;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.util.Constant;
import com.javalec.vo.BoardVO;
import com.javalec.zipcode.logic.ZipcodeLogic;


//@Controller
//@RequestMapping(value="/zipcode/")
//public class ZipcontrollerBackup {
//	private JdbcTemplate jTemplate;
//	private ZipcodeLogic zipcodeLogic = null;
//	private Logger logger = Logger.getLogger(this.getClass().toString());
//	
//	@Autowired
//	public void setjTemplate(JdbcTemplate jTemplate) {
//		this.jTemplate = jTemplate;
//		Constant.template = this.jTemplate;
//		logger.info("template ���� �Ϸ�");
//	}
//	
//	@RequestMapping(value="list.do")
//	public ModelAndView list(ModelAndView mav,HttpServletRequest req) {
//		zipcodeLogic = new ZipcodeLogic(boardSetting(req));
//		mav.setViewName("/zipcode/list");
//		mav.addObject("list", zipcodeLogic.select());
//		mav.addObject("board", zipcodeLogic.getPaingBoardVO());
//		logger.info("list �Ϸ�");
//		return mav;
//	}
//	
//	@RequestMapping(value="delete.do")
//	public ModelAndView delete(ModelAndView mav,HttpServletRequest req) {
//		BoardVO boardVO = boardSetting(req);
//		zipcodeLogic = new ZipcodeLogic(boardVO);
//		mav.setViewName("/zipcode/list");
//		mav.addObject("list", zipcodeLogic.select());
//		mav.addObject("board", zipcodeLogic.getPaingBoardVO());
//		logger.info("list �Ϸ�");
//		return mav;
//	}
//	
//	private BoardVO boardSetting(HttpServletRequest req) {
//		BoardVO boardVO = new BoardVO();
//		
//		Map<String, String> searchMap = new LinkedHashMap<String, String>();
//		searchMap.put("", "��ü");
//		searchMap.put("uid_no", "��ȣ");
//		searchMap.put("zipcode", "�����ȣ");
//		searchMap.put("address", "�ּ�");
//		boardVO.setSearchMap(searchMap);
//		boardVO.setSearchKind(req.getParameter("searchKind"));
//		boardVO.setSearchString(req.getParameter("search"));
//		Map<String,String[]> map = req.getParameterMap();
//		
//		Iterator<String> iterator = map.keySet().iterator();
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			String[] value = map.get(key);
//			
//			System.out.println("key: " + key);
//			for (String string : value) {
//				System.out.println("value: " + string);
//			}
//		}
//		if(req.getParameter("page") != null) boardVO.setNowPage(Integer.valueOf(req.getParameter("page")));
//		
//		return boardVO;
//	}
//	
//
//	
////	@Override
////	public void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		req.setCharacterEncoding("utf-8");
////		logger.info("FrontController ����");
////
////		String rootPath = getRootPath(req);
////		
////		logger.info("rootPath  = "+rootPath);
////		
////		ActionForward actionForward = null;
////		
////		switch (rootPath) {
////		case "zipcode":
////			ZipcodeController zipcodeController = new ZipcodeController();
////			actionForward = zipcodeController.actionFerformd(req, resp);
////			break;
////		case "login":
////			LoginController loginController = new LoginController();
////			actionForward = loginController.actionFerformd(req, resp);
////			break;
////
////		default:
////			break;
////		}
////		
////		logger.info("isRedirect ����  = "+actionForward.isRedirect());
////		logger.info("path  = "+actionForward.getPath());
////		
////		if(actionForward.isRedirect())
////		{
////			resp.sendRedirect(actionForward.getPath());
////		}
////		else
////		{
////			RequestDispatcher rs = req.getRequestDispatcher(actionForward.getPath());
////			rs.forward(req, resp);
////		}
////	}
//	
//
//	
//	
//}
