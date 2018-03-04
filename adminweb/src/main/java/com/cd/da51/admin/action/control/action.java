package com.cd.da51.admin.action.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/action")
public class action {

	@RequestMapping("in")
    public String in() {  
    	return "action/reg";
    }

	 @RequestMapping("reg")
	public ModelAndView regin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("requestcond", "请昂");
		modelAndView.setViewName("action/da");
		return modelAndView;
	}
	
}
