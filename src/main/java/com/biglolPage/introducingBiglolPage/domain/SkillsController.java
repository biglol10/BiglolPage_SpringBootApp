package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biglolPage.introducingBiglolPage.Exception.SkillsNotFoundException;

@RestController
public class SkillsController {
	@Autowired
	private SkillsRepository repository;
	
	@GetMapping("/skills/{skill}")
	public Skills retrieveSkill(@PathVariable String skill) {
		Skills aSkill = repository.findBySkillname(skill);
		return aSkill;
	}
	
	@GetMapping("/skills")
	public Iterable<Skills> retrieveAll(){
		Iterable<Skills> skillList = repository.findAll();
		List<Skills> Listskill = (List<Skills>)skillList;
		if(Listskill == null || Listskill.size() == 0)
			throw new SkillsNotFoundException("No Skills defined");
		return skillList;
	}
	
	@PostMapping("/skills")
	public void postSkill(@Valid @RequestBody Skills skill) {
		repository.save(skill);
		
	}
}
