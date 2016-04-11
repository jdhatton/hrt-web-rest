package com.hrt.data.db.beans;

import java.util.Date;

public class ClassroomBehavior {

	private long Id;
	private long classRoomId;
	private long studentId;
	private long behaviorId;
	private int trackingInterval;
	private int status;
	private Date beginDate;
	private Date endDate;
	private Date lastModifiedDate;
	private String lastModifiedBy;
	private String behavior;
	
	public ClassroomBehavior() { }

	public ClassroomBehavior(long classRoomId, long studentId, long behaviorId, int trackingInterval, int status,
			Date beginDate, Date endDate, Date lastModifiedDate, String lastModifiedBy, String behavior) {
		super();
		this.classRoomId = classRoomId;
		this.studentId = studentId;
		this.behaviorId = behaviorId;
		this.trackingInterval = trackingInterval;
		this.status = status;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.behavior = behavior;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getBehaviorId() {
		return behaviorId;
	}

	public void setBehaviorId(long behaviorId) {
		this.behaviorId = behaviorId;
	}

	public int getTrackingInterval() {
		return trackingInterval;
	}

	public void setTrackingInterval(int trackingInterval) {
		this.trackingInterval = trackingInterval;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	
	

}
