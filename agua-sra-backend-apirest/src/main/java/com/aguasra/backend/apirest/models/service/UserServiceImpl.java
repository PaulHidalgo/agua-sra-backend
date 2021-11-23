package com.aguasra.backend.apirest.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aguasra.backend.apirest.models.dao.IUserDao;
import com.aguasra.backend.apirest.models.entity.Role;
import com.aguasra.backend.apirest.models.entity.User;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService, ICrudService<User> {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByNameUser(username);

		if (user == null) {
			logger.error("Error en el login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException(
					"Error en el login: no existe el usuario '" + username + "' en el sistema!");
		}

		logger.info("User: " + user.getNameUser());
		/*
		 * ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		 * authorities.add(new SimpleGrantedAuthority(user.getRole().getNameRole()));
		 */

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(user.getRole());

		List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getNameRole()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(user.getNameUser(), user.getPasswordUser(),
				user.getStateUser().equals("A"), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true) // Si se omite el transactional, se encarga el CrudRepository
	public User findByNameUser(String name_user) {
		return userDao.findByNameUser(name_user);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User save(User entity) {
		return userDao.save(entity);

	}

	@Override
	public User findbyId(Long id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

}
