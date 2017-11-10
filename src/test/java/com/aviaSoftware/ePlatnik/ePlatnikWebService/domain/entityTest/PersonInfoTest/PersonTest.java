package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.PersonInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.Hibernate;
import com.sun.org.apache.xerces.internal.impl.dv.xs.AbstractDateTimeDV;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
@RunWith(MockitoJUnitRunner.class)
public class PersonTest extends Mockito {

	
	private PersonInformation personInformation;
	private Address address;
	private Hibernate hibernate;
	private EntityManager em;
	private Person entity;
	private Person persistedPerson;
	@Mock
	Person person;
	@Before
	public void setUp(){
		personInformation = new PersonInformation();
		address = new Address();
		address.setCountry("Poland");
		address.setCity("Gdansk");
		address.setFlatNumber(1);
		address.setPostalCode("83-010");
		address.setStreet("ul.nowozenska2");
		persistedPerson = new Person();
		hibernate = new Hibernate();
		hibernate.createPU();
		em = hibernate.getEm();
		em.getTransaction().begin();
		persistedPerson.setAdress(address);
		persistedPerson.setInformation(personInformation);
		em.persist(persistedPerson);
		em.getTransaction().commit();

	}
	@After
	public void closeConnection(){
		em.close();
	}
	@Test
	public void should_be_return_personInformation_when_called_super_method_getInformation(){
		when(person.getInformation()).thenReturn(personInformation);
	}
	@Test
	public void should_be_return_address_when_called_super_method_getAddress(){
		when(person.getAdress()).thenReturn(address);
	}
	@Test
	public void testPU_should_be_return_address_object(){
		Query query = em.createQuery("select p.adress from Person as p where p.id = " + persistedPerson.getId());
		Address addressEntity = (Address) query.getSingleResult();
		assertThat("testPU doesnt return object address",address,is(Address.class));
	}
	@Test
	public void testPU_should_be_return_personInfromation_object(){
		Query query = em.createQuery("select p.information from Person as p where p.id = " + persistedPerson.getId());
		PersonInformation personInformationEntity = (PersonInformation) query.getSingleResult();
		assertThat("testPU doesnt return object address",personInformationEntity,is(PersonInformation.class));
	}
	@Test
	public void _forgeinKey_ADDRESS_ID_in_table_Person_is_equal_for_key_id_in_table_address(){
		Query query = em.createQuery("select p.adress from Person as p where p.id = " + persistedPerson.getId());
		Address addressEntity = (Address) query.getSingleResult();
		Query queryAddress = em.createQuery("select a.id from Address as a where a.id= " + addressEntity.getId());
		Address equalsAddressEntity = (Address) query.getSingleResult();
		assertEquals("Forgein key address_id in Person table is not equal key for address table",addressEntity.getId(), equalsAddressEntity.getId());
	}
	@Test
	public void forgienKey_PERSON_INFORMATION_ID_in_table_Person_is_equal_for_key_id_in_table_PERSON_INFORMATION(){
		Query query = em.createQuery("select p.information from Person as p where p.id = " + persistedPerson.getId());
		PersonInformation personInformationEntity = (PersonInformation) query.getSingleResult();
		Query queryAddress = em.createQuery("select pi.id from PersonInformation as pi where pi.id= " + personInformationEntity.getId());
		PersonInformation equalsPersonInformationEntity = (PersonInformation) query.getSingleResult();
		assertEquals("Forgein key person_information_id in Person table is not equal key for PERSON_INFORMATION table", personInformationEntity.getId(), equalsPersonInformationEntity.getId());
	}
	

}
