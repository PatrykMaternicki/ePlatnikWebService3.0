package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

public class Course {
	private String nameCourse;
	private int expiredTime;
	private boolean isRequiredToWork;
	public String getNameCourse() {
		return nameCourse;
	}
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}
	public int getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(int expiredTime) {
		this.expiredTime = expiredTime;
	}
	public boolean isRequiredToWork() {
		return isRequiredToWork;
	}
	public void setRequiredToWork(boolean isRequiredToWork) {
		this.isRequiredToWork = isRequiredToWork;
	}
	
	
}
