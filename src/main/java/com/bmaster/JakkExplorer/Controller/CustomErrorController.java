package com.bmaster.JakkExplorer.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public String errorPage() {
		return "404.html";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
