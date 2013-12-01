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
import com.coopnex.scrab.rest.exception.ResourceNotFoundException;
import com.coopnex.scrab.rest.resource.AbstractResource;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;
import com.coopnex.scrab.service.CrudService;

public abstract class RestController<T extends AbstractEntity<? extends Serializable>, PK extends Serializable,R extends AbstractResource<T>> {

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	R getById(@PathVariable PK id) {
		T entity = getService().read(id);
		if (entity==null) {
			throw new ResourceNotFoundException();
		}
		return getResourceAssembler().toResource(entity);

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<R> getAll() {
		List<T> entities = getService().readAll();
		return getResourceAssembler().toResources(entities);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	T create(@PathVariable long id, @RequestBody T element) {
		// FIXME: use id
		return getService().create(element);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody R element) {
		T entity = getResourceAssembler().toEntity(element);
		getService().create(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable PK id) {
		getService().delete(id);
	}

	protected abstract CrudService<T, PK> getService();
	protected abstract AbstractResourceAssembler<T, R> getResourceAssembler();

}
