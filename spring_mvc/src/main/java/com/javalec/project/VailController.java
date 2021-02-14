package com.javalec.project;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.vaildate.StduentVaildator;
import com.javalec.vaildate.Student;

@Controller
public class VailController {

	@RequestMapping(value = "/vail/check")
	public ModelAndView vail(@ModelAttribute("student") @Valid Student student,BindingResult result	) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Validator stduentValidator = new StduentVaildator();
		//stduentValidator.validate(student, result);
		
		if(result.hasErrors()) modelAndView.setViewName("/vail/fail");
		else modelAndView.setViewName("/vail/success");
		
		return modelAndView;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StduentVaildator());
	}
}
