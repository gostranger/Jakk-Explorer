package com.bmaster.StreamingWebUI.Controller.kafka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/kafka")
public class KafkaController {
	@RequestMapping(path="",method=RequestMethod.GET)
	public String kafkaroot(Model model) {
		model.addAttribute("sidepane","kafka");
		//model.addAttribute("ab","yes");
		return "kafka/index.html";
	}
}
