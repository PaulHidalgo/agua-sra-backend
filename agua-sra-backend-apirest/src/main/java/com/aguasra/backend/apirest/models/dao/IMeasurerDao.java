package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Measurer;

public interface IMeasurerDao extends CrudRepository<Measurer, Long>{

}
