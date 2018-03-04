package com.cd.da51.admin.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.da51.admin.interfaces.use.service.userAdminService;
@Controller
public class index {
	
/*	@Autowired
	private userAdminService userAdminservice;
	
	*/
	@RequestMapping("/index")
	public String index() {
		
		return"index";
	}
	
}
