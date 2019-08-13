package com.bmaster.StreamingWebUI.Controller.kinesis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/kinesis")
public class KinesisController {
	@RequestMapping(path="",method=RequestMethod.GET)
	public String kinesisRoot(Model model) {
		model.addAttribute("sidepane","kinesis");
		return "kinesis/index.html";
	}
}
