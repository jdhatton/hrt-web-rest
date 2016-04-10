package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.Classroom;

public interface ClassroomService {

	public List<Classroom> getAllClassrooms() ;
	
	public Classroom getClassroom( long Id);
	
	public long addClassroom(Classroom classroom);
	
	//
	// TODO: go ahead and add the other classroom tables here also.
	//
	//   - ClassroomBehaviors
	//   - ClassroomParents
	//   - ClassroomStudents
	//
}
