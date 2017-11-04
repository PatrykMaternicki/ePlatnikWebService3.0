package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BeforeEmployersTest {

	private BeforeEmployers beforeEmployers;
	private ContextTestBuilder testBuilder;
	
	@Before
	public void setUp(){
		beforeEmployers = new BeforeEmployers();
		beforeEmployers.setEndMonthWork(testBuilder.getContextMonth());
		beforeEmployers.setEndYearWork(testBuilder.getContextYear());
		beforeEmployers.setNameEmployers(testBuilder.testString);
		beforeEmployers.setStartMonthWork(testBuilder.getContextMonth());
		beforeEmployers.setStartYearWork(testBuilder.getContextYear());
		
	}
	@Test
	public void getEndMonth_should_be_return_integer(){
		assertThat("Field endMonth in beforeEmployers is not integer",beforeEmployers.getEndMonthWork(),is(Integer.class));
	}
	@Test
	public void getEndYearWork_should_be_return_integer(){
		assertThat("Field endYearWork in beforeEmployers is not integer",beforeEmployers.getEndYearWork(),is(Integer.class));
	}
	@Test
	public void getNameEmployers_should_be_return_string(){
		assertThat("Field nameEmployers in beforeEmployers is not String",beforeEmployers.getNameEmployers(),is(String.class));
	}
	@Test
	public void getStartMonthWork_should_be_return_interger(){
		assertThat("Field endMonth in beforeEmployers is not integer",beforeEmployers.getEndMonthWork(),is(Integer.class));
	}
	@Test
	public void getStartYearWork_should_be_return_integer(){
		assertThat("Field startYearWork in beforeEmployers is not string", beforeEmployers.getStartYearWork(), is(Integer.class));
	}
}
