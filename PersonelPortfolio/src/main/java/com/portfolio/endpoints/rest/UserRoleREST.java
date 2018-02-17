package com.portfolio.endpoints.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.domain.impl.UserRole;
import com.portfolio.service.UserRoleService;

@RestController
@RequestMapping("/admin/userrole")
public class UserRoleREST {
	
	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserRole> get(@PathVariable Integer id) {
		UserRole userRole = userRoleService.findById(id);
		if (null != userRole) {
			return new ResponseEntity<>(userRole, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody UserRole entity) {
		userRoleService.save(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> put(@RequestBody UserRole entity) {
		UserRole userRole = userRoleService.findById(entity.getId());
		if (null == userRole) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userRoleService.save(entity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserRole>> getAll() {
		List<UserRole> userRoles = userRoleService.findAll();
		if (null == userRoles || userRoles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(userRoles, HttpStatus.OK);
		}
	}

}
