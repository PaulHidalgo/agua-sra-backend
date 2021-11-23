package com.aguasra.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.aguasra.backend.apirest.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {

	// @Query("select u from User u where u.username=?1")
	// public User findByName_user2(String name_user);

	public User findByNameUser(String name_user);

}
