package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Parameter;

public interface IParameterDao extends CrudRepository<Parameter, Long>{

}
