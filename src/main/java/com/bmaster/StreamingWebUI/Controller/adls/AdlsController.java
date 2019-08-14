package com.bmaster.StreamingWebUI.Controller.adls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmaster.StreamingWebUI.Models.adls.AdlsModel;
import com.bmaster.StreamingWebUI.Repository.adls.AdlsRepository;

@Controller
@RequestMapping(path="/adls")
public class AdlsController {
	
	@Autowired
	AdlsRepository adlsRepo;
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public String adlsRoot(Model model) {
		model.addAttribute("sidepane","adls");
		model.addAttribute("adlsDetails", adlsRepo.findAll());
		return "adls/index.html";
	}
	
	@RequestMapping(path="",method=RequestMethod.POST)
	public String adlsRootPost(@RequestParam("ClusterName") String name,
			@RequestParam("AcName") String acName,
			@RequestParam("ClusterID") String cID,
			@RequestParam("key") String key,
			@RequestParam("Directory") String Dir,
			@RequestParam("AuthEndPoint") String authEp,
			Model model) {
		model.addAttribute("sidepane","adls");
		if(!acName.isEmpty()&&!name.isEmpty()&&!cID.isEmpty()&&!key.isEmpty()&&!Dir.isEmpty()&&!authEp.isEmpty()) {
			adlsRepo.save(new AdlsModel(name,acName,cID, key, Dir, authEp));
		}
		return "redirect:/adls";
	}
	
	@RequestMapping(path="/config",method=RequestMethod.GET)
	public String adlsConfig(Model model) {
		return "adls/config.html";
	}
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public String adlsDelete(@PathVariable("id") int id,Model model) {
		adlsRepo.deleteById(id);
		return "redirect:/adls";
	}
	
	@RequestMapping(path="/view/{id}",method=RequestMethod.GET)
	public String adlsView(@PathVariable("id") int id,Model model) {
		model.addAttribute("sidepane","adls");
		return "adls/view.html";
	}
	
	@RequestMapping(path="/edit/{id}",method=RequestMethod.GET)
	public String adlsEdit(@PathVariable("id") int id,Model model) {
		model.addAttribute("sidepane","adls");
		model.addAttribute("data", adlsRepo.findById(id).get());
		return "adls/edit.html";
	}
	
	@RequestMapping(path="/update/{id}",method=RequestMethod.POST)
	public String adlsUpdatePost(@PathVariable("id") int id,@RequestParam("ClusterName") String name,
			@RequestParam("AcName") String acName,
			@RequestParam("ClusterID") String cID,
			@RequestParam("key") String key,
			@RequestParam("Directory") String Dir,
			@RequestParam("AuthEndPoint") String authEp,
			Model model) {
		model.addAttribute("sidepane","adls");
		if(!acName.isEmpty()&&!name.isEmpty()&&!cID.isEmpty()&&!key.isEmpty()&&!Dir.isEmpty()&&!authEp.isEmpty()) {
			adlsRepo.save(new AdlsModel(id,name,acName,cID, key, Dir, authEp));
		}
		return "redirect:/adls";
	}
	
}
