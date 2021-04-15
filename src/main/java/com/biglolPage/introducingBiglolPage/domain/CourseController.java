package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biglolPage.introducingBiglolPage.Exception.CoursesNotFoundException;

@RestController
public class CourseController {
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses/{type}")
	public List<Course> retrieveCourses(@PathVariable String type){
		List<Course> courseList = repository.findByCourseType(type);
		if(courseList == null || courseList.size() == 0)
			throw new CoursesNotFoundException("No courses defined");
		return courseList;
	}
	
	@PostMapping("/courses")
	public void postCourses(@Valid @RequestBody Course course) {
		repository.save(course);
	}
}
