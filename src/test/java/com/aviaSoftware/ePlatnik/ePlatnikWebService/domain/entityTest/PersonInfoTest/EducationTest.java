package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class EducationTest {

	private Education education;
	private String testContent = "";
	private Integer testInteger = 0;
	
	@Before
	public void setUp(){
		education = new Education ();
		education.setEndYear(testInteger);
		education.setStartYear(testInteger);
		education.setNameSchool(testContent);
	}
	@Test
	public void endYear_should_be_integer(){
		assertThat("Field endYear in Education is not integer", education.getEndYear(),is(Integer.class));
	}
	public void startYear_should_be_integer(){
		assertThat("Field startYear in Education is not integer", education.getStartYear(),is(Integer.class));
		
	}
	public void nameSchool_should_be_string(){
		assertThat("Field endYear in Education is not String", education.getNameSchool(),is(String.class));
	}
	
	
}
