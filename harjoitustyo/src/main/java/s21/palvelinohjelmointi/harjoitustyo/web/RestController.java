package s21.palvelinohjelmointi.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import s21.palvelinohjelmointi.harjoitustyo.domain.Flower;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowerRepository;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowercategoryRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private FlowerRepository repository;
	@Autowired
	private FlowercategoryRepository catrepository;
	
	@GetMapping("/flowers")
	public List<Flower> listFlowersRest() {
		
		return (List<Flower>) repository.findAll();
	}
	
	
	@GetMapping("/flowers/{id}")
	public @ResponseBody String findFlowerById(@PathVariable("id") Long id) {
		
		String msg = "";
		
		if (repository.findById(id).isEmpty()) {
			msg = "No flower by the id " + Long.toString(id);
			return msg;
		} else {
			msg = repository.findById(id).toString();
			return msg;
		}
	}
	

}
