package com.portfolio.endpoints.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.domain.impl.About;
import com.portfolio.dto.AboutDTO;
import com.portfolio.dto.mapper.AboutDTOMapper;
import com.portfolio.endpoints.rest.model.CustomResponse;
import com.portfolio.service.AboutService;

@RestController
public class AboutREST {
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private AboutDTOMapper aboutDTOMapper;
	
	@GetMapping("/about/{language}/{id}")
	public ResponseEntity<AboutDTO> get(@PathVariable("id") Integer id, @PathVariable("language") String language) {
		About about = aboutService.findByIdAndLanguage(id, language);
		if (about != null) {
			return new ResponseEntity<>(aboutDTOMapper.toDTO(about, about.getTranslations().iterator().next().getLanguage()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/about/{id}")
	public ResponseEntity<About> get(@PathVariable("id") Integer id) {
		About about = aboutService.findById(id);
		if (about != null) {
			return new ResponseEntity<>(about, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/admin/about")
	public ResponseEntity<CustomResponse> post(@RequestBody About entity) {
		aboutService.save(entity);
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/about")
	public ResponseEntity<CustomResponse> put(@RequestBody About entity) {
		About aboutTranslation = aboutService.findById(entity.getId());
		if (aboutTranslation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else { 
			aboutService.save(entity);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}
	
}
