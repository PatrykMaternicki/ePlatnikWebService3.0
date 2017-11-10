package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class EducationTest extends HibernateSetup {

	private Education education;
	private Education entity;
	private String testContent = "cos";
	private Integer testInteger = 0;

	@Before
	public void setUp(){
		super.createPU();
		super.getEm();
		education = new Education ();
		education.setEndYear(testInteger);
		education.setStartYear(testInteger);
		education.setNameSchool(testContent);
		super.getEm().getTransaction().begin();
		super.getEm().persist(education);
		super.getEm().getTransaction().commit();
		entity = super.getEm().find(Education.class,education.getId());
		super.getEm().close();
	}
	@Test
	public void endYear_should_be_integer(){
		assertThat("Field endYear in Education is not integer", education.getEndYear(),is(Integer.class));
	}
	@Test
	public void testPU_should_be_return_endYear(){
		assertEquals("Column endYear in table educaton is not equal endYear in Education Object",
				education.getEndYear(),
				entity.getEndYear()
		);
	}
	@Test
	public void startYear_should_be_integer(){
		assertThat("Field startYear in Education is not integer", education.getStartYear(),is(Integer.class));
	}
	@Test
	public void testPU_should_be_return_startYear(){
		assertEquals("Column startYear in table educaton is not equal startYear in Education Object",
				education.getStartYear(),
				entity.getStartYear()
		);
	}
	@Test
	public void nameSchool_should_be_string(){
		assertThat("Field endYear in Education is not String", education.getNameSchool(),is(String.class));
	}
	@Test
	public void testPU_should_be_return_nameSchool(){
		assertEquals("Column nameSchool in table educaton is not equal nameSchool in Education Object",
				education.getNameSchool(),
				entity.getNameSchool()
		);
	}

}