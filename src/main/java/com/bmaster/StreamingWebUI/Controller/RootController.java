package com.bmaster.StreamingWebUI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RootController {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		//model.addAttribute("UserId", "Ghostranger");
		return "login.html";
	}
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(Model model) {
		return "layout.html";
	}
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		return "layout.html";
	}
}
