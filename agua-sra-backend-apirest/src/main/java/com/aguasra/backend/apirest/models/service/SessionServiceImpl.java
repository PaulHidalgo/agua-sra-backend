package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.ISessionDao;
import com.aguasra.backend.apirest.models.entity.Session;

@Service
public class SessionServiceImpl implements ICrudService<Session>{

	@Autowired
	private ISessionDao sessionDao;
	
	@Override
	public List<Session> findAll() {
		return (List<Session>) sessionDao.findAll();
	}

	@Override
	public Session save(Session entity) {
		return sessionDao.save(entity);
	}

	@Override
	public Session findbyId(Long id) {
		return sessionDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		sessionDao.deleteById(id);
	}
	
	

}
