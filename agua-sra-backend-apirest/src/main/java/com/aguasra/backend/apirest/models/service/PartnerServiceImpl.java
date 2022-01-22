package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IPartnerDao;
import com.aguasra.backend.apirest.models.entity.Partner;

@Service
public class PartnerServiceImpl implements ICrudService<Partner>{
	
	@Autowired
	private IPartnerDao partnerDao;

	@Override
	public List<Partner> findAll() {
		return (List<Partner>) partnerDao.findAll();
	}

	@Override
	public Partner save(Partner entity) {
		return partnerDao.save(entity);
	}

	@Override
	public Partner findbyId(Long id) {
		return partnerDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		partnerDao.deleteById(id);
	}

}
