package com.coopnex.scrab.rest.resource;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import com.coopnex.scrab.data.entity.AbstractEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResource<T extends AbstractEntity<? extends Serializable>>
		extends ResourceSupport {

	public AbstractResource() {
		super();
	}

}
