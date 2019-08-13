package com.bmaster.StreamingWebUI.Controller.hdfs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/hdfs")
public class HdfsController {
	@RequestMapping(path="",method=RequestMethod.GET)
	public String hdfsRoot(Model model) {
		model.addAttribute("sidepane","hdfs");
		return "hdfs/index.html";
	}
}
