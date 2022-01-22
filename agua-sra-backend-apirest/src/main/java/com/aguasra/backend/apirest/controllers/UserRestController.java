package com.aguasra.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.User;
import com.aguasra.backend.apirest.models.service.ICrudService;
import com.aguasra.backend.util.TypeErrorResponse;

/**
 * @author PHidalgo
 *
 */
@RestController
@RequestMapping("/api")
public class UserRestController extends CrudControllerAbstract<User>{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ICrudService<User> userService;
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/users")
	@Override
	public ResponseEntity<?> findAll() {
		return super.findAll();
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PostMapping("/users/create")
	@Override
	public ResponseEntity<?> save(@Valid @RequestBody User entity, BindingResult result) {
		return super.save(entity, result);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PutMapping("/users/change_password/{userId}/{oldPassword}")
	public ResponseEntity<?> updatePassword(@Valid @RequestBody User user, BindingResult result, @PathVariable Long userId, @PathVariable String oldPassword) {

		User userActual = userService.findbyId(userId);
		Map<String, Object> response = new HashMap<String, Object>();

		if (result.hasErrors()) {
			/*
			 * Before Java 8 List<String> errors = new ArrayList<>(); for (FieldError err :
			 * result.getFieldErrors()) { errors.add("EL campo '" + err.getField() + "' " +
			 * err.getDefaultMessage()); }
			 */

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "EL campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (userActual == null) {
			response.put("mensaje", "Error, no se encuentra resultados!!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		boolean isPasswordMatches = passwordEncoder.matches(oldPassword,userActual.getPasswordUser());
		
		if(!isPasswordMatches) {
			response.put("mensaje", "Error, No coincide la contraseña antigua");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			
			userActual.setPasswordUser(passwordEncoder.encode(user.getPasswordUser()));

			userService.save(userActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", " Error al actualizar en  base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("mensaje", "Contraseña actualizada correctamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
