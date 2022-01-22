package com.aguasra.backend.apirest.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.ReaderWater;

/**
 * @author PHidalgo
 *
 */

@RestController
@RequestMapping("/api")
public class ReaderWaterRestController extends CrudControllerAbstract<ReaderWater>{

	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/lecturas")
	@Override
	public ResponseEntity<?> findAll() {
		return super.findAll();
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/lecturas/{id}")
	@Override
	public ResponseEntity<?> findbyId(@PathVariable Long id) {
		return super.findbyId(id);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PostMapping("/lecturas/create")
	@Override
	public ResponseEntity<?> save(@Valid ReaderWater entity, BindingResult result) {
		return super.save(entity, result);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/lecturas/{id}")
	@Override
	public ResponseEntity<?> update(@Valid ReaderWater entity, BindingResult result, Long id) {
		return super.update(entity, result, id);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/lecturas/{id}")
	@Override
	public ResponseEntity<?> delete(Long id) {
		return super.delete(id);
	}
	
}