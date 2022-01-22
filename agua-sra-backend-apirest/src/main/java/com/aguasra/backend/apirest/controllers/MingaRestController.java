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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.Minga;

@RestController
@RequestMapping("/api")
public class MingaRestController extends CrudControllerAbstract<Minga>{
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@GetMapping("/mingas")
	@Override
	public ResponseEntity<?> findAll() {
		return super.findAll();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/mingas/{id}")
	@Override
	public ResponseEntity<?> findbyId(@PathVariable Long id) {
		return super.findbyId(id);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PostMapping("/mingas/create")
	@Override
	public ResponseEntity<?> save(@Valid @RequestBody Minga entity, BindingResult result) {
		return super.save(entity, result);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_PRESIDENT" })
	@PutMapping("/mingas/{id}")
	@Override
	public ResponseEntity<?> update(@Valid @RequestBody Minga entity, BindingResult result, @PathVariable Long id) {
		return super.update(entity, result, id);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/mingas/{id}")
	@Override
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return super.delete(id);
	}
}
