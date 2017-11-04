package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import java.util.Date;

public class BeforeEmployers {

	private String nameEmployers;
	private int  startYearWork;
	private int endYearWork;
	private int endMonthWork;
	private int startMonthWork;
	public String getNameEmployers() {
		return nameEmployers;
	}
	public void setNameEmployers(String nameEmployers) {
		this.nameEmployers = nameEmployers;
	}
	public int getStartYearWork() {
		return startYearWork;
	}
	public void setStartYearWork(int startWork) {
		this.startYearWork = startWork;
	}
	public int getEndYearWork() {
		return endYearWork;
	}
	public void setEndYearWork(int endWork) {
		this.endYearWork = endWork;
	}
	public int getEndMonthWork() {
		return endMonthWork;
	}
	public void setEndMonthWork(int endMontWorkh) {
		this.endMonthWork = endMontWorkh;
	}
	public int getStartMonthWork() {
		return startMonthWork;
	}
	public void setStartMonthWork(int startMonthWork) {
		this.startMonthWork = startMonthWork;
	}
	
}
