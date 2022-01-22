package com.aguasra.backend.apirest.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICrudController <T> {

	public ResponseEntity<?> findAll();

	public ResponseEntity<?> save(@Valid @RequestBody T entity, BindingResult result);
	
	public ResponseEntity<?> update(@Valid @RequestBody T entity, BindingResult result, @PathVariable Long id);

	public ResponseEntity<?> findbyId(@PathVariable Long id);

	public ResponseEntity<?> delete(@PathVariable Long id);
}
