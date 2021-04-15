package com.biglolPage.introducingBiglolPage.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectsNotFoundException extends RuntimeException {
	public ProjectsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
