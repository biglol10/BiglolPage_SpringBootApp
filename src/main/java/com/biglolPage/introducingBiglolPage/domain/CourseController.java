package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses/{type}")
	public List<Course> retrieveCourses(@PathVariable String type){
		List<Course> courseList = repository.findByCourseType(type);
		return courseList;
	}
	
	@PostMapping("/courses")
	public void postCourses(@RequestBody Course course) {
		repository.save(course);
	}
}
