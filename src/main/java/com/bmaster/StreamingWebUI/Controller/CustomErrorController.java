package com.bmaster.StreamingWebUI.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public String errorPage(Model model,HttpServletRequest request) {
		Object status =  request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String errorCode="UnKnown";
		model.addAttribute("errorCode", errorCode);
		model.addAttribute("errorCodeText", "Something went Wrong!");
		if(status!=null) {
			Integer statusCode = Integer.valueOf(status.toString());
		    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	model.addAttribute("errorCode", statusCode);
	    		model.addAttribute("errorCodeText", "File Not Found!");
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	model.addAttribute("errorCode", statusCode);
	    		model.addAttribute("errorCodeText", "Internal Server Error!");
	        }
		}
		return "error.html";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
