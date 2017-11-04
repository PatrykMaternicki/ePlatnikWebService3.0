package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
public class RaportOfWorkTest {

	private RaportOfWork raport;
	private ContextTestBuilder testBuilder;
	@Before
	public void setUp(){
		raport = new RaportOfWork();
		raport.setMonth(testBuilder.testInteger);
		raport.setWorkDays(testBuilder.testInteger);
		raport.setWorkHours(testBuilder.testInteger);
		raport.setYear(testBuilder.testInteger);
	}
	
	@Test
	public void getMonth_should_be_return_integer(){
		assertThat("Month in raportOfWork is not integer",raport.getMonth(),is(Integer.class));
	}
	
	@Test
	public void getWorkDays_should_be_return_integer(){
		assertThat("WorkDays in raportOfWork is not integer",raport.getWorkDays(),is(Integer.class));
	}
	
	@Test
	public void getWorkHours_should_be_return_integer(){
		assertThat("WorkHours in raportOfWork is not integer",raport.getWorkHours(),is(Integer.class));
	}
	@Test
	public void getYear_should_be_return_integer(){
		assertThat("Year in raportOfWork is not integer",raport.getYear(),is(Integer.class));
	}
	
}
