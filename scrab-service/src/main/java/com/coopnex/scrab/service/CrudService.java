package com.coopnex.scrab.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class CrudService<T, PK extends Serializable> {

	@Transactional
	public T create(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Transactional
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Transactional
	public void delete(PK entity) {
		getRepository().delete(entity);
	}

	@Transactional
	public T read(PK id) {
		return getRepository().findOne(id);
	}

	@Transactional
	public T save(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Transactional
	public List<T> readAll() {
		return getRepository().findAll();
	}

	protected abstract JpaRepository<T, PK> getRepository();

}
