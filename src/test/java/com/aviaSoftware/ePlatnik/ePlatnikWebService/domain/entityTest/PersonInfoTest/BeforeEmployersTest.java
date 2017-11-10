package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BeforeEmployersTest extends HibernateSetup {

	private BeforeEmployers beforeEmployers;
	private BeforeEmployers entity;
	private ContextTestBuilder testBuilder;
	
	@Before
	public void setUp(){
		super.createPU();
		super.getEm().getTransaction().begin();
		beforeEmployers = new BeforeEmployers();
		beforeEmployers.setEndMonthWork(testBuilder.getContextMonth());
		beforeEmployers.setEndYearWork(testBuilder.getContextYear());
		beforeEmployers.setNameEmployers(testBuilder.testString);
		beforeEmployers.setStartMonthWork(testBuilder.getContextMonth());
		beforeEmployers.setStartYearWork(testBuilder.getContextYear());
		super.getEm().persist(beforeEmployers);
		super.getEm().getTransaction().commit();
		entity = super.getEm().find(BeforeEmployers.class,beforeEmployers.getId());
		
	}
	@Test
	public void getEndMonth_should_be_return_integer(){
		assertThat("Field endMonth in beforeEmployers is not integer",beforeEmployers.getEndMonthWork(),is(Integer.class));
	}
	@Test
	public void testPU_should_be_return_endMonth(){
		assertEquals("Column endMonth in beforeEmployers entity is not equal field endMonth in object beforeEmployers",
				beforeEmployers.getEndMonthWork(),
				entity.getEndMonthWork()
		);
	}
	@Test
	public void getEndYearWork_should_be_return_integer(){
		assertThat("Field endYearWork in beforeEmployers is not integer",beforeEmployers.getEndYearWork(),is(Integer.class));
	}

	@Test
	public void testPU_should_be_return_endYearWork(){
		assertEquals("Column endYearWork in beforeEmployers entity is not equal field endYearWork in object beforeEmployers",
				beforeEmployers.getEndYearWork(),
				entity.getEndYearWork()
		);
	}
	@Test
	public void getNameEmployers_should_be_return_string(){
		assertThat("Field nameEmployers in beforeEmployers is not String",beforeEmployers.getNameEmployers(),is(String.class));
	}
	@Test
	public void testPU_should_be_return_nameEmployers(){
		assertEquals("Column nameEmployers in beforeEmployers entity is not equal field nameEmployers in object beforeEmployers",
				beforeEmployers.getNameEmployers(),
				entity.getNameEmployers()
		);
	}
	@Test
	public void getStartMonthWork_should_be_return_interger(){
		assertThat("Field endMonth in beforeEmployers is not integer",beforeEmployers.getEndMonthWork(),is(Integer.class));
	}
	@Test
	public void testPU_should_be_return_startMonthWork(){
		assertEquals("Column startMonthWork in beforeEmployers entity is not equal field startMonthWork in object beforeEmployers",
				beforeEmployers.getStartMonthWork(),
				entity.getStartMonthWork()
		);
	}
	@Test
	public void getStartYearWork_should_be_return_integer(){
		assertThat("Field startYearWork in beforeEmployers is not string", beforeEmployers.getStartYearWork(), is(Integer.class));
	}

	@Test
	public void testPU_should_be_return_startYearWork(){
		assertEquals("Column startYearWork in beforeEmployers entity is not equal field startYearWork in object beforeEmployers",
				beforeEmployers.getStartYearWork(),
				entity.getStartYearWork()
		);
	}
}
