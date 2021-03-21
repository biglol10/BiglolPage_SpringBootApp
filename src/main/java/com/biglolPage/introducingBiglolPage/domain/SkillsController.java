package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		return skillList;
	}
	
	@PostMapping("/skills")
	public void postSkill(@RequestBody Skills skill) {
		repository.save(skill);
		
	}
}
