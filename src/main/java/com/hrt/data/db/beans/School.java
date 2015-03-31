package com.hrt.data.db.beans;

import java.util.List;

import com.hrt.data.db.enums.SchoolType;

public class School {

	private String zipCode;
	private String name;
	private District district;
	private SchoolType type;
	private List<Classroom> classRooms;
	
	
	
	public School() { }

}
