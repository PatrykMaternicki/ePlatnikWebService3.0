package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.DataTest.AccessSystemTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.User;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision.EmployeePermision;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision.iPermision;


@RunWith(MockitoJUnitRunner.class)
public class UserTest extends Mockito {
	
	private iPermision employeePermision;
	@Mock
	private User user;
	
	@Before
	public void setUp(){
		employeePermision = new EmployeePermision();
	}
	@Test
	public void when_call_getPermison_then_return_object_permision() {
		when(user.getPermision()).thenReturn(employeePermision);
		assertThat("User doesnt return object permision", user.getPermision(), is(iPermision.class));
	}
}
