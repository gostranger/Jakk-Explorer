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
		model.addAttribute("sidepane","dashboard");
		return "redirect:/dashboard";
	}
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		model.addAttribute("sidepane","dashboard");
		model.addAttribute("ab","yes");
		return "dashboard/index.html";
	}
	@RequestMapping(path="/kafka",method=RequestMethod.GET)
	public String kafkaTrigger(Model model) {
		model.addAttribute("sidepane","kafka");
		//model.addAttribute("ab","yes");
		return "kafka/index.html";
	}
	
	@RequestMapping(path="/jms",method=RequestMethod.GET)
	public String jmsTrigger(Model model) {
		model.addAttribute("sidepane","jms");
		return "jms/index.html";
	}
	
	@RequestMapping(path="/adls",method=RequestMethod.GET)
	public String adlsTrigger(Model model) {
		model.addAttribute("sidepane","adls");
		return "adls/index.html";
	}
	
	@RequestMapping(path="/kinesis",method=RequestMethod.GET)
	public String kinesisTrigger(Model model) {
		model.addAttribute("sidepane","kinesis");
		return "kinesis/index.html";
	}

	@RequestMapping(path="/hdfs",method=RequestMethod.GET)
	public String hdfsTrigger(Model model) {
		model.addAttribute("sidepane","hdfs");
		return "hdfs/index.html";
	}
	
}
