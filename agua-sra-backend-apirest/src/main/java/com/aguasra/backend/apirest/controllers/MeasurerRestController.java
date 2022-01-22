package com.aguasra.backend.apirest.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.Measurer;

/**
 * @author PHidalgo
 *
 */
@RestController
@RequestMapping("/api")
public class MeasurerRestController extends CrudControllerAbstract<Measurer> {

	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/medidores")
	@Override
	public ResponseEntity<?> findAll() {
		return super.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PostMapping("/medidores/create")
	@Override
	public ResponseEntity<?> save(@Valid Measurer entity, BindingResult result) {
		return super.save(entity, result);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/medidores/{id}")
	@Override
	public ResponseEntity<?> update(@Valid Measurer entity, BindingResult result, Long id) {
		return super.update(entity, result, id);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/medidores/{id}")
	@Override
	public ResponseEntity<?> findbyId(Long id) {
		return super.findbyId(id);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/medidores/{id}")
	@Override
	public ResponseEntity<?> delete(Long id) {
		return super.delete(id);
	}	

}
