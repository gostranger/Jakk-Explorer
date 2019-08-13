package com.bmaster.StreamingWebUI.Controller.adls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/adls")
public class AdlsController {
	@RequestMapping(path="",method=RequestMethod.GET)
	public String adlsTrigger(Model model) {
		model.addAttribute("sidepane","adls");
		return "adls/index.html";
	}
}
