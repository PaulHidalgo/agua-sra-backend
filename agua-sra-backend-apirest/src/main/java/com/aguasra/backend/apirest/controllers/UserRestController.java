package com.aguasra.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.User;
import com.aguasra.backend.apirest.models.service.ICrudService;

/**
 * @author PHidalgo
 *
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private ICrudService<User> userService;
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/users")
	public List<User> index() {
		return userService.findAll();
	}

}
