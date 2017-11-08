package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.*;
public class AddressTest extends HibernateSetup {

    private Address entity;
    private EntityManager em;
	private Address address;
	@Before 
	public void Test(){
        super.createPU();
        em = super.getEm();
		address = new Address();
		address.setCountry("Poland");
		address.setCity("Gdansk");
		address.setFlatNumber(1);
		address.setPostalCode("83-010");
		address.setStreet("ul.nowozenska2");
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        entity = em.find(Address.class, address.getId());
        em.close();
	}
	
	@Test
	public void should_be_country_is_string(){
		assertThat("Field country in Address is not string",address.getCountry(),is(String.class));
	}
	@Test
    public void testPU_should_be_return_country(){
	    assertEquals("Entity address column country is not equal country in Address object",address.getCountry(),entity.getCountry());
    }
	@Test
	public void should_be_city_is_string(){
		assertThat("Field City in Address is not string",address.getCity(),is(String.class));
	}
	@Test
    public void testPU_should_be_return_city(){
	    assertEquals("Entity address column city is not equal city on object",address.getCity(),entity.getCity());
    }
	@Test
	public void should_be_flatNumber_is_Integer(){
		assertThat("Field flatNumber in Address is not integer",address.getFlatNumber(),is(Integer.class));
	}
	@Test
    public void testPU_should_be_return_flatNumber(){
        assertEquals("Entity address column flatNumber is not equal flatNumber in Address object",address.getFlatNumber(),entity.getFlatNumber());
    }
	@Test
	public void should_be_postalCode_is_istring(){
		assertThat("Field postalCode in Address is not string",address.getPostalCode(),is(String.class));
	}
	@Test
	public void testPU_should_be_return_postalCode(){
        assertEquals("Entity address column postalCode is not equal postalCode in Address object",address.getPostalCode(),entity.getPostalCode());
    }
	@Test
	public void should_be_street_is_Integer(){
		assertThat("Field street in Address is not string",address.getStreet(),is(String.class));
	}
	@Test
    public void testPU_should_be_return_street(){
        assertEquals("Entity address column street is not equal street in Address object",address.getStreet(),entity.getStreet());
    }

}
