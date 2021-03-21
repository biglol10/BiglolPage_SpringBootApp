package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {
	@Autowired
	private ProjectsRepository repository;
	
	@GetMapping("/projects")
	public List<Projects> retrieveAll(){
		List<Projects> projectList = repository.findAll();
		return projectList;
	}
	
	@PostMapping("/projects")
	public void postProject(@RequestBody Projects project) {
		repository.save(project);
		
	}
}
