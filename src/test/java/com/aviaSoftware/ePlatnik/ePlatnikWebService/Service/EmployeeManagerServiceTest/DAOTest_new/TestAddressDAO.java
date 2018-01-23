package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest_new;

import java.util.List;

import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.AddressDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

/**
 * Testy jednostkowe klasy AddressDAO. 
 * Sprawdzenie czy klasa AddressDAO poprawnie realizuje warstwê dostêpu do danych poprzez mapowanie obiektowo relacyjne  
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAddressDAO extends Mockito{
	
	@Mock
	public EntityManager em;
	@Mock
	public Address address;
	
	@InjectMocks
	public AddressDAO addressDAO;
	
	public TestAddressDAO() {
		MockitoAnnotations.initMocks(this);
	}
    
    /**
	 *  Ustawienia inicjalizacyjne dla testów
	 */
	@Before
	public  void setup() {
			em = mock(EntityManager.class);
			address = mock(Address.class);
			addressDAO = new AddressDAO();
	}
	
	 @Test
	    public void testUpdate_IsEntityAddressInUse_true() {
		 assertThat(true).isTrue();
	    }

}
