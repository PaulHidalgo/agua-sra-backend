package com.aguasra.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguasra.backend.apirest.models.dao.IRoleDao;
import com.aguasra.backend.apirest.models.entity.Role;

@Service
public class RoleServiceImpl implements ICrudService<Role> {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<Role> findAll() {
		return (List<Role>) roleDao.findAll();
	}

	@Override
	public Role save(Role entity) {
		return roleDao.save(entity);
	}

	@Override
	public Role findbyId(Long id) {
		return roleDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		roleDao.deleteById(id);
	}

}
