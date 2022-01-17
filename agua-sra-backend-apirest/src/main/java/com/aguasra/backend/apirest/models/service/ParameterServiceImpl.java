package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IParameterDao;
import com.aguasra.backend.apirest.models.entity.Parameter;

@Service
public class ParameterServiceImpl implements ICrudService<Parameter>{
	
	@Autowired
	private IParameterDao parameterDao;

	@Override
	public List<Parameter> findAll() {
		return (List<Parameter>) parameterDao.findAll();
	}

	@Override
	public Parameter save(Parameter entity) {
		return parameterDao.save(entity);
	}

	@Override
	public Parameter findbyId(Long id) {
		return parameterDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		parameterDao.deleteById(id);
	}

}
