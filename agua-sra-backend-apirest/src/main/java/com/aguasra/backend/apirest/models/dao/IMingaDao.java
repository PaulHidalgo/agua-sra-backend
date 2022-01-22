package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Minga;

public interface IMingaDao extends CrudRepository<Minga, Long>{

}