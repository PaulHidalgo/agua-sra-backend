package com.aguasra.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguasra.backend.apirest.models.entity.Parameter;
import com.aguasra.backend.apirest.models.service.ICrudService;

@RestController
@RequestMapping("/api")
public class ParameterRestController {
	
	@Autowired
	private ICrudService<Parameter> parameterService;
	
	

}
