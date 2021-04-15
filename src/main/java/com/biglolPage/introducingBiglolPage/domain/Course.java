package com.biglolPage.introducingBiglolPage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Size(min=3, message="Course name should be at least 3 characters")
	private String name;
	private String url, path, instructorDetails, price;
	private double rating;
	private String courseType;
	
	public Course() {
		super();
	}

	public Course(String name, String url, String path, String instructorDetails, String price, double rating, String courseType) {
		super();
		this.name = name;
		this.url = url;
		this.path = path;
		this.instructorDetails = instructorDetails;
		this.price = price;
		this.rating = rating;
		this.courseType = courseType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(String instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
