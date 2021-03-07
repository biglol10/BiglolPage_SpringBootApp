package com.biglolPage.introducingBiglolPage.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, path, opinion;
	private double rating;
	
	public Skills() {
		super();
	}

	public Skills(String name, String path, String opinion, double rating) {
		super();
		this.name = name;
		this.path = path;
		this.opinion = opinion;
		this.rating = rating;
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
}
