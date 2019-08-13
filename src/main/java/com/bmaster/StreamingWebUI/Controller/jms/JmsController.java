package com.bmaster.StreamingWebUI.Controller.jms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/jms")
public class JmsController {
	@RequestMapping(path="",method=RequestMethod.GET)
	public String jmsRoot(Model model) {
		model.addAttribute("sidepane","jms");
		return "jms/index.html";
	}
}
