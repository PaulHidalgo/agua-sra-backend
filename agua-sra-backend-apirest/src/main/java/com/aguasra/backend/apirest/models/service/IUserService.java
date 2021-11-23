package com.aguasra.backend.apirest.models.service;
import com.aguasra.backend.apirest.models.entity.User;

public interface IUserService {

	public User findByNameUser(String name_user);

}
