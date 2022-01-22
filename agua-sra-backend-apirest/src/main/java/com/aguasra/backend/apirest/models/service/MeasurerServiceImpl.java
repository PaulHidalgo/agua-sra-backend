package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IMeasurerDao;
import com.aguasra.backend.apirest.models.entity.Measurer;

@Service
public class MeasurerServiceImpl implements ICrudService<Measurer>{
	
	@Autowired
	private IMeasurerDao measurerDao;

	@Override
	public List<Measurer> findAll() {
		return (List<Measurer>) measurerDao.findAll();
	}

	@Override
	public Measurer save(Measurer entity) {
		return measurerDao.save(entity);
	}

	@Override
	public Measurer findbyId(Long id) {
		return measurerDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		measurerDao.deleteById(id);
	}

}
