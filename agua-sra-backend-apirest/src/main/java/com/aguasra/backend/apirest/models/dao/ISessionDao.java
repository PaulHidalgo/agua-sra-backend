package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Session;

public interface ISessionDao extends CrudRepository<Session, Long> {

}
