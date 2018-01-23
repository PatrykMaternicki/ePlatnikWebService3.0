package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.DataTest.AccessSystemTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.User;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision.EmployeePermision;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision.iPermision;

/**
 * Testy jednostkowe klasy User. 
 * Sprawdzenie czy klasa User poprawnie generuje obiekty modeluj¹ce u¿ytkowników systemu 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUser extends Mockito {
	
	@Mock
	public iPermision employeePermision;
	
	@InjectMocks
	public User user;

	public TestUser() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Mock dla klas zale¿nych od klasy User
	 * 
	 */
	@Before
	public void setup(){
		user = new User();
		employeePermision = mock(EmployeePermision.class);
	}
	
	
	/**
	 * Test czy metody setPermision(Ipermision permision) i getPermission() operuj¹ na tym samym obiekcie 
	 */
	@Test
	public void testGetPermision_isMethodSetPermissionSetObject_true() {
		when(employeePermision.hadPermisionToAdministratorUI()).thenReturn(false);
		user.setPermision(employeePermision);
		assertThat(user.getPermision().hadPermisionToAdministratorUI()).isFalse();
	}
	
}
