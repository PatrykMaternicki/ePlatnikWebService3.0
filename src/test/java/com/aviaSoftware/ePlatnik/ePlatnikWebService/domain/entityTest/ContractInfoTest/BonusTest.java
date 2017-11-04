package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BonusTest {

	private Bonus bonus;
	private ContextTestBuilder testBuilder;
	
	@Before
	public void setUp(){
		bonus = new Bonus();
		bonus.setItemBonus(testBuilder.testString);
		bonus.setPercentBonus(testBuilder.testDouble);
		bonus.setTypeBonus(testBuilder.testString);
		bonus.setValue(testBuilder.testDouble);
	}
	@Test
	public void getItemBonus_should_be_return_string(){
		assertThat("ItemBonus in Bonus is not String",bonus.getItemBonus(), is(String.class));
	}
	
	@Test
	public void getPercentBonus_should_be_return_double(){
		assertThat("PercentBonus in Bonus is not double",bonus.getPercentBonus(), is(Double.class));
	}
	
	@Test
	public void getTypeBonus_should_be_return_string(){
		assertThat("TypeBonus in Bonus is not String",bonus.getTypeBonus(), is(String.class));
	}
	
	@Test
	public void getValue_should_be_return_double(){
		assertThat("ItemBonus in Bonus is not String",bonus.getValue(), is(Double.class));
	}
	
}
