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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.Role;
import com.aguasra.backend.apirest.models.service.ICrudService;
import com.aguasra.backend.util.TypeErrorResponse;

/**
 * @author PHidalgo
 *
 */
@RestController
@RequestMapping("/api")
public class RoleRestController {

	@Autowired
	private ICrudService<Role> roleService;

	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/roles")
	public ResponseEntity<?> index() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Role> roles=null;
		try {
			roles = roleService.findAll();
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_READ);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("content", roles);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/roles/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Role role = null;
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			role = roleService.findbyId(id);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_READ);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (role == null) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", "El role ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("content", role);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PostMapping("/roles/crear")
	public ResponseEntity<?> create_role(@Valid @RequestBody Role role, BindingResult result) {
		Role roleNew = null;
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
		try {
			roleNew = roleService.save(role);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_CREATE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_CREATE);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("mensaje", " El role ha sido creado con éxito!");
		response.put("role", roleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/roles/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Role role, BindingResult result, @PathVariable Long id) {

		Role roleActual = roleService.findbyId(id);
		Role roleUpdated = null;

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

		if (roleActual == null) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", "Error: no se pudo editar, el role ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			roleActual.setNameRole(role.getNameRole());
			roleActual.setStateRole(role.getStateRole());
			roleActual.setDateCreateRole(role.getDateCreateRole());

			roleUpdated = roleService.save(roleActual);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_UPDATE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_UPDATE.getValue());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("message", " El role ha sido actualizado con éxito!");
		response.put("role", roleUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			roleService.delete(id);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_DELETE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_DELETE);
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("message", " El role ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
