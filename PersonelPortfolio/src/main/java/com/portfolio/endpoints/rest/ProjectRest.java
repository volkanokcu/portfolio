package com.portfolio.endpoints.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.domain.impl.Project;
import com.portfolio.endpoints.rest.model.CustomResponse;
import com.portfolio.service.ProjectService;

@RestController
public class ProjectRest {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping("/admin/project")
	public ResponseEntity<CustomResponse> post(@RequestBody Project project) {
		projectService.save(project);
		return new ResponseEntity<CustomResponse>(new CustomResponse(HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}
	
}
