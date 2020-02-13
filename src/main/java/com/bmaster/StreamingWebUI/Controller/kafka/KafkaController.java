package com.bmaster.StreamingWebUI.Controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmaster.StreamingWebUI.Models.kafka.KafkaModel;
import com.bmaster.StreamingWebUI.Repository.kafka.KafkaRepository;

@Controller
@RequestMapping(path="/kafka")
public class KafkaController {
	
	@Autowired
	KafkaRepository kafkaRepo;
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public String kafkaroot(Model model) {
		model.addAttribute("sidepane","kafka");
		model.addAttribute("kafkaDetails", kafkaRepo.findAll());
		return "kafka/index.html";
	}
	
	@RequestMapping(path="/clusters",method=RequestMethod.GET)
	public String kafkaClusters(Model model) {
		model.addAttribute("sidepane","kafka");
		model.addAttribute("kafkaDetails", kafkaRepo.findAll());
		return "kafka/clusters.html";
	}
	
	@RequestMapping(path="",method=RequestMethod.POST)
	public String kafkaRootPost(@RequestParam("ClusterName") String name,
			@RequestParam("KafkaBroker") String kafkabroker,
			@RequestParam("Zookeeper") String zookeeper,
			Model model) {
		model.addAttribute("sidepane","kafka");
		if(!kafkabroker.isEmpty()&&!name.isEmpty()&&!zookeeper.isEmpty()) {
			kafkaRepo.save(new KafkaModel(name,kafkabroker,zookeeper));
		}
		return "redirect:/kafka/clusters";
	}
	
	@RequestMapping(path="/config",method=RequestMethod.GET)
	public String kafkaConfig(Model model) {
		return "kafka/config.html";
	}
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public String kafkaDelete(@PathVariable("id") int id,Model model) {
		kafkaRepo.deleteById(id);
		return "redirect:/kafka/clusters";
	}
	
	
	@RequestMapping(path="/edit/{id}",method=RequestMethod.GET)
	public String kafkaEdit(@PathVariable("id") int id,Model model) {
		model.addAttribute("sidepane","kafka");
		model.addAttribute("data", kafkaRepo.findById(id).get());
		return "kafka/edit.html";
	}
	
	@RequestMapping(path="/update/{id}",method=RequestMethod.POST)
	public String kafkaUpdatePost(@PathVariable("id") int id,@RequestParam("ClusterName") String name,
			@RequestParam("KafkaBroker") String kafkabroker,
			@RequestParam("Zookeeper") String zookeeper,
			Model model) {
		model.addAttribute("sidepane","kafka");
		if(!kafkabroker.isEmpty()&&!name.isEmpty()&&!zookeeper.isEmpty()) {
			kafkaRepo.save(new KafkaModel(id,name,kafkabroker,zookeeper));
		}
		return "redirect:/kafka";
	}
}
