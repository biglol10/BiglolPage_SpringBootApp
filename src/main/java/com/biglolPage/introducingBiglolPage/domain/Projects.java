package com.biglolPage.introducingBiglolPage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name, path, reference, opinion, original_creator;
	private double rating;
	private Boolean noUrl;
	private String deployedURL;
	
	public Projects() {
		super();
	}

	public Projects(String name, String path, String reference, String opinion, String original_creator, String deployedURL, double rating, Boolean noUrl) {
		super();
		this.name = name;
		this.path = path;
		this.reference = reference;
		this.opinion = opinion;
		this.original_creator = original_creator;
		this.deployedURL = deployedURL;
		this.rating = rating;
		this.noUrl = noUrl;
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getOriginal_creator() {
		return original_creator;
	}

	public void setOriginal_creator(String original_creator) {
		this.original_creator = original_creator;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Boolean getNoUrl() {
		return noUrl;
	}

	public void setNoUrl(Boolean noUrl) {
		this.noUrl = noUrl;
	}

	public String getDeployedURL() {
		return deployedURL;
	}

	public void setDeployedURL(String deployedURL) {
		this.deployedURL = deployedURL;
	}

}
