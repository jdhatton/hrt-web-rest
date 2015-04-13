package com.hrt.web.resources;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonResource {

	 
	ObjectMapper mapper = new ObjectMapper();

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}  

}
