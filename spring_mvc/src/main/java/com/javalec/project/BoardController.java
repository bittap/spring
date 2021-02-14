package com.javalec.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.vo.Student;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		System.out.println("진입 home");
		
		return "home";
	}
	
	@RequestMapping(value = "/board")
	public ModelAndView board(Student student, ModelAndView model) {
		System.out.println("진입");
		model.addObject("student", student);
		model.setViewName("/board/index");
		return model;
	}

}
