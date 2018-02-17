package com.portfolio.endpoints.rest;

import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.domain.impl.User;
import com.portfolio.endpoints.rest.model.CustomResponse;
import com.portfolio.service.UserService;

@RestController
@RequestMapping("/admin/user")
public class UserREST {
	
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping({"/id"} )
	public ResponseEntity<User> get(@PathVariable Integer id) {
		User user = userService.findById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({"/{username}"})
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		User user = userService.findByUsername(username);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<CustomResponse> post(@RequestBody User entity) {
		entity.setPassword(encoder.encode(entity.getPassword()));
		userService.save(entity);
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAll")
	public ResponseEntity<CustomResponse> put(@RequestBody List<User> entities) {
		List<User> checkedEntities = userService.findAll(entities.stream().map(User::getId).collect(Collectors.toList()));
		if (entities.size() == checkedEntities.size()) {
			userService.save(entities);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping()
	public ResponseEntity<CustomResponse> put(@RequestBody User entity) {
		User user = userService.findById(entity.getId());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			entity.setPassword(encoder.encode(entity.getPassword()));
			userService.save(entity);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<CustomResponse> delete(@PathVariable Integer id) {
		User user = userService.findById(id);
		if (null == user) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(user);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.findAll();
		if (null == users || users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}
	
}
