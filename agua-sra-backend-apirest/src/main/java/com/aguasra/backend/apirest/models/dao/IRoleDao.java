package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long> {

}
