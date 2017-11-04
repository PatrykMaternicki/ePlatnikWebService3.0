package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import org.junit.Before;
import org.junit.Test;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.SetupsToTest.*;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.*;
public class AddressTest extends HibernateSetup {

	private Address address;
	@Before 
	public void Test(){
		
		address = new Address();
		address.setCountry("Poland");
		address.setCity("Gdansk");
		address.setFlatNumber(1);
		address.setPostalCode("83-010");
		address.setStreet("ul.nowozenska2");
		
	}
	
	@Test
	public void should_be_country_is_string(){
		EntityManager em = Persistence.createEntityManagerFactory("tutorialPU").createEntityManager();
		//em.getTransaction().begin();
		//em.persist(address);
		//em.getTransaction().commit();
		//Address foundAddress = em.find(Address.class, address.getId());
		//assertEquals("Field country in Address is not string",foundAddress.getCountry(),is(String.class));
		//em.close();
	}
	/*
	@Test
	public void should_be_city_is_string(){
		assertThat("Field City in Address is not string",address.getCity(),is(String.class));

	}
	@Test
	public void should_be_flatNumber_is_Integer(){
		assertThat("Field flatNumber in Address is not integer",address.getFlatNumber(),is(Integer.class));

	}
	@Test
	public void should_be_postalCode_is_istring(){
		assertThat("Field postalCode in Address is not string",address.getPostalCode(),is(String.class));

	}
	@Test
	public void should_be_street_is_Integer(){
		assertThat("Field street in Address is not string",address.getStreet(),is(String.class));
	
	}
	*/
	
}
