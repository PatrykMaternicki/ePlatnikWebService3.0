package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import java.util.ArrayList;

public class Person1 {
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	private Address adress = new Address();
	private PersonInformation information = new PersonInformation();
	public PersonInformation getInformation() {
		return information;
	}
	public void setInformation(PersonInformation information) {
		this.information = information;
	}
	public ArrayList<Education> getEducationList() {
		return educationList;
	}
	public void setEducationList(ArrayList<Education> educationList) {
		this.educationList = educationList;
	}

	private ArrayList<Education> educationList;
	
}
