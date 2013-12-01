package com.coopnex.scrab.data.entity;

import java.io.Serializable;

public abstract class AbstractEntity<PK extends Serializable> {
	
	public AbstractEntity() {
		super();
	}
	
	public abstract PK getId();

}
