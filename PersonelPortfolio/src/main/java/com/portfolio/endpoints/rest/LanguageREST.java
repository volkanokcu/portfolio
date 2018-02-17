package com.portfolio.endpoints.rest;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.domain.impl.Language;
import com.portfolio.service.LanguageService;

@RestController
@RequestMapping("/admin/language")
public class LanguageREST {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Language> findById(@PathVariable("id") Integer id) {
		Language language = languageService.findById(id);
		return new ResponseEntity<>(language, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Language language) {
		language.setName(WordUtils.capitalize(language.getName()));
		languageService.save(language);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Language>> getAll() {
		List<Language> languages = languageService.findAll();
		if (null == languages || languages.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else return new ResponseEntity<>(languages, HttpStatus.OK);
	}
	
	
}
