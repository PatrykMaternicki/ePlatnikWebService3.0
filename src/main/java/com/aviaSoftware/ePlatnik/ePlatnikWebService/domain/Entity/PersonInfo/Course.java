package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Table (name="COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
