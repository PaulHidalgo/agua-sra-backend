package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IMingaDao;
import com.aguasra.backend.apirest.models.entity.Minga;

@Service
public class MingaServiceImpl implements ICrudService<Minga>{

	@Autowired
	private IMingaDao mingaDao;
	
	@Override
	public List<Minga> findAll() {
		return (List<Minga>) mingaDao.findAll();
	}

	@Override
	public Minga save(Minga entity) {
		return mingaDao.save(entity);
	}

	@Override
	public Minga findbyId(Long id) {
		return mingaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		mingaDao.deleteById(id);
	}

}
