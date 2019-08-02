package com.bmaster.StreamingWebUI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RootController {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("UserId", "Ghostranger");
		return "index.html";
	}
}
