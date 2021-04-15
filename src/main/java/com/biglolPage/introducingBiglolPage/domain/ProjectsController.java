package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biglolPage.introducingBiglolPage.Exception.ProjectsNotFoundException;

@RestController
public class ProjectsController {
	@Autowired
	private ProjectsRepository repository;
	
	@GetMapping("/projects")
	public List<Projects> retrieveAll(){
		List<Projects> projectList = repository.findAll();
		if(projectList == null || projectList.size() == 0)
			throw new ProjectsNotFoundException("No Projects defined");
		return projectList;
	}
	
	@PostMapping("/projects")
	public void postProject(@Valid @RequestBody Projects project) {
		repository.save(project);
		
	}
}
