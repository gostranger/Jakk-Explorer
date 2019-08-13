package com.bmaster.StreamingWebUI.Controller.adls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bmaster.StreamingWebUI.Repository.adls.AdlsRepository;

@Controller
@RequestMapping(path="/adls")
public class AdlsController {
	
	@Autowired
	AdlsRepository adlsRepo;
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public String adlsRoot(Model model) {
		model.addAttribute("sidepane","adls");
		return "adls/index.html";
	}
	
	@RequestMapping(path="/config",method=RequestMethod.GET)
	public String adlsConfig(Model model) {
		return "adls/config.html";
	}
}
