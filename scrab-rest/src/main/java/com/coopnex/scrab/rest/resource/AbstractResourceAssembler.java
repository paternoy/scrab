package com.coopnex.scrab.rest.resource;

import java.io.Serializable;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.coopnex.scrab.data.entity.AbstractEntity;

public abstract class AbstractResourceAssembler<E extends AbstractEntity<? extends Serializable>, R extends AbstractResource>
		extends ResourceAssemblerSupport<E, R> {

	public AbstractResourceAssembler(Class controllerClass,Class entityClass ) {
		super(controllerClass, entityClass);
	}

	@Override
	public R toResource(E entity) {
		// will add also a link with rel self pointing itself
		R resource = createResourceWithId(entity.getId(), entity);
		// adding a link with rel books pointing to the author's books
		// resource.add(linkTo(methodOn(AuthorController.class).getAuthorBooks(author.getAuthorId())).withRel("books"));
		return resource;
	}
	
	public abstract E toEntity(R resource);

//	@Override
//	protected R instantiateResource(E entity) {
//		return (R)ResourceFactory.createResource(entity);
//	}
//	private Class getControllerClass(){
//		return (Class<CrudController<E, Serializable>>) ((ParameterizedType) getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0];
//	}
	
	
}