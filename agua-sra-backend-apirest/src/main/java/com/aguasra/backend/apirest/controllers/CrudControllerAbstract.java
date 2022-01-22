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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.aguasra.backend.apirest.models.service.ICrudService;
import com.aguasra.backend.util.TypeErrorResponse;

public abstract class CrudControllerAbstract<T> implements ICrudController<T>{
	
	@Autowired
	private ICrudService<T> crudService;
	
	@Override
	public ResponseEntity<?> findAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		List<?> entities=null;
		try {
			entities = crudService.findAll();
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_READ.getReasonPhrase());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("content", entities);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(@Valid @RequestBody T entity, BindingResult result){
		T entityNew = null;
		Map<String, Object> response = new HashMap<String, Object>();
		if (result.hasErrors()) {
	
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "EL campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
	
			response.put("errors", errors);
	
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			entityNew = crudService.save(entity);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_CREATE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_CREATE.getReasonPhrase());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("message", " Se ha creado con éxito!");
		response.put("content", entityNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> update(@Valid @RequestBody T entity, BindingResult result, @PathVariable Long id){

		T entityActual = crudService.findbyId(id);
		T entityUpdated = null;

		Map<String, Object> response = new HashMap<String, Object>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "EL campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (entityActual == null) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", "Error: no se pudo editar, el role ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			entityActual = (T) UtilUpdateEntities.entityUpdated(entityActual, entity);

			entityUpdated = crudService.save(entityActual);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_UPDATE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_UPDATE.getReasonPhrase());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("message", "Entidad actualizada con éxito!");
		response.put("content", entityUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findbyId(@PathVariable Long id){
		T entity = null;
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			entity = crudService.findbyId(id);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_READ.getReasonPhrase());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (entity == null) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_READ.getValue());
			response.put("message", "La entidad con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("content", entity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			crudService.delete(id);
		} catch (DataAccessException e) {
			response.put("code", TypeErrorResponse.ERROR_DATABASE_DELETE.getValue());
			response.put("message", TypeErrorResponse.ERROR_DATABASE_DELETE.getReasonPhrase());
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("code", TypeErrorResponse.CORRECT_RESPONSE.getValue());
		response.put("message", "Entidad eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
