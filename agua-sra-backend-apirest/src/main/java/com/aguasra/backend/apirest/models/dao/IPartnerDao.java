package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.Partner;

public interface IPartnerDao extends CrudRepository<Partner, Long> {

}
