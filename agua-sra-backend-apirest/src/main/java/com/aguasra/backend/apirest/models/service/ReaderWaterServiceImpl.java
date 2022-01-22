package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IReaderWaterDao;
import com.aguasra.backend.apirest.models.entity.ReaderWater;

@Service
public class ReaderWaterServiceImpl implements ICrudService<ReaderWater>{
	
	@Autowired
	private IReaderWaterDao readerWaterDao;

	@Override
	public List<ReaderWater> findAll() {
		return (List<ReaderWater>) readerWaterDao.findAll();
	}

	@Override
	public ReaderWater save(ReaderWater entity) {
		return readerWaterDao.save(entity);
	}

	@Override
	public ReaderWater findbyId(Long id) {
		return readerWaterDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		readerWaterDao.deleteById(id);
	}

}
