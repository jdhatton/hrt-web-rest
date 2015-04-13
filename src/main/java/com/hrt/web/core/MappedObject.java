package com.hrt.web.core;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MappedObject {

	ObjectMapper mapper = new ObjectMapper();

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}  
	
	

}
