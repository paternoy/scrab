package com.coopnex.scrab.rest.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coopnex.scrab.data.entity.AbstractEntity;
import com.coopnex.scrab.data.repository.AbstractRepository;

public abstract class CrudRepositoryRestController<T extends AbstractEntity<PK>,PK extends Serializable> {
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	T getById(@PathVariable PK id) {
		return getRepository().findOne(id);

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<T> getAll() {
		return getRepository().findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	T create(@PathVariable long id,@RequestBody T element) {
		return getRepository().saveAndFlush(element);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable PK id) {
		getRepository().delete(id);
	}

	public abstract AbstractRepository<T, PK> getRepository();
	
}
