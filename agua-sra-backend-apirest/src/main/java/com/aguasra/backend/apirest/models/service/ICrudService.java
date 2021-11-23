package com.aguasra.backend.apirest.models.service;

import java.util.List;

public interface ICrudService<T> {

	public List<T> findAll();

	public T save(T entity);

	public T findbyId(Long id);

	public void delete(Long id);
}
