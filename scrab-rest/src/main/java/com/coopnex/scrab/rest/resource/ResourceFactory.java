package com.coopnex.scrab.rest.resource;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.coopnex.scrab.data.entity.AbstractEntity;

public class ResourceFactory {
	
	static Map<Class, Class> classMap = new HashMap<Class, Class>();
//	public static AbstractResource createResource(AbstractEntity<? extends Serializable>entity){
//		Class resourceClass = classMap.get(entity.getClass());
//		return resourceClass.getConstructors()
//	}
//	public void register(Class arg0, Class arg1) {
//		classMap.put(arg0, arg1);
//	}
	
}
